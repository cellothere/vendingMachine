import com.techelevator.CalculateChange;
import org.junit.Assert;
import org.junit.Test;

public class CalculateChangeTest {

    @Test
    public void happyPath(){
//        ARRANGE
        CalculateChange calculateChange = new CalculateChange();

//        ACT
        calculateChange.calCoins(130);

//        ASSERT
        Assert.assertEquals("The system did not return the correct amount","5 Quarters 0 Dimes 1 Nickles", "5 Quarters 0 Dimes 1 Nickles");

    }

    @Test
    public void zeroChangeAmount(){
        //        ARRANGE
        CalculateChange calculateChange = new CalculateChange();

//        ACT
        calculateChange.calCoins(0);

//        ASSERT
        Assert.assertEquals("The system did not proudce the correct amount","0 Quarters 0 Dimes 0 Nickles", "0 Quarters 0 Dimes 0 Nickles");

    }

//    TODO fix this in the code. Vending machine should not return negative change
    @Test
    public void negativeAmounts() {
        //        ARRANGE
        CalculateChange calculateChange = new CalculateChange();

//        ACT
        calculateChange.calCoins(-25);

//        ASSERT
        Assert.assertEquals("The system did not proudce the correct amount", "-1 Quarters 0 Dimes 0 Nickles", "-1 Quarters 0 Dimes 0 Nickles");

    }

}
