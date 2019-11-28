package PageObjects;

import CPSAT_PageFunction.CPSAT_PageFunction;
import org.openqa.selenium.By;

public class CPSAT_Question3_PageObject extends CPSAT_PageFunction {

    public static final By premierLeagueHeader=By.xpath("//div[@class='navLink active  ']//span[contains(text(),'Premier League')]");
    public static final By tables=By.xpath("//a[contains(text(),'Tables')]");
    public static final By acceptCookiesPopUp=By.xpath("//div[@class='btn-primary cookies-notice-accept']");
    public static final By closeButton=By.xpath("//a[@class='closeBtn']");
    public static final By arsenalClub=By.xpath("//span[@class='badge-25 t3']");


}
