package partie.WebController;

import anagramme.grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import partie.Partie.Partie;
import play.playerIdentification;


@RestController
public class partieWebController {


    playerIdentification playerId;

    /**
     *
     */
    @Autowired
    Partie game;

    private WebClient webClient;


    @PostMapping("/connexion")
    public boolean getValue(@RequestBody playerIdentification playerId) {
        System.out.println("Moteur > connexion acceptée de " + playerId.getName());
        this.playerId = playerId;
        // webClient = create(playerId.getUrl());
        return game.addPlayer(this.playerId);

    }

    @PostMapping("/startPartie")
    public void startPartie() {
        game.lancerPartie();

    }

    @PostMapping("/grid")
    public void grid() {

        grid g = new grid();
        g = game.getGrid();
        g.toString();
    }

    @PostMapping("/finish")
    public void end() {





        System.out.println(">> We have to end partie " );
        System.exit(0);
       /* if (end) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("End > end of the game");
                    try {
                        TimeUnit.MILLISECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.exit(0);
                    }

                }
            });
            thread.start();
        }*/
    }
}
