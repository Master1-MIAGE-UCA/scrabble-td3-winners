package partie.Partie;

import org.springframework.stereotype.Component;
import play.playerIdentification;

import java.util.ArrayList;

@Component
public class Partie implements Runnable{
private ArrayList<playerIdentification> listPlayer= new ArrayList();
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

    public ArrayList<playerIdentification> getListPlayer() {
        return listPlayer;
    }

    public void setListPlayer(ArrayList<playerIdentification> listPlayer) {
        this.listPlayer = listPlayer;
    }
    public boolean addPlayer(playerIdentification Player) {


        this.listPlayer.add(Player);
        return true;
    }
}
