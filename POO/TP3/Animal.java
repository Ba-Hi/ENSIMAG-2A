public class Animal {
    private String nom;
    private int weight;

    public Animal(String nom, int weight) {
        this.nom = nom;
        this.weight = weight;
    }

    public String getNom() {
        return nom;
    }

    public int getWeight() {
        return weight;
    }

    public void crier(){
        System.out.println(nom + "crie...");
    }

    public String toString() {
        return "Animal{" +
                "nom='" + nom + '\'' +
                ", weight=" + weight +
                '}';
    }
}