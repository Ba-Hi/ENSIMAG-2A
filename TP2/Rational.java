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

    public Rational(Rational other) { 
        this.num = other.num;
        this.denom = other.denom;
    }

    private void simplifier(){
        int pgcd = pgcd(this.num, this.denom);
        if (pgcd == 1) {
            return;
        }
        this.num = this.num/pgcd;
        this.denom = this.denom/pgcd;
        if (this.denom < 0) {
            this.denom = -this.denom;
            this.num = -this.num;
        }
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


    public void mult(Rational b) {
        this.num = this.num * b.num;
        this.denom = this.denom * b.denom;
        simplifier();
    }

    public void addition(Rational b){
        this.num = this.num * b.denom + b.num * this.denom;
        this.denom = this.denom * b.denom;
        simplifier();
    }

}
