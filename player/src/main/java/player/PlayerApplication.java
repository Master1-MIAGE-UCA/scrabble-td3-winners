package player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import play.playerIdentification;
import reactor.core.publisher.Mono;

import java.net.InetAddress;
import java.util.AbstractMap;
import java.util.ArrayList;

@SpringBootApplication
public class PlayerApplication {
    @Value("${server.port}")
    private int port;
    private String Url_partie;
    @Autowired
    Player player;
    private String Url_anagrammeur;
    public static void main(String[] args) {
        SpringApplication.run(PlayerApplication.class, args);
    }

    public CommandLineRunner scriptLancement(WebClient.Builder builder) {
        return args -> {
            if (args.length > 0) {
                // args[0] c'est l'uril d'appariement, en version courte ici pour simplifier la ligne de commande
                String urlApp = "http://localhost:" + args[0];
                WebClient client = builder.baseUrl(urlApp).build();

                String myIp = InetAddress.getLocalHost().getHostAddress();
                ArrayList<AbstractMap.SimpleEntry<String, String> > URL_Anagram_Partie_auth =  client.post().uri("/identification/Joueur")
                        .body(Mono.just("http://" + myIp + ":" + port), String.class)
                        .retrieve().bodyToMono( new ParameterizedTypeReference<ArrayList<AbstractMap.SimpleEntry<String, String>>>(){}).block();


                for (int i = 0; i < URL_Anagram_Partie_auth.size(); i++) {

                    // get map from list
                    AbstractMap.SimpleEntry<String, String>
                            map
                            = URL_Anagram_Partie_auth.get(i);

                    // get key from map.getKey()
                    String key = map.getKey();
                    if (key =="URLpartie" ){ this.Url_partie =map.getValue(); }
                    if (key =="URLanagram" ){ this.Url_anagrammeur =map.getValue(); }
                }
               player.setUrl_anagrammeur(this.Url_anagrammeur);

                playerIdentification me = new playerIdentification();
                me.setUrl("http://" + myIp + ":" + port);
                me.setName("random");
                WebClient client_for_partie = builder.baseUrl(this.Url_partie).build();

                 client_for_partie.post().uri("/connexion")
                        .body(Mono.just(me), playerIdentification.class)
                        .retrieve().bodyToMono( String.class).block();


                if (URL_Anagram_Partie_auth.size() == 3 ){

                    client_for_partie.post().uri("/startPartie")
                            .body(Mono.just("http://" + myIp + ":" + port), String.class)
                            .retrieve().bodyToMono( String.class).block();

                }


            }
        };
    }


    
}
