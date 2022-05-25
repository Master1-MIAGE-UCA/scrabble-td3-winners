package partie.Partie;

import org.springframework.stereotype.Component;

@Component
public class Partie {

    Thread game ;

    public boolean lancerPartie() {
        boolean result = (game == null);
        if (result) {
            System.out.println("Partie > la partie est démarrée");
            game = new Thread((Runnable) this);
            game.start();
        } else {
            System.out.println("Partie > la partie est déjà démarrée");
        }
        return result;
    }

}
