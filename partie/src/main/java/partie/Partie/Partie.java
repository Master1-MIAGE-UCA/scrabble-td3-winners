package partie.Partie;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class Partie implements Runnable{

    Thread game ;

    public boolean lancerPartie() {
        boolean result = (game == null);
        if (result) {
            System.out.println("Partie > la partie est démarrée");
            game = new Thread(this);
            game.start();
        } else {
            System.out.println("Partie > la partie est déjà démarrée");
        }
        return result;
    }

    @Override
    public void run() {
        System.out.println("Partie > le jeu commence");
    }
}
