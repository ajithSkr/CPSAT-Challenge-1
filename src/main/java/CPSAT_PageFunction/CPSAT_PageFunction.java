package CPSAT_PageFunction;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class CPSAT_PageFunction {
    public static WebDriver webDriverChrome;
    public static WebDriver webDriverFireFox;

    public static void loadWebPageChrome(String url) throws IOException {
        System.setProperty("webdriver.chrome.driver", "/Users/ajith.athithyan/Downloads/Apps/Drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-notifications");
        webDriverChrome = new ChromeDriver(chromeOptions);
        webDriverChrome.manage().window().maximize();
        webDriverChrome.get(url);
    }

    public static void loadWebPageFireFox(String url) {
        System.setProperty("webdriver.gecko.driver", "/Users/ajith.athithyan/Downloads/Apps/Drivers/geckodriver");
        webDriverFireFox = new FirefoxDriver();
        webDriverFireFox.manage().window().maximize();
        webDriverFireFox.get(url);
    }

    public static Properties getProperties() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("/Users/ajith.athithyan/Documents/MyProjects/Selenium_CPSAT-Challenge1/src/test/resources/config.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }

    public static void waitForParticularTime(Long time) throws InterruptedException {
        time = time * 1000;
        Thread.sleep(time);
    }

    public static void implicityWait_Chrome(Long time) {
        webDriverChrome.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static void waitUntilTheElementIsVisible_Chrome(Long time, By locator) {
        WebDriverWait wait = new WebDriverWait(webDriverChrome, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilTheElementIsVisible_FireFox(Long time, By locator) {
        WebDriverWait wait = new WebDriverWait(webDriverFireFox, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void waitUntilTheElementIsClickable_FireFox(Long time, By locator) {
        WebDriverWait wait = new WebDriverWait(webDriverFireFox, time);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void implicityWait_FireFox(Long time) {
        webDriverFireFox.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
    }

    public static WebElement searchElementByXpath_Chrome(By locator) {
        WebElement webElement = webDriverChrome.findElement(locator);
        return webElement;
    }

    public static List<WebElement> searchElementsByXpath_Chrome(By locator) {
        List<WebElement> webElement = webDriverChrome.findElements(locator);
        return webElement;
    }


    public static WebElement searchElementByXpath_FireFox(By locator) {
        WebElement webElement = webDriverFireFox.findElement(locator);
        return webElement;
    }

    public static List<WebElement> searchElementsByXpath_FireFox(By locator) {
        List<WebElement> webElement = webDriverFireFox.findElements(locator);
        return webElement;
    }

    public static void clickElementByXpath_Chrome(By locator) {
        webDriverChrome.findElement(locator).click();
    }

    public static void clickElementByXpath_FireFox(By locator) {
        webDriverFireFox.findElement(locator).click();
    }

    public static void writeDataByXpath_Chrome(By locator, String text) {
        webDriverChrome.findElement(locator).sendKeys(text);
    }

    public static void writeDataByXpath_FireFox(By locator, String text) {
        webDriverFireFox.findElement(locator).sendKeys(text);
    }

    public static void scrollElementByXpath_Chrome(WebElement webElement) throws InterruptedException {
        ((JavascriptExecutor) webDriverChrome).executeScript("arguments[0].scrollIntoView(true);", webElement);
        waitForParticularTime(5L);
    }

    public static void scrollElementByXpath_FireFox(WebElement webElement) throws InterruptedException {
        ((JavascriptExecutor) webDriverFireFox).executeScript("arguments[0].scrollIntoView(true);", webElement);
        waitForParticularTime(5L);
    }

    public static void scrollToRequiredArea_FireFox(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) webDriverFireFox;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    public static void scrollToRequiredArea_Chrome(int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) webDriverFireFox;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

    public void moveElement_FireFox(By locator) {
        Actions actions = new Actions(webDriverFireFox);
        actions.moveToElement(searchElementByXpath_FireFox(locator)).perform();
    }

    public static void contextClick_FireFox(By locator) throws InterruptedException {
        Actions actions = new Actions(webDriverFireFox);
        WebElement locateElement = searchElementByXpath_FireFox(locator);
        actions.moveToElement(locateElement);
        waitForParticularTime(2L);
        actions.contextClick().keyDown(Keys.SHIFT).click(locateElement).keyUp(Keys.SHIFT).build().perform();
    }

    public static void contextClick_Chrome(By locator) {
        Actions actions = new Actions(webDriverChrome);
        WebElement locateElement = webDriverChrome.findElement(locator);
        actions.contextClick(locateElement).perform();

    }


      public Object[][] getProducts() throws IOException {
        List<String> products= new LinkedList<String>();
        Object[] getProducts=null;
        InputStream inp = new FileInputStream("/Users/ajith.athithyan/Documents/MyProjects/Selenium_CPSAT-Challenge1/src/main/resources/ProductList.xlsx");
        int ctr = 1;
        Workbook wb = WorkbookFactory.create(inp);
        Sheet sheet = wb.getSheetAt(0);
        Row row = null;
        Cell cell = null;
        boolean isNull = false;
        do {
            try {
                row = sheet.getRow(ctr);
                cell = row.getCell(1);
                products.add(cell.toString());
                ctr++;
            } catch (Exception e) {
                isNull = true;
            }

        } while (isNull != true);
        inp.close();
        Object [] a= products.toArray();
        for(int i=0;i<products.size();i++)
        {
            getProducts= new Object[]{products.get(i).toString()};
        }
        return new Object[][]{getProducts};
    }
    @DataProvider(name="Get products")
    public Iterator<Object[]>getValues()
    {
        ArrayList<Object[]>userData=new ArrayList<Object[]>();
        try
        {
            File file= new File("/Users/ajith.athithyan/Documents/MyProjects/Selenium_CPSAT-Challenge1/src/main/resources/ProductList.xlsx");
            FileInputStream fileInputStream= new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row = null;
            Iterator iterator = sheet.rowIterator();
            int rownum=0;
            while(iterator.hasNext())
            {
                row = (XSSFRow) iterator.next();
                if(rownum>0)
                {
                    String product= row.getCell(1).toString();
                    Object data[]= {product};
                    userData.add(data);
                }
                rownum++;
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        ArrayList<Object[]> testdata=userData;
        return testdata.iterator();



    }


}

