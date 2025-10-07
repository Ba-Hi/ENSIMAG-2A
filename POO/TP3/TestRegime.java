public class TestRegime {
    public static void main(String[] args) {
        Regime regimeVache = new Regime("vache", 10);
        Regime regimeCanard = new Regime("canard", 15);

        Animal vache = new Vache("Marguerite", 700, 15);
        Animal canard = new Canard("Donald", 10, "bleues", regimeCanard);

        Zoo zoo = new Zoo("Mon Zoo");
        zoo.ajouteAnimal(vache);
        zoo.ajouteAnimal(canard);

        System.out.println(zoo);
        System.out.println("Prix total des régimes : " + zoo.getPrixTotalRegimes() + " euros");
    }
}
