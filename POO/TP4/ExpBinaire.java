public abstract class ExpBinaire extends ExpAbstraite{
    public ExpAbstraite opGauche;
    public ExpAbstraite opDroite;

    public ExpBinaire(ExpAbstraite opGauche, ExpAbstraite opDroite){
        this.opGauche = opGauche;
        this.opDroite = opDroite;
    }

}
