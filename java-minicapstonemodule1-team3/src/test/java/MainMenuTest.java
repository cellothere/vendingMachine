import com.techelevator.MainMenu;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainMenuTest {

    @Test
    public void happyPath() {
//        ARRANGE

        MainMenu mainMenu = new MainMenu();

//        ACT
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

//        ASSERT
        Assert.assertEquals(2, mainMenu.getMainMenu());
    }

    //    TODO fix this in the code so only menu options can be selected
    @Test
    public void aNumberOutsideOfMenuOptions() {
//        ARRANGE

        MainMenu mainMenu = new MainMenu();

//        ACT
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

//        ASSERT
        Assert.assertEquals(4, mainMenu.getMainMenu());
    }


    @Test
    public void negativeNumber() {
//        ARRANGE

        MainMenu mainMenu = new MainMenu();

//        ACT
        String input = "-4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

//        ASSERT
        Assert.assertEquals(-4, mainMenu.getMainMenu());
    }

}

