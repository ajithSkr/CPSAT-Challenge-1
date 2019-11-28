package PageObjects;

import CPSAT_PageFunction.CPSAT_PageFunction;
import org.openqa.selenium.By;

public class CPSAT_Question4_PageObject extends CPSAT_PageFunction {

    public static final By noThanksPopUpButton =By.xpath("//button[@class='align-right secondary popover-button']");
    public static final By electronicsOption=By.xpath("//a[@title='Electronics']");
    public static final By colorDropDownMenu=By.xpath("//div[@class='Div-ln5jk2-0 gdpwEk']//*[contains(text(),'Color')]");
    public static final By blackColor=By.xpath("//span[@style='background-color: rgb(0, 0, 0);']");
    public static final By appliedFiltersTab= By.xpath("//*[contains(text(),'Applied Filters')]");
    public static final By productImage=By.xpath("(//img[@class='Product__ProductImg-sc-1rop1s7-0 fABMoW'])[1]");
    public static final By quickViewOption=By.xpath("(//button[@class='QuickView__QuickViewBtn-sc-1sntg1-0 isPHJW'])[1]");
    public static final By imageTitle=By.xpath("//h1[@class='Heading-sc-1xt1x3f-0 efiseG']");
    public static final By appliedFilters=By.xpath("//div[@class='_1C7t6hCkKmMddDs8HIk_KY']//ul//li");



}
