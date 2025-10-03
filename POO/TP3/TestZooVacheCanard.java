public class TestZooVacheCanard {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("VacheCanard");

        Animal v1  = new Vache("Marguerite", 700, 42);
        Animal v2  = new Vache("Belle", 800, 12);
        Animal v3  = new Vache("Clarisse", 600, 7);

        Animal c1  = new Canard("Donald", 5, "blanches");
        Animal c2  = new Canard("Daffy", 4, "noires");
        Animal c3  = new Canard("Daisy", 3, "marron");

        zoo.ajouteAnimal(v1);
        zoo.ajouteAnimal(v2);
        zoo.ajouteAnimal(v3);
        zoo.ajouteAnimal(c1);
        zoo.ajouteAnimal(c2);
        zoo.ajouteAnimal(c3);

        zoo.crier();
    }
}
