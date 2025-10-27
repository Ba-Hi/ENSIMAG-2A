public class TestBalls {

    public static void main(String[] args) {
        Balls mesBalles = new Balls();

        System.out.println("\nÉTAPE 1: Positions Initiales");
        System.out.println(mesBalles.toString());

        // 3. Translation des balles
        int dx = 5;
        int dy = -10;
        System.out.println("ÉTAPE 2: Translation de (" + dx + ", " + dy + ")");
        mesBalles.translate(dx, dy);

        // 4. Affichage après la première translation
        System.out.println("\nPositions après translation:");
        System.out.println(mesBalles.toString());

        // 5. Seconde translation
        dx = 15;
        dy = 50;
        System.out.println("ÉTAPE 3: Seconde translation de (" + dx + ", " + dy + ")");
        mesBalles.translate(dx, dy);

        // 6. Affichage après la seconde translation
        System.out.println("\nPositions après la seconde translation:");
        System.out.println(mesBalles.toString());

        // 7. Réinitialisation des balles
        System.out.println("ÉTAPE 4: Réinitialisation des positions (appel de reInit())");
        mesBalles.reInit();

        // 8. Affichage après réinitialisation (doit correspondre à l'ÉTAPE 1)
        System.out.println("\nPositions après réinitialisation:");
        System.out.println(mesBalles.toString());

        // 9. Vérification qu'on peut translater après la réinitialisation
        dx = 1;
        dy = 1;
        System.out.println("ÉTAPE 5: Translation finale de (" + dx + ", " + dy + ") pour vérification");
        mesBalles.translate(dx, dy);
        System.out.println("\nPositions après translation finale:");
        System.out.println(mesBalles.toString());
    }
}