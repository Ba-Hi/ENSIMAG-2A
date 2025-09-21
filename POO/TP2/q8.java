class q8 {
    public static void main(String[] args) {
        int n = 2;
        Rational[] tab = new Rational[n];
        Vector v = new Vector(n, tab);
        v.set(0, new Rational(1,2));
        v.set(1, new Rational(3,4));
        System.out.println(v.toString_vector());
    }
}