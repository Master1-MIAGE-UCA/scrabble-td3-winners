package partie;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.player.playerIdentification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import partie.Partie.Partie;
import partie.WebController.partieWebController;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
public class ConnexionTest {

    @Autowired
    Partie testPartie;
    Partie partie;

    @Autowired
    partieWebController webController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void initTest() {
        partie = spy(testPartie);
        ReflectionTestUtils.setField(webController, "game", partie);
    }

    @Test
    public void shouldReturnTrue() throws Exception {
          this.mockMvc.perform(post("/Try/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));
    }


    @Test
    public void shouldReturnTrue_theRealMethodWithParam() throws Exception {
        playerIdentification id = new playerIdentification();
        String paramConnexion = objectMapper.writeValueAsString(id);

        this.mockMvc.perform(post("/connexion/").contentType(MediaType.APPLICATION_JSON)
                        .content(paramConnexion)).andExpect(status().isOk())
                .andExpect(content().string(containsString("true")));

        TimeUnit.MILLISECONDS.sleep(500); // le temps pour travis de lancer le thread

        verify(partie, times(1)).lancerPartie();
        verify(partie, times(1)).run();


        this.mockMvc.perform(post("/connexion/").contentType(MediaType.APPLICATION_JSON)
                        .content(paramConnexion)).andExpect(status().isOk())
                .andExpect(content().string(containsString("false")));

        TimeUnit.MILLISECONDS.sleep(500);

        verify(partie, times(2)).lancerPartie();
        verify(partie, times(1)).run(); //
    }


}
