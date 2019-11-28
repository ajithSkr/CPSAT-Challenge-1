package PageObjects;

import CPSAT_PageFunction.CPSAT_PageFunction;
import org.openqa.selenium.By;

public class CPSAT_Question1_PageObject extends CPSAT_PageFunction {

    public static final By logo = By.xpath("//img[@title='Meripustak Online bookstore']");
    public static final By twitterLogo = By.xpath("//div[@class='social links_right']//a[@href='https://twitter.com/meripustak']");
    public static final By cartItem = By.xpath("//span[@id='lblNoCartItem']");
    public static final By shoppingCart = By.xpath("//a[@href='https://www.meripustak.com/cart']//span[@class='f12 db tar']");
    public static final By cartData = By.xpath("//table[@class='table-striped table-bordered cart_table']");
    public static final By searchField=By.xpath("//input[@id='txtsearch']");
    public static final By searchButton=By.xpath("//a[@class='srch']");
    public static final By bookList=By.xpath("//div[@class='book_list_name']");
    public static final By viewMoreButton=By.xpath("//span[@style='cursor:pointer;color:#ffffff; text-decoration:none;']");
    public static final By addToCart=By.xpath("//a[@style='cursor: pointer;font-weight: bold; font-size:12px;display:block;']");


}
