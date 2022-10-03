package StepDefinitions;

import Functions.SeleniumFunctions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

public class Steps {

    WebDriver driver;

    SeleniumFunctions functions = new SeleniumFunctions();


    @Given("I Go App Main Site")
    public void IGoAppMainSite(){
        functions.GoAppMainSite();
    }

    @When("the user clip en button")
    public void the_user_enters_nameuser() {
        System.out.println("Paso 908998");

    }

    @And("the user enters nameuser")
    public void theUserEntersNameUser() {
        System.out.println("Paso 3");
    }

    @Then("^I load the DOM Information (.*)$")
    public void iLoadTheDOMInformation(String file) throws Exception {
        functions.LoadTheDOMInformationsFalabellaJson(file);
    }

    @And("^I do a click in element (.*)$")
    public void iClickInElement(String element) throws Exception{
        functions.ClickInElement(element);
    }

    @And("^I do mouseover in button element (.*) and desplegable Button element (.*)$")
        public void iDoMouseOverInElementAny(String element, String element2) throws Exception {
            functions.doMouseoverInElementAny(element, element2);
        }

        @And("^I do mouse move to element (.*)$")
        public void iDoMouseMoveToElement(String element) throws Exception {
        functions.mouseMoveTo(element);
        }

        @And("^I swich to windows$")
    public void iSwichToWindows() {
        functions.swichEmergentePage();
    }
    @And("^I switch to Frame: (.*)$")
    public void iSwitchToFrame(String frame) throws Exception {
        functions.switchToFrame(frame);
    }
    @And("^I wait (.*) seconds$")
    public void iWaitNSeconds(int sec) throws InterruptedException {
        functions.waitSeconds(sec);
    }

    @And("^I open new tab with URL (.*)$")
    public void iOpenNewTabWithURL(String url){
        functions.OpenNewTabWithURL(url);
    }

    @And("^I set (.*) with text (.*)$")
    public void iSetElementWithText(String element, String text) throws Exception {
        functions.setElementWithText(element,text);
    }
    @When("^I check the checkbox having (.*)$")
    public void iCheckCheckbox(String element) throws Exception {
        functions.checkCheckbox(element);
    }

    @Then("^Assert if (.*?) equals to (.*)$")
    public void assertIfEqualText(String element, String text) throws Exception {
        functions.checkTextElementEqualTo(element, text);
    }

    @Then("^I wait element (.*?) to be visible$")
    public void waitForElementVisible(String element) throws Exception
    {
        functions.waitForElementVisible(element);
    }


    }

