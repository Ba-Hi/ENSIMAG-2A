public class Regime {
    private String nom;
    private int prixAuKilo;

    public Regime(String nom, int prixAuKilo) {
        this.nom = nom;
        this.prixAuKilo = prixAuKilo;
    }

    public String getNomRegime() {
        return nom;
    }

    public int getPrixAuKilo() {
        return prixAuKilo;
    }

}
