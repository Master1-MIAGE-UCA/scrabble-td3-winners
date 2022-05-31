package player;

import anagrammeur.gameState;
import anagrammeur.placedWord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PlayerWebController {

    @Autowired
    Player player;

    // API post for sending the placed word
    @PostMapping("/placeWord")
    public placedWord play(@RequestBody gameState gameState) {
        System.out.println("play > I have to play on "+ gameState);
        return player.play(gameState);
    }

    // API post for finishing game
    @PostMapping("/finish")
    public void end(@RequestBody Boolean end) {
        System.out.println(">> We have to end: " + end);

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
