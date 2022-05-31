package partie.WebController;

import main.java.player.playerIdentification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import partie.Partie.Partie;

import static org.springframework.web.reactive.function.client.WebClient.create;


@RestController
public class partieWebController {

    playerIdentification playerId;

    /**
     *
     */
    @Autowired
    Partie game;

    private WebClient webClient;


    @PostMapping("/connexion/")
    public boolean getValue(@RequestBody playerIdentification playerId) {
        System.out.println("Moteur > connexion acceptée de "+playerId.getName());
        this.playerId = playerId;
        webClient = create(playerId.getUrl());
        return game.lancerPartie();
    }
}
