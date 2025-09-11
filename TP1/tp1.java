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


/////////// Question 5 : ///////////

// Multiplication a.mult(b)
class Rational {
    int num;
    private int denom;

    public void setDenom(int nb) {
    if (nb <= 0) {
        throw new IllegalArgumentException("Le dénominateur doit être non nul !");
        }
        this.denom = nb;
    }


    public String toString() {
        return this.num + " / " + this.denom;
    }

    public void mult(Rational b) {
        
    } 
}
