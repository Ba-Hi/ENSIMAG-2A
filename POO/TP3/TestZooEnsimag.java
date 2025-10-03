public class TestZooEnsimag {
    public static void main(String[] args) {
        Zoo zoo = new Zoo("Ensimag");
        
        // Marie, Matthieu, Akram, Thang, Karine, Nicolas et Djamel

        Animal a1  = new Animal("Marie", 332);
        Animal a2  = new Animal("Matthieu", 243);
        Animal a3  = new Animal("Akram", 17);
        Animal a4  = new Animal("Thang", 75);
        Animal a5  = new Animal("Karine", 58);
        Animal a6  = new Animal("Nicolas", 83);
        Animal a7  = new Animal("Djamel", 90);

        zoo.ajouteAnimal(a1);
        zoo.ajouteAnimal(a2);
        zoo.ajouteAnimal(a3);
        zoo.ajouteAnimal(a4);
        zoo.ajouteAnimal(a5);
        zoo.ajouteAnimal(a6);
        zoo.ajouteAnimal(a7);

        zoo.crier();
    }
    
}
