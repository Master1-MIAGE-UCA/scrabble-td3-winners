package anagrammeur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class anagrammeurController {
    dictionnaire dictionnaire;

    @PostMapping("/verifiermot")
    public boolean verifierMot(String mot) {
        System.out.println("Mot vérifié:");
        return dictionnaire.verifierMot(mot);
    }


}
