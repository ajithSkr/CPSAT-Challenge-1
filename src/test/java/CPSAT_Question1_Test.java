import CPSAT_PageFunction.CPSAT_PageFunction;
import PageObjects.CPSAT_Question1_PageObject;
import org.apache.poi.ss.formula.functions.T;
import org.eclipse.sisu.Priority;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPSAT_Question1_Test extends CPSAT_Question1_PageObject {
    @BeforeClass
    public void preSetup() throws IOException {
        loadWebPageChrome(CPSAT_PageFunction.getProperties().getProperty("question1_URL"));
        implicityWait_Chrome(30L);
    }

    @Test(description = "Print the width and height of the logo", priority = 1)
    public void printTheWidthAndHeightOfTheLogo() {
        int width = searchElementByXpath_Chrome(CPSAT_Question1_PageObject.logo).getSize().getWidth();
        int height = searchElementByXpath_Chrome(CPSAT_Question1_PageObject.logo).getSize().getHeight();
        System.out.println("The width of the logo = " + width);
        System.out.println("The height of the logo = " + height);
    }

    @Test(description = "Under Follow us section on the bottom, extract and print the href of ‘twitter’ social media" +
            "icon (", priority = 2)
    public void extractAndPrintTheHrefOfTwitterLogo() {
        String href = searchElementByXpath_Chrome(twitterLogo).getAttribute("href");
        Assert.assertNotNull(href);
        System.out.println("href of the twitter logo = " + href);
    }

    @Test(description = "Assert the message in the shopping cart table “No Item is Added In Cart yet. Cart is\n" +
            "Empty!!!”", priority = 3)
    public void assertTheMessageInShoppingCartTable() throws InterruptedException {
        String itemsInCart = searchElementByXpath_Chrome(cartItem).getText();
        if (itemsInCart.contains("0")) {
            clickElementByXpath_Chrome(shoppingCart);
            waitForParticularTime(2L);
        }
        Assert.assertEquals(searchElementByXpath_Chrome(cartData).getText(), "No Item is Added In Cart yet.Cart is Empty!!!");
    }

    @Test(description = "Add anyone java book in cart", priority = 4)
    public void addAnyoneJavaBookInCart() throws InterruptedException {
        String cartDataBeforeOrder=searchElementByXpath_Chrome(cartItem).getText();
        String bookToSearch = "java";
        writeDataByXpath_Chrome(searchField, bookToSearch);
        clickElementByXpath_Chrome(searchButton);
        List<WebElement> bookData = searchElementsByXpath_Chrome(bookList);
        String bookInCart = null;
        for (int i = 0; i < bookData.size(); i++) {
            bookInCart = searchElementsByXpath_Chrome(bookList).get(i).getText();
            if (bookInCart.toLowerCase().contains(bookToSearch.toLowerCase())) {
                System.out.println(searchElementsByXpath_Chrome(bookList).get(i).getText().toLowerCase());
                System.out.println(i);
                searchElementsByXpath_Chrome(addToCart).get(i).click();
                waitForParticularTime(7L);
                break;
            } else if (i == bookData.size()) {
                scrollElementByXpath_Chrome(searchElementsByXpath_Chrome(bookList).get(i));
                clickElementByXpath_Chrome(viewMoreButton);
                bookData = searchElementsByXpath_Chrome(bookList);
            }
        }
        String cartDataAfterOrder=searchElementByXpath_Chrome(cartItem).getText();
        Assert.assertNotEquals(cartDataBeforeOrder,cartDataAfterOrder);
        clickElementByXpath_Chrome(shoppingCart);
        Assert.assertTrue(searchElementByXpath_Chrome(cartData).getText().toLowerCase().contains(bookToSearch.toLowerCase()));
    }

    @AfterClass
    public void tearDown() {
        webDriverChrome.quit();
    }


}
