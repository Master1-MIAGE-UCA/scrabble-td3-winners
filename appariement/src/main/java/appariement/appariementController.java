package appariement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
@RestController
public class appariementController {

  //  private final ArrayList<AbstractMap.SimpleEntry<String, String> > URL_Anagram_Partie_auth = new ArrayList<AbstractMap.SimpleEntry<String, String> >();
   private String[] URL_Anagram_Partie_auth ;
    private ArrayList<String> URLjoueurs = new ArrayList<>();
    private int i = 0;

    //le joueur se connect est recupere les url de l'annagrameur et la partie
    //il recupere aussi l'autorisation pour lancer la partie ( si > 2 joueur sont connecté)
    // les données sont recuperé sous forme de list de pair <key,value>
    @PostMapping("/identification/Joueur")
    public String[]  identjoueur() {
        System.out.println("Appariement > un joueur est connecté ");
        this.URLjoueurs.add("player number" + this.i );
        i++;
if (this.URLjoueurs.size() > 1){
    this.URL_Anagram_Partie_auth[2] = "canStart";

}
        return this.URL_Anagram_Partie_auth;
    }
    //la partie se connect est donne son URL
    @PostMapping("/identification/partie")
    public void identPartie(@RequestBody String URL) {
        System.out.println("Appariement > une partie est connecté ");

        this.URL_Anagram_Partie_auth [0] = URL;


    }
    //l'annagrammeur se connect est donne son URL
    @PostMapping("/identification/Annagrameur")
    public void identAnnagrameur(@RequestBody String URL) {
        System.out.println("Appariement > un annagrameur est connecté ");
        this.URL_Anagram_Partie_auth [1] = URL;


    }


}
