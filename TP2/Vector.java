public class Vector {
    private int n; // taille du tableau
    private Rational[] tab; // tableau de rationnels

    // Constructeur
    public Vector(int n, Rational[] tab) {
        this.n = n;
        this.tab = new Rational[n];
    }
    
    public String toString_vector() {
        String result = "( ";
        for (int i = 0; i<n-1; i++){
            result += tab[i].toString() + " , ";
        }
        result += tab[n-1].toString() + " )";
        return result;
    }

    public void set(int i, Rational r){
        if (i<0 || i>=n){
            throw new IndexOutOfBoundsException("Index hors limites");
        }
        this.tab[i] = new Rational(r);
    }

    public Rational get(int i) {
        if (i<0 || i>=n){
            throw new IndexOutOfBoundsException("Index hors limites");
        }
        return new Rational(this.tab[i]);
    }

    public void mult_vector_rational(Rational r){
        // for (Rational r2: tab){ !!! c'est une copie de la référence, ça ne modifie pas tab !!!
        //     r2.mult(r);
        // }
        for (int i=0; i<n; i++){
            this.tab[i].mult(r);
        }
    }

    public void add_vector_vector(Vector v){
        if (this.n != v.n){
            throw new IllegalArgumentException("Les deux vecteurs doivent avoir la même taille");
        }
        for (int i=0; i<n; i++){
            this.tab[i].addition(v.get(i));
        }

    }
}