// /////////// Question 1 : ///////////
 

// // Créez une classe Rational, possédant deux attributs entiers num et denom

// class Rational {
//     int num;
//     int denom;
// }

// // Écrivez un programme de test qui crée une fraction 3/2, affiche son numérateur, et affiche son dénominateur (dans la console)
// class tp1 {
//     public static void main(String[] args){
//         Rational fraction = new Rational();
//         fraction.num = 3;
//         fraction.denom = 2;
//         System.out.println("numerateur " + fraction.num);
//         System.out.println("denom " + fraction.denom);
//     }
// }

/////////// Question 2 : ///////////

// class Rational {
//     int num;
//     int denom;

//     public String toString() {
//         return this.num + " / " + this.denom;
//     }
// }

// // Écrivez un programme de test qui crée une fraction 3/2, affiche son numérateur, et affiche son dénominateur (dans la console)
// class tp1 {
//     public static void main(String[] args){
//         Rational fraction = new Rational();
//         fraction.num = 3;
//         fraction.denom = 2;
//         System.out.println(fraction.toString());
//     }
// }

/////////// Question 4 : ///////////

// class Rational {
//     int num;
//     private int denom;

//     public void setDenom(int nb) {
//     if (nb <= 0) {
//         throw new IllegalArgumentException("Le dénominateur doit être non nul !");
//         }
//         this.denom = nb;
//     }


//     public String toString() {
//         return this.num + " / " + this.denom;
//     }
// }


/////////// Question 5 et 6 : ///////////

// Multiplication a.mult(b)
// class Rational {
//     int num;
//     private int denom;

//     // Constructeur
//     public Rational(int num, int denom) {
//         if (denom == 0) {
//             throw new IllegalArgumentException("Le dénominateur ne peut pas être nul !");
//         }
//         this.num = num;
//         this.denom = denom;
//     }


//     public String toString() {
//         return this.num + " / " + this.denom;
//     }

//     public void mult(Rational b) {
//         this.num = this.num * b.num;
//         this.denom = this.denom * b.denom;
//     }

//     public void addition(Rational b){
//         this.num = this.num * b.denom + b.num * this.denom;
//         this.denom = this.denom * b.denom;
//     }
// }

// Modifiez votre programme de test en créant un second rationnel (1/3 par exemple), en le
// multipliant au premier, et en affichant le résultat. Compilez et exécutez. Pareil pour la somme
// class q5et6 {
//     public static void main(String[] args){
//         Rational fraction = new Rational(3,2);
//         Rational fraction2 = new Rational(1,2);
//         fraction.mult(fraction2);
//         System.out.println("Produit 3/2 et 1/2 : " + fraction.toString());
//         fraction.addition(fraction2); // 3/4 + 1/2 = 3/4 + 2/4 = 5/4
//         System.out.println("Somme 3/4 et 1/2 : " + fraction.toString());
//     }
// }


/////////// Question 7 : ///////////


// class Rational {
//     private int num;
//     private int denom;

//     // Constructeur
//     public Rational(int num, int denom) {
//         if (denom == 0) {
//             throw new IllegalArgumentException("Le dénominateur ne peut pas être nul !");
//         }
//         this.num = num;
//         this.denom = denom;
//         simplifier();
//     }

//     private void simplifier(){
//         int pgcd = pgcd(this.num, this.denom);
//         if (pgcd == 1) {
//             return;
//         }
//         this.num = this.num/pgcd;
//         this.denom = this.denom/pgcd;
//     }

//     private static int pgcd(int a, int b){
//         if (b==0){
//             return a;
//         };
//         return pgcd(b, a%b);
//     }

//     public String toString() {
//         return this.num + " / " + this.denom;
//     }

//     public void mult(Rational b) {
//         this.num = this.num * b.num;
//         this.denom = this.denom * b.denom;
//         simplifier();
//     }

//     public void addition(Rational b){
//         this.num = this.num * b.denom + b.num * this.denom;
//         this.denom = this.denom * b.denom;
//         simplifier();
//     }
// }


// class q7 {
//     public static void main(String[] args){
//         Rational fraction = new Rational(3,2);
//         Rational fraction2 = new Rational(1,2);
//         fraction.mult(fraction2);
//         System.out.println("Produit 3/2 et 1/2 : " + fraction.toString());
//         fraction.addition(fraction2); // 3/4 + 1/2 = 3/4 + 2/4 = 5/4
//         System.out.println("Somme 3/4 et 1/2 : " + fraction.toString());   
//         }
// }



/////////// Question 8 : ///////////


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

    public Rational mult(Rational a, Rational b) {

}


class q8 {
    public static void main(String[] args){
        Rational fraction = new Rational(3,2);
        Rational fraction2 = new Rational(1,2);
        fraction.mult(fraction2);
        System.out.println("Produit 3/2 et 1/2 : " + fraction.toString());
        fraction.addition(fraction2); // 3/4 + 1/2 = 3/4 + 2/4 = 5/4
        System.out.println("Somme 3/4 et 1/2 : " + fraction.toString());   
        }
}