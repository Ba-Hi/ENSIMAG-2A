public abstract class ExpAbstraite {
    public abstract String toStringInfixe();

    public String toString(){
        return "Je suis une expression et me voila en notation infixée : " +
                toStringInfixe();

        }
}