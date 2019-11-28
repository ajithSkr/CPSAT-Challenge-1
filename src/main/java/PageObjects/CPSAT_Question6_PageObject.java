package PageObjects;

import CPSAT_PageFunction.CPSAT_PageFunction;
import org.openqa.selenium.By;

public class CPSAT_Question6_PageObject extends CPSAT_PageFunction {

    public static final By searchButton=By.xpath("//div[@class='floatright spirit-bg search-icon searchIcon']");
    public static final By searchField=By.xpath("//input[@placeholder='search the website...']");
    public static final By goButton=By.xpath("//input[@id='searchBtn']");
    public static final By filterHighToLow=By.xpath("//li[@class='spaceright radioSortBy']");
    public static final By mrpPrizes=By.xpath("//span[@class='mrp']");
}
