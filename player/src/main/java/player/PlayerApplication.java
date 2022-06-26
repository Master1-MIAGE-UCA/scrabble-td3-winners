package player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;
import play.playerIdentification;
import reactor.core.publisher.Mono;
import Responses.UrlResponse;
import java.net.InetAddress;
import java.util.AbstractMap;
import java.util.ArrayList;

@SpringBootApplication
public class
PlayerApplication {
    @Value("${server.port}")
    private int port;
    private String Url_partie;
    @Autowired
    Player player;
    private String Url_anagrammeur;
    private String url_appariement;
    public static void main(String[] args) {
        SpringApplication.run(PlayerApplication.class, args);
    }

    @Bean
    public CommandLineRunner scriptLancement(WebClient.Builder builder) {
        return args -> {
            if (args.length > 0) {
                // args[0] c'est l'uril d'appariement, en version courte ici pour simplifier la ligne de commande
                String urlApp = "http://localhost:" + args[0];
                WebClient client = builder.baseUrl(urlApp).build();
                UrlResponse urls = new UrlResponse();
                String myIp = InetAddress.getLocalHost().getHostAddress();
                urls   =  client.post().uri("/identification/Joueur")
                        .body(Mono.just("https://" + myIp + ":" + port), String.class)
                        .retrieve().bodyToMono( UrlResponse.class ).block();


                  this.Url_partie =urls.getUrlPartie();
                   this.Url_anagrammeur =urls.getUrlAnnagrameur();


               player.setUrl_anagrammeur(this.Url_anagrammeur);

                player.setUrl("http://" + myIp + ":" + port);
                player.setName("random");

                WebClient client_for_partie = builder.baseUrl(this.Url_partie).build();





                 client_for_partie.post().uri("/connexion/")
                        .body(Mono.just(player), playerIdentification.class)
                        .retrieve().bodyToMono( String.class).block();


                if (urls.isReady() ){

                    client_for_partie.post().uri("/startPartie")
                            .body(Mono.just("http://" + myIp + ":" + port), String.class)
                            .retrieve().bodyToMono( String.class).block();

                    String urlAPPA = "http://localhost:8080" ;
                    WebClient clientfor_appariement = builder.baseUrl(urlAPPA).build();
                    clientfor_appariement.post().uri("/finishgame")
                            .body(Mono.just(player), playerIdentification.class)
                            .retrieve().bodyToMono( String.class);


                }


            }
        };
    }


    
}
