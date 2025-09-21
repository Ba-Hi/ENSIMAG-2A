public class q10{
    public static void main(String[] args){
        int n = 2;
        Vector v = new Vector(n, new Rational[n]);
        v.set(0, new Rational(1,2));
        v.set(1, new Rational(3,2));
        Rational a = new Rational(1,2);
        v.mult_vector_rational(a);
        System.out.println("1 / 2 * ( 1 / 2 , 3 / 2 ) donne = " + v.toString_vector());
        Vector v2 = new Vector(n, new Rational[n]);
        v2.set(0, new Rational(1,3));
        v2.set(1, new Rational(2,3));
        v.add_vector_vector(v2); // v est maintenant (1/2 + 1/3, 3/2 + 2/3)
        System.out.println("( 1 / 4 , 3 / 4 ) + ( 1 / 3 , 2 / 3) donne = " + v.toString_vector());
       }
}