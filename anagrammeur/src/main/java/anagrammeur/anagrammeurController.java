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
    @PostMapping("/finish")
    public void end() {
        System.out.println(">> We have to end Annagrameur " );
        System.exit(0);
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
