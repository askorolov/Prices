import junitx.framework.ListAssert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 05.02.2017.
 */

public class PriceUpdateUtilTest {
    private static List<Price> oldPrices;
    private static List<Price> newPrices;
    private static List<Price> updatedPrices;

    @BeforeClass
    public static void initialize() {

        oldPrices = new ArrayList<>();
        newPrices = new ArrayList<>();
        updatedPrices = new ArrayList<>();
        oldPrices.add(new Price("122856", 1, 1, LocalDateTime.of(2013, 1, 1, 0, 0, 0), LocalDateTime.of(2013, 1, 31, 23, 59, 59), 11000));
        oldPrices.add(new Price("122856", 2, 1, LocalDateTime.of(2013, 1, 10, 0, 0, 0), LocalDateTime.of(2013, 1, 20, 23, 59, 59), 99000));
        oldPrices.add(new Price("6654", 1, 2, LocalDateTime.of(2013, 1, 1, 0, 0, 0), LocalDateTime.of(2013, 1, 31, 0, 0, 0), 5000));
        oldPrices.add(null);

        newPrices.add(new Price("122856", 1, 1, LocalDateTime.of(2013, 1, 20, 0, 0, 0), LocalDateTime.of(2013, 2, 20, 23, 59, 59), 11000));
        newPrices.add(new Price("122856", 2, 1, LocalDateTime.of(2013, 1, 15, 0, 0, 0), LocalDateTime.of(2013, 1, 25, 23, 59, 59), 92000));
        newPrices.add(new Price("6654", 1, 2, LocalDateTime.of(2013, 1, 12, 0, 0, 0), LocalDateTime.of(2013, 1, 13, 0, 0, 0), 4000));
        newPrices.add(new Price("6655", 1, 2, LocalDateTime.of(2013, 1, 12, 0, 0, 0), LocalDateTime.of(2013, 1, 13, 0, 0, 0), 4000));
        newPrices.add(null);


        updatedPrices.add(new Price("122856", 1, 1, LocalDateTime.of(2013, 1, 1, 0, 0, 0), LocalDateTime.of(2013, 2, 20, 23, 59, 59), 11000));
        updatedPrices.add(new Price("122856", 2, 1, LocalDateTime.of(2013, 1, 10, 0, 0, 0), LocalDateTime.of(2013, 1, 15, 0, 0, 0), 99000));
        updatedPrices.add(new Price("122856", 2, 1, LocalDateTime.of(2013, 1, 15, 0, 0, 0), LocalDateTime.of(2013, 1, 25, 23, 59, 59), 92000));

        updatedPrices.add((new Price("6654", 1, 2, LocalDateTime.of(2013, 1, 1, 0, 0, 0), LocalDateTime.of(2013, 1, 12, 0, 0, 0), 5000)));
        updatedPrices.add((new Price("6654", 1, 2, LocalDateTime.of(2013, 1, 13, 0, 0, 0), LocalDateTime.of(2013, 1, 31, 0, 0, 0), 5000)));
        updatedPrices.add((new Price("6654", 1, 2, LocalDateTime.of(2013, 1, 12, 0, 0, 0), LocalDateTime.of(2013, 1, 13, 0, 0, 0), 4000)));
        updatedPrices.add(new Price("6655", 1, 2, LocalDateTime.of(2013, 1, 12, 0, 0, 0), LocalDateTime.of(2013, 1, 13, 0, 0, 0), 4000));
    }

    @Test
    public void updatePricesTest() throws Exception {
        ListAssert.assertEquals(updatedPrices, PriceUpdateUtil.updatePrices(oldPrices, newPrices));

    }


}
