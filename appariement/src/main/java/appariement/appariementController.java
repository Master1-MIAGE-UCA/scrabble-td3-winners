package appariement;

import Responses.UrlResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@RestController
public class appariementController {
    private WebClient webClient;
    @Autowired
    WebClient.Builder builder;
   /* @Bean
    public WebClient partierest(WebClient.Builder builder) {
        // Do any additional configuration here
        return builder.baseUrl(this.URL_Anagram_Partie_auth.getUrlPartie()).build();   //@TODO URL EN DUR
    }
    @Bean
    public WebClient player1rest(WebClient.Builder builder) {
        // Do any additional configuration here
        return builder.baseUrl(this.URLjoueurs.get(0)).build();   //@TODO URL EN DUR
    }
    @Bean
    public WebClient player2rest(WebClient.Builder builder) {
        // Do any additional configuration here
        return builder.baseUrl(this.URLjoueurs.get(1)).build();   //@TODO URL EN DUR
    }
    @Bean
    public WebClient anagramrest(WebClient.Builder builder) {
        // Do any additional configuration here;
        return builder.baseUrl(this.URL_Anagram_Partie_auth.getUrlAnnagrameur()).build();   //@TODO URL EN DUR
    }*/

  //  private final ArrayList<AbstractMap.SimpleEntry<String, String> > URL_Anagram_Partie_auth = new ArrayList<AbstractMap.SimpleEntry<String, String> >();
  @Autowired
   private ResponseURL URL_Anagram_Partie_auth  ;


    private ArrayList<String> URLjoueurs = new ArrayList<>();
    private int i = 0;

    //le joueur se connect est recupere les url de l'annagrameur et la partie
    //il recupere aussi l'autorisation pour lancer la partie ( si > 2 joueur sont connecté)
    // les données sont recuperé sous forme de list de pair <key,value>
    @PostMapping("/identification/Joueur")
    public UrlResponse identjoueur() {
        System.out.println("Appariement > un joueur est connecté ");
        this.URLjoueurs.add("player number" + this.i );
        i++;
if (this.URLjoueurs.size() > 1){
    this.URL_Anagram_Partie_auth.setReady(true);

}
        return this.URL_Anagram_Partie_auth;
    }
    //la partie se connect est donne son URL
    @PostMapping("/identification/partie")
    public void identPartie(@RequestBody String URL) {
        System.out.println("Appariement > une partie est connecté ");

        this.URL_Anagram_Partie_auth.setUrlPartie(URL);


    }
    //l'annagrammeur se connect est donne son URL
    @PostMapping("/identification/Annagrameur")
    public void identAnnagrameur(@RequestBody String URL) {
        System.out.println("Appariement > un annagrameur est connecté ");
        this.URL_Anagram_Partie_auth.setUrlAnnagrameur(URL);


    }

    @PostMapping("/finishgame")
    public void end() {

        WebClient client_for_partie = builder.baseUrl(this.URL_Anagram_Partie_auth.getUrlPartie()).build();
        client_for_partie.post().uri("/finish")
                .body(Mono.just("http://"), String.class)
                .retrieve().bodyToMono( String.class).block();
        WebClient client_for_annagrameur = builder.baseUrl(this.URL_Anagram_Partie_auth.getUrlAnnagrameur()).build();
        client_for_annagrameur.post().uri("/finish")
                .body(Mono.just("http://"), String.class)
                .retrieve().bodyToMono( String.class).block();


        WebClient client_for_player1 = builder.baseUrl(this.URLjoueurs.get(0)).build();
        client_for_player1.post().uri("/finish")
                .body(Mono.just("http://"), String.class)
                .retrieve().bodyToMono( String.class).block();





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
