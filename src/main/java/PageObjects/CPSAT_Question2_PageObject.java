package PageObjects;

import CPSAT_PageFunction.CPSAT_PageFunction;
import org.openqa.selenium.By;

public class CPSAT_Question2_PageObject extends CPSAT_PageFunction {
    public static final By dropDownMenu_NoOfAttendee= By.xpath("//select[@name='drpAttendee']");
    public static final By selectOption3_NoOfAttendee=By.xpath("//select[@name='drpAttendee']//option[@value='3']");
    public static final By dropDownMenu_Title_Admiral=By.xpath("//select[@name='Gridview1$ctl02$drpTitle']");
    public static final By selectOption_Admiral=By.xpath("//select[@name='Gridview1$ctl02$drpTitle']//option[@value='Admiral']");
    public static final By dropDownMenu_Title_CA=By.xpath("//select[@name='Gridview1$ctl03$drpTitle']");
    public static final By selectOption_CA=By.xpath("//select[@name='Gridview1$ctl03$drpTitle']//option[@value='CA']");
    public static final By dropDownMenu_Title_CS=By.xpath("//select[@name='Gridview1$ctl04$drpTitle']");
    public static final By selectOption_CS=By.xpath("//select[@name='Gridview1$ctl04$drpTitle']//option[@value='CS']");


}
