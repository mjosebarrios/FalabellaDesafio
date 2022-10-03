package Functions;
import StepDefinitions.Hooks;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Set;

public class SeleniumFunctions {
    public String ElementText = "";

    static WebDriver driver;
    /******** Page Path ********/
    public static String FileName = "";
    public static String PagesFilePath = "src/test/resources/Pages/";

    public static String GetFieldBy = "";
    public static String ValueToFind = "";
    public static final int EXPLICIT_TIMEOUT = 9;

    public SeleniumFunctions(){driver = Hooks.driver;}

    public static Object readJson() throws Exception {
        FileReader reader = new FileReader(PagesFilePath + FileName);
        try {

            if (reader != null) {
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            } else {
                return null;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            throw new IllegalStateException("ReadEntity: No existe el archivo " + FileName, e);
        }


    }

    public static JSONObject ReadEntity(String element) throws Exception {
        JSONObject Entity = null;

        JSONObject jsonObject = (JSONObject) readJson();
        Entity = (JSONObject) jsonObject.get(element);
        return Entity;

    }

    public static By getCompleteElement(String element) throws Exception {
        By result = null;
        JSONObject Entity = ReadEntity(element);

        GetFieldBy = (String) Entity.get("GetFieldBy");
        ValueToFind = (String) Entity.get("ValueToFind");

        if ("className".equalsIgnoreCase(GetFieldBy)) {
            result = By.className(ValueToFind);
        } else if ("cssSelector".equalsIgnoreCase(GetFieldBy)) {
            result = By.cssSelector(ValueToFind);
        } else if ("id".equalsIgnoreCase(GetFieldBy)) {
            result = By.id(ValueToFind);
        } else if ("linkText".equalsIgnoreCase(GetFieldBy)) {
            result = By.linkText(ValueToFind);
        } else if ("name".equalsIgnoreCase(GetFieldBy)) {
            result = By.name(ValueToFind);
        } else if ("link".equalsIgnoreCase(GetFieldBy)) {
            result = By.partialLinkText(ValueToFind);
        } else if ("tagName".equalsIgnoreCase(GetFieldBy)) {
            result = By.tagName(ValueToFind);
        } else if ("xpath".equalsIgnoreCase(GetFieldBy)) {
            result = By.xpath(ValueToFind);
        }
        return result;
    }

    public void LoadTheDOMInformationsFalabellaJson(String json) throws Exception {
        FileName = json;
        readJson();
    }

    public void GoAppMainSite() {
        //Chrome Options cambiar agente
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--user-agent=Mozilla/5.0 (Linux; Android 6.0; HTC One M9 Build/MRA58K) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.98 Mobile Safari/537.36");
        //options.addArguments("--start-maximized");


        /*System.setProperty("webdriver.chrome.driver", "src/test/java/Driver/chromedriver.exe");
        driver = new ChromeDriver();
        //driver = new ChromeDriver(options);
        driver.manage().window().maximize();*/
        driver.navigate().to("https://www.falabella.com/falabella-cl");

    }

    public void ClickInElement(String element) throws Exception {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        driver.findElement(SeleniumElement).click();
    }

    public void doMouseoverInElementAny(String element, String element2) throws Exception {
    By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
    By SeleniumElement2 = SeleniumFunctions.getCompleteElement(element2);
    Actions action = new Actions(driver);
        WebElement we = driver.findElement(SeleniumElement);
        action.moveToElement(we).moveToElement(driver.findElement((SeleniumElement2))).click().build().perform();
    }

    public void swichEmergentePage(){
        Set<String> s = driver.getWindowHandles();
        String parent = driver.getWindowHandle();
        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {
            String child_window = I1.next();
        }
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
            }

        }
    }

    public void switchToFrame(String Frame) throws Exception {
        By SeleniumElement = getCompleteElement(Frame);
        driver.switchTo().frame(driver.findElement(SeleniumElement));
    }

    public void waitSeconds(int seconds) throws InterruptedException{
        int sec = seconds *1000;
        Thread.sleep(sec);
    }
    public void OpenNewTabWithURL(String url){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript(String.format("window.open('%s','_blank');",url));
    }
    public void setElementWithText(String element, String text) throws Exception {
        By SeleniumElement = getCompleteElement(element);
        driver.findElement(SeleniumElement).sendKeys(text);
    }
     public void checkCheckbox(String element) throws Exception {
        By SeleniumElement = getCompleteElement(element);
        boolean isChecked = driver.findElement(SeleniumElement).isSelected();
        if(!isChecked){
            driver.findElement(SeleniumElement).click();
        }
     }

     public String GetTextElement(String element) throws Exception {
        By SeleniumElement = getCompleteElement(element);
         //WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
         ElementText = driver.findElement(SeleniumElement).getText();
         return ElementText;
     }

     public void checkTextElementEqualTo(String element,String text) throws Exception {
        ElementText = GetTextElement(element);
         Assert.assertEquals("Text is not equals, current text is: " + ElementText, text, ElementText);
     }

     public void mouseMoveTo(String element) throws Exception {
        By SeleniumElement = getCompleteElement(element);
         WebElement hoverable = driver.findElement(SeleniumElement);
         new Actions(driver).moveToElement(hoverable).perform();
     }
    public void waitForElementVisible(String element) throws Exception
    {
        By SeleniumElement = SeleniumFunctions.getCompleteElement(element);
        WebDriverWait w = new WebDriverWait(driver, EXPLICIT_TIMEOUT);
        w.until(ExpectedConditions.visibilityOfElementLocated(SeleniumElement));
    }



}
