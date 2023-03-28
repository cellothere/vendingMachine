import com.techelevator.MainMenu;
import com.techelevator.PurchaseAnItem;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PurchaseAnItemTest {

//    check that a string return an int
    @Test
    public void happyPathPurchaseMenu() throws IOException {

        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int purchaseAnItem = new PurchaseAnItem().makeSelection();

        Assert.assertEquals(1, purchaseAnItem);
    }

}

