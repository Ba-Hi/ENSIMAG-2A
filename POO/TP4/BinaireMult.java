public class BinaireMult extends ExpBinaire {
    public BinaireMult(ExpAbstraite opGauche, ExpAbstraite opDroite) {
        super(opGauche, opDroite);
    }

     @Override
    public String toStringInfixe(){
        return "(" + opGauche.toStringInfixe() + " * " + opDroite.toStringInfixe() + ")" ;
     }
}
