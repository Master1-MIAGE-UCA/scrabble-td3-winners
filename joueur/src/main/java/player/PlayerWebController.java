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

    @PostMapping("/placeWord")
    public placedWord play(@RequestBody gameState gameState) {
        System.out.println("play > I have to play on "+ gameState);
        return player.play(gameState);
    }

}
