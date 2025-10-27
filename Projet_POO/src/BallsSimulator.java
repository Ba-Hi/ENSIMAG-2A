// Les classes gui.Simulable et gui.GUISimulator sont assumées disponibles via gui.jar
import gui.Simulable;

/**
 * BallsSimulator réalise l'interface Simulable.
 * Elle agit comme contrôleur, déléguant la logique de la simulation à la classe Balls.
 */
public class BallsSimulator implements Simulable {
    // Attribut de type Balls (le modèle de la simulation)
    private final Balls balls;

    // Définition des déplacements pour chaque étape (next()).
    // Ces valeurs sont utilisées pour correspondre à l'exemple de trace fourni (Figure 4)
    private static final int DX = 10;
    private static final int DY = 10;

    /**
     * Constructeur. Initialise l'objet Balls.
     */
    public BallsSimulator() {
        this.balls = new Balls();
        System.out.println("BallsSimulator initialisé.");
        System.out.println("Positions initiales : " + this.balls.toString());
    }

    /**
     * Invoquée par l'interface graphique suite à un clic sur 'Suivant' ou en mode 'Lecture'.
     * Elle avance la simulation d'un pas de temps.
     */
    @Override
    public void next() {
        System.out.println("Next... Translation de (" + DX + ", " + DY + ")");

        // Délégation: le simulateur demande au modèle de se mettre à jour
        this.balls.translate(DX, DY);

        // Affichage du nouvel état dans la console (comme dans l'exemple de trace)
        System.out.println(this.balls.toString());
    }

    /**
     * Invoquée par l'interface graphique suite à un clic sur 'Début'.
     * Elle remet la simulation à son état initial.
     */
    @Override
    public void restart() {
        System.out.println("Restart... Réinitialisation des balles.");

        // Délégation: le simulateur demande au modèle de se réinitialiser
        this.balls.reInit();

        // Affichage de l'état réinitialisé
        System.out.println(this.balls.toString());
    }

    // Un accesseur qui sera très utile pour la Question 3 (l'affichage)
    public Balls getBalls() {
        return this.balls;
    }
}
