package appariement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
@RestController
public class appariementController {
    String URLa;
    String URLp;
    @PostMapping("/identification/anagrammeur/")
    public String identAnagrammeur(@RequestBody String URL) {
        this.URLa = URL;
        return this.URLa;
    }
    @PostMapping("/identification/partie/")
    public String identPartie(@RequestBody String URL) {
        this.URLp = URL;
        return this.URLp;
    }
}
