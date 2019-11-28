import PageObjects.CPSAT_Question6_PageObject;
import com.google.common.collect.Lists;
import edu.emory.mathcs.backport.java.util.Collections;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class CPSAT_Question6_Test extends CPSAT_Question6_PageObject {

    @BeforeClass
    public void preSetup() throws IOException {
        loadWebPageChrome(getProperties().getProperty("question6_URL"));
        implicityWait_Chrome(30L);
    }

    @Test(description = "Test the woodland web page ", dataProvider = "Get products")
    public void testWoodLandPage(String product) throws InterruptedException {
        System.out.println("Placing the order for " + product);
        clickElementByXpath_Chrome(searchButton);
        writeDataByXpath_Chrome(searchField, product);
        clickElementByXpath_Chrome(goButton);
        waitUntilTheElementIsVisible_Chrome(4L, filterHighToLow);
        clickElementByXpath_Chrome(filterHighToLow);
        waitForParticularTime(3L);
        List<Long> prizes = new LinkedList<Long>();
        List<Long> sortedPrizes = new LinkedList<Long>();
        System.out.println();
        for (int i = 0; i < 8; i++) {
            prizes.add(Long.parseLong(searchElementsByXpath_Chrome(mrpPrizes).get(i).getText().replaceAll("[^0-9]", "")));
        }
        sortedPrizes.addAll(prizes);
        System.out.println(prizes);
        System.out.println(sortedPrizes);
        Collections.sort(sortedPrizes, Collections.reverseOrder());
        Assert.assertEquals(prizes, sortedPrizes);


    }

    @AfterClass
    public void tearDown() {
        webDriverChrome.quit();
    }
}
