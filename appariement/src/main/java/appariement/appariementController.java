package appariement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
@RestController
public class appariementController {

    String URLp;
    @PostMapping("/identification/Joueur")
    public String identAnagrammeur() {

        return this.URLp;
    }
    @PostMapping("/identification/partie/")
    public void identPartie(@RequestBody String URL) {
        this.URLp = URL;

    }

}
