import com.platzi.javatesting.project_extra.Game;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

import static org.mockito.Mockito.when;
@RunWith(MockitoJUnitRunner.class)
public class GameSteps {
    public static final int OPTION_ROCK = 0;
    public static final int OPTION_PAPER = 1;
    public static final int OPTION_SCISSORS = 2;
    //indicar clase principal
    @InjectMocks
    private Game game;

    //objeto a mockear
    @Mock
    Scanner scanner;

    @Mock
    Random random;

    private ByteArrayOutputStream out;

    @Before
    public void setUp(){
        //obtener lo que se esta imprimiendo en consola
        out = new ByteArrayOutputStream();

        // indicar objeto a utilizar como consola
        System.setOut(new PrintStream(out));
    }


    @Given("the user will choose {string}")
    public void theUserWillChoose(String userOption) {
        MockitoAnnotations.openMocks(this);
        //simular con mockito, la seleccion del usuario
        when(scanner.nextLine()).thenReturn(userOption).thenReturn("Quit");
    }

    @And("the computer will choose {string}")
    public void theComputerWillChoose(String computerSelection){
        int selection =0;
        if("scissors".equals(computerSelection)){
          selection = OPTION_SCISSORS;
        }
        if("paper".equals(computerSelection)){
            selection = OPTION_PAPER;
        }
        if("rock".equals(computerSelection)){
            selection = OPTION_ROCK;
        }
        when(random.nextInt(3)).thenReturn(selection);

    }

    @When("they play")
    public void theyPlay() {
        // crear un juego
        game.play();
    }

    @Then("the user wins")
    public void theUserWins() {
        //pruebas

        Assert.assertTrue(out.toString().contains("wins:1"));
    }

    @Then("verify that computer choose {string}")
    public void verifyThatComputerChoose(String computerSelection) {
        Assert.assertTrue(out.toString().contains("Computer chose "+ computerSelection));
    }
}
