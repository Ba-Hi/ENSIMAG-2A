public class Vache extends Animal {
    private int nombreTaches;
    static public Regime regime = new Regime("vache", 10);

    public Vache(String nom, int weight, int nombreTaches) {
        super(nom, weight, regime);
        this.nombreTaches = nombreTaches;
    }

    @Override
    public void crier() {
        System.out.println(getNom() + ", la vache à " + nombreTaches +
                " taches qui tache, crie... il meugle");
    }
    
    @Override
    public int getPrixRegime() {
        return getWeight() * regime.getPrixAuKilo();
    }
}
