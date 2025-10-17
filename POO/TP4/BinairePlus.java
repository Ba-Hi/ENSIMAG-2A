public class BinairePlus extends ExpBinaire {
    public BinairePlus(ExpAbstraite opGauche, ExpAbstraite opDroite) {
        super(opGauche, opDroite);
    }

    @Override
    public String toStringInfixe(){
        return "(" + opGauche.toStringInfixe() + " + " + opDroite.toStringInfixe() + ")";
    }
}
