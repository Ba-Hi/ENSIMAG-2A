public class ExpressionEvaluable implements Evaluable {
    private ExpAbstraite exp;
    private Env env;

    public ExpressionEvaluable(ExpAbstraite exp, Env env) {
        this.exp = exp;
        this.env = env;
    }

    @Override
    public double evaluer() {
        return exp.evaluer(env);
    }
}
