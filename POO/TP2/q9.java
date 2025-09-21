public class q9 {
    public static void main(String[] args){
        // Rational r1 = new Rational(0, 1);
        // Rational r2 = new Rational(0, 1);
        // int n = 2;
        // Rational[] tab = new Rational[n];
        // Vector v = new Vector(n, tab);
        // v.set(0, r1);
        // v.set(1, r2);
        // Rational a =new Rational(2,3);
        // v.set(0, a);
        // System.out.println(v.toString_vector());
        // Rational b = new Rational(3, 2);
        // a.mult(b);
        // System.out.println(v.toString_vector());

        int n = 2;
        Vector v = new Vector(n, new Rational[n]);
        v.set(0, new Rational(1,2));
        v.set(1, new Rational(1,2));
        System.out.println(v.toString_vector());
        Rational a = v.get(0);
        a.mult(new Rational(1,3));
        System.out.println(v.toString_vector());

        }
}


// les variables d’objets contiennent des références et non des copies !! 
// modifier a modifie aussi v[0]


// Resoudre ce prb :


// 1. dans Rational, on ajoute un constructeur de copie
    // // Constructeur normal
    // public Rational(int num, int denom) {
    //     if (denom == 0) throw new IllegalArgumentException("Denom cannot be 0");
    //     this.num = num;
    //     this.denom = denom;
    //     simplifier();
    // }

    // // Constructeur de copie
    // public Rational(Rational other) {  // <-- ici "other" est l'objet qu'on veut copier
    //     this.num = other.num;
    //     this.denom = other.denom;
    // }


// 2. dans Vector, on modifie set pour faire une copie de r avant de l'affecter dans tab
    // public void set(int i, Rational r){
    //     if (i<0 || i>=n){
    //         throw new IndexOutOfBoundsException("Index hors limites");
    //     }
    //     this.tab[i] = new Rational(r); // <-- ici on utilise le constructeur de copie
    // }


// pour la qst du get :
//     public Rational get(int i) {
    //     if (i<0 || i>=n){
    //         throw new IndexOutOfBoundsException("Index hors limites");
    //     }
    //     return new Rational(this.tab[i]); <-- !!!
    // }