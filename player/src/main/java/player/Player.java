package player;

import anagramme.gameState;
import anagramme.position;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import play.playerIdentification;

@Component
@Scope("singleton")
public class Player extends playerIdentification {

    private String url_anagrammeur;
    //  Function that permit player to place a word according to abscissa and ordinate
    public position play(gameState gameState) {
        System.out.println("Player >>>> I play the word exemple in abscissa 17 and ordinate 17 vertically");
        return new position( 17, 87) ;

    }

    public String getUrl_anagrammeur() {
        return url_anagrammeur;
    }

    public void setUrl_anagrammeur(String url_anagrammeur) {
        this.url_anagrammeur = url_anagrammeur;
    }
}
