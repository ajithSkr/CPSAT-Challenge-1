
import PageObjects.CPSAT_Question2_PageObject;
import org.junit.*;
import org.junit.runner.Description;
import org.junit.runners.MethodSorters;

import java.io.IOException;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CPSAT_Question2_Test extends CPSAT_Question2_PageObject {

    @BeforeClass
    public static void preSetup() throws IOException {
        loadWebPageFireFox(getProperties().getProperty("question2_URL"));
        implicityWait_FireFox(30L);

    }
    @Test
    public void tc_01_selectNumberOfAttendeesAs_3() throws InterruptedException {
        waitForParticularTime(3L);
        String optionToSelect="3";
        clickElementByXpath_FireFox(dropDownMenu_NoOfAttendee);
        clickElementByXpath_FireFox(selectOption3_NoOfAttendee);
        String selectedOption=searchElementByXpath_FireFox(selectOption3_NoOfAttendee).getText();
        Assert.assertEquals(selectedOption,optionToSelect);
    }
    @Test
    public void tc_02_selectTheRowAsAdmiral() throws InterruptedException {
        waitForParticularTime(3L);
        String titleToSelect="Admiral";
        clickElementByXpath_FireFox(dropDownMenu_Title_Admiral);
        clickElementByXpath_FireFox(selectOption_Admiral);
        String selectedTitle=searchElementByXpath_FireFox(selectOption_Admiral).getText();
        Assert.assertEquals(selectedTitle,titleToSelect);
    }
    @Test
    public void tc_03_selectTheRowAsCA() throws InterruptedException {
        waitForParticularTime(3L);
        String titleToSelect="CA";
        clickElementByXpath_FireFox(dropDownMenu_Title_CA);
        clickElementByXpath_FireFox(selectOption_CA);
        String selectedTitle=searchElementByXpath_FireFox(selectOption_CA).getText();
        Assert.assertEquals(selectedTitle,titleToSelect);

    }
    @Test
    public void tc_04_selectTheRowAsCS() throws InterruptedException {
        waitForParticularTime(3L);
        String titleToSelect="CS";
        clickElementByXpath_FireFox(dropDownMenu_Title_CS);
        clickElementByXpath_FireFox(selectOption_CS);
        String selectedTitle=searchElementByXpath_FireFox(selectOption_CS).getText();
        Assert.assertEquals(selectedTitle,titleToSelect);

    }
    @Test
    public void tc_05_printAllTheOptionsAvailableInTheTitles()
    {
        System.out.println("Selected Title 1 = "+searchElementByXpath_FireFox(selectOption_Admiral).getText());
        System.out.println("Selected Title 2 = "+searchElementByXpath_FireFox(selectOption_CA).getText());
        System.out.println("Selected Title 3 = "+searchElementByXpath_FireFox(selectOption_CS).getText());
    }
    @AfterClass
    public static void tearDown()
    {
        webDriverFireFox.quit();
    }


}
