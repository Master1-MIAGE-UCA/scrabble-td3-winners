package player;
import anagrammeur.gameState;
import anagrammeur.placedWord;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Player {

    //  Function that permit player to place a word according to abscissa and ordinate
    public placedWord play(gameState gameState) {
        System.out.println("Player >>>> I play the word exemple in abscissa 17 and ordinate 17 vertically");
        return new placedWord("exemple", 17, 87,true) ;
    }
}
