package Com.nopcommerce.GenericMethods;



import Com.nopcommerce.testData.ReadJsonFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class GenericMethods extends ReadJsonFile {
    public static String Currenttestcase;

    public static WebDriver driver;
    /*
     *@Method name :: launchBrowser
     * @pams       :: browserType,url
     * @Purpose    :: this method will launch the browser given by the user
     * @returntype "" NA

     */
    @Step("Launching the browser")
    public static void launchBrowser(String browserType,String url){
//converting the user given input to uppercase
        switch (browserType.toUpperCase()){

            case "CHROME":
                //logic for chrome
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "FF":
                //logic for FF
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "EDGE":

                //logic for edge
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            default:
                System.out.println("Invalid browser");
        }

        //launch the application
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Documents\\ChromeWebDriver\\chromedriver.exe");
        //driver=new ChromeDriver();
        driver.get(url);
        // maximize the driver window
        driver.manage().window().maximize();

    }

    /**
     * @Method name  ::selectdropDownbyVisibletext
     * @Pupose :: this method to selet the dropdown visibletext given by the user
     * @param element
     * @param Option
     */
    @Step("Select the Dropdown {1} with the value {3} on page {0}")
    public static void selectDropDownByVisibletext(String pagename,String elementname,WebElement element, String Option) {


        Select dropDownOption=new Select(element);
        dropDownOption.selectByVisibleText(Option);
        System.out.println("Element "+element+ "has selected as "+Option);
    }
    /**
     * @Method name  ::selectdropDownbyvalue
     * @Pupose :: this method to selet the dropdown value given by the user
     * @param element
     * @param Option
     */
    public void selectDropDownByvalue(WebElement element , String Option) {


        Select dropDownOption=new Select(element);
        dropDownOption.selectByValue(Option);
    }

    /**
     * @Method name  ::selectdropDownbyindex
     * @Pupose :: this method to selet the dropdown index position given by user  given by the user
     * @param element
     * @param indexOption
     */
    public void selectDropDownByindex(WebElement element , int indexOption) {


        Select dropDownOption=new Select(element);
        dropDownOption.selectByIndex(indexOption);
    }
    public boolean checkIfDropDownSelected(WebElement element,String dafaultValue){
        boolean selected =false;
        Select dropDownOption=new Select(element);
        String dropDownvalue=dropDownOption.getFirstSelectedOption().getText();
        //check if dropdown selected or not
        if(!(dropDownvalue.equalsIgnoreCase(dafaultValue)|| dropDownvalue.length()==0||dropDownvalue.isEmpty())){//is empty need to ask
            System.out.println("dropDown is selected");
            selected=true;
        }else{
            System.out.println("Dropdown is not selected");
        }
        return selected;
    }

    public void waitForElementvisible(WebElement element,int seconds)
    {
        // System.out.println(element);
        String xpath=element.toString();
        xpath=xpath.substring(xpath.lastIndexOf(" "),xpath.length()-1);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }
    //code by rajasekhar
    public  void DragAndDrop(WebElement element1,WebElement element2){
        Actions ac=new Actions(driver);
        ac.dragAndDrop(element1,element2).build().perform();

    }
    @Step("Clicking the element {1} on page called  {0}")
    public void hoverAndclick(String pagename,String elementname,WebElement element){
        Actions acc=new Actions(driver);
        waitForElementvisible(element,5);
        acc.moveToElement(element).click().build().perform();
        System.out.println("Element "+elementname+" is clicked succefully on the "+pagename);

    }
    @Step("Enter the data for element {1} on Page called  {0}")
    public void clickAndSendData(String pagename,String elementname,WebElement element,String data){
        Actions acc=new Actions(driver);
        waitForElementvisible(element,5);
        acc.moveToElement(element).click().build().perform();
        element.clear();
        element.sendKeys(data);
        System.out.println("Element "+elementname+" is entered data "+data+" succefully on the "+pagename);

    }
    // code by rajendra
    public void draganddrop(WebElement source,WebElement target){
        Actions accd = new Actions(driver);
        accd.dragAndDrop(source,target).build().perform();
    }

    public void forceclick(WebElement element){
        JavascriptExecutor Js=  (JavascriptExecutor)driver;
        Js.executeScript("arguments[0].click();",element);

    }
    public String getsimpleDateFormat(String dt){
        Date date = new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("ddmmyyyy");
        String ipdate=formatter.format(date);
        //System.out.println(ipdate);
        return ipdate;
    }
    public void closeApplication(){
        driver.close();
        driver.quit();
    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] getScreenshot() {
        TakesScreenshot sht=(TakesScreenshot)driver;
        return sht.getScreenshotAs(OutputType.BYTES);
    }

}
