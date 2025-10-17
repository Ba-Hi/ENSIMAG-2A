public class Constante extends ExpAbstraite {
    public double valeur;

    public Constante(double valeur) {
        super();
        this.valeur = valeur;
    }

    @Override
    public String toStringInfixe() {
        return "" + valeur;
    }
}
