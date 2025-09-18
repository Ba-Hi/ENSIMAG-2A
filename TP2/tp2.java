class Rational {
    private int num;
    private int denom;

    // Constructeur
    public Rational(int num, int denom) {
        if (denom == 0) {
            throw new IllegalArgumentException("Le dénominateur ne peut pas être nul !");
        }
        this.num = num;
        this.denom = denom;
        simplifier();
    }

    private void simplifier(){
        int pgcd = pgcd(this.num, this.denom);
        if (pgcd == 1) {
            return;
        }
        this.num = this.num/pgcd;
        this.denom = this.denom/pgcd;
    }

    private static int pgcd(int a, int b){
        if (b==0){
            return a;
        };
        return pgcd(b, a%b);
    }

    public String toString() {
        return this.num + " / " + this.denom;
    }

}

class Vector {
    private int n; // taille du tableau
    private Rational[] tab; // tableau de rationnels

    // Constructeur
    public vector(int n) {
        this.n = n;
        this.tab = new Rational[n];
    }
    
    public String toString() {
        System.out.println("( ");
        for (Rational r : tab){
            System.out.println(r.toString() + " , ");
        }
        System.out.println(" )");
    }
}

class q8 {
    public static void main(String[] args) {
        int n = 2;
        vector v = new vector(n);
        for (int i = 0; i < n; i++) {
            pangolins[i] = new Rational(1, 2);  // allocation objet par objet
        }
        System.out.println(v.toString());
    }
}