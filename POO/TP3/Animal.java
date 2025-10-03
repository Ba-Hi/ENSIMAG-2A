public class Animal {
    private String nom;
    private int weight;
    public Static Regime regime;

    public Animal(String nom, int weight, Regime regime) {
        this.nom = nom;
        this.weight = weight;
        this.regime = regime;
    }

    public String getNom() {
        return nom;
    }

    public int getWeight() {
        return weight;
    }

    public Regime getRegime() {
        return regime;
    }

    public int getPrixRegime() {
        return regime.getPrixAuKilo() * weight;
    }

    public void crier(){
        System.out.println(nom + " crie...");
    }

    public String toString() {
        return "Animal{" +
                "nom='" + nom + '\'' +
                ", weight=" + weight +
                ", regime=" + regime.getNomRegime() +
                '}';
    }

}