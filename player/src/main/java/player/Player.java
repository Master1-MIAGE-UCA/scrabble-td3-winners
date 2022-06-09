package player;

import anagramme.gameState;
import anagramme.placedWord;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Player {

    private String url_anagrammeur;
    //  Function that permit player to place a word according to abscissa and ordinate
    public placedWord play(gameState gameState) {
        System.out.println("Player >>>> I play the word exemple in abscissa 17 and ordinate 17 vertically");
        return new placedWord("exemple", 17, 87,true) ;
    }

    public String getUrl_anagrammeur() {
        return url_anagrammeur;
    }

    public void setUrl_anagrammeur(String url_anagrammeur) {
        this.url_anagrammeur = url_anagrammeur;
    }
}
