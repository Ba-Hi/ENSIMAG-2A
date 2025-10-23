public class RationalEvaluable extends Rational implements Evaluable {
    public RationalEvaluable(int num, int denom) {
        super(num, denom);
    }

    public RationalEvaluable(int num) {
        super(num);
    }

    public RationalEvaluable(Rational r) {
        super(r);
    }

    @Override
    public double evaluer() {
        return this.toDouble();
    }
}
