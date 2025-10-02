public class Canard extends Animal {
    private String couleurPlume;
    static public Regime regime = new Regime("canard", 15);

    public Canard(String nom, int weight, String couleurPlume, Regime regime) {
        super(nom, weight, regime);
        this.couleurPlume = couleurPlume;
    }

    public String getCouleurPlumes() {
        return couleurPlume;
    }


    @Override
    public void crier() {
        System.out.println(getNom() + " crie... Ce canard de " + getWeight() +
                "kg aux belles plumes " + couleurPlume + " cancane !");
    }

    @Override
    public int getPrixRegime() {
        return regime.getPrixAuKilo();
    }
    
}
