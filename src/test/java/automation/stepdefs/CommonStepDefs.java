package automation.stepdefs;

import automation.commonControls.Navigator;
import automation.pageObjects.Canvas;
import automation.pageObjects.HelpAbout;
import automation.pageObjects.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import java.util.ArrayList;
;

public class CommonStepDefs extends AbstractPageStepDefs {
	WebDriver driver = getDriver();


//	@Before
	public void beforeTest() {
		driver = getDriver();
	}

//	@After
	public void afterTest() {
		driver.close();
		setDriver(null);

	}

	@Given("^I navigate to a landing page$")
	public void i_navigate_to_login_page() throws InterruptedException {
	    beforeTest();
		driver.navigate().to(Navigator.landingPage);
		driver.manage().window().maximize();
		assertTrue(driver.getTitle().equals("Span Workspace"));
		Thread.sleep(5000);

	}

	@When("^I enter my email \"([^\"]*)\" and push Next button$")
	public void iEnterMy(String arg0) throws InterruptedException {
		driver.findElement(By.xpath(LoginPage.cont)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(LoginPage.email)).sendKeys(arg0);
		Thread.sleep(1000);
		driver.findElement(By.id(LoginPage.NextButton)).click();
		Thread.sleep(2000);
	}

	@And("^I enter a password value \"([^\"]*)\" and push LogIn$")
	public void iEnterAPasswordValueAndPushLogIn(String arg0) throws InterruptedException {
		driver.findElement(By.id(LoginPage.passwd)).sendKeys(arg0);
		Thread.sleep(2000);
		driver.findElement(By.id(LoginPage.LoginButton)).click();
		Thread.sleep(2000);

	}

	@Then("^I expect to navigate to the Canvases page$")
	public void iExpectToNavigateToTheCanvasesPage() throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(driver.getTitle().equals("Span Workspace canvases"));
	}


	@And("^I create the new canvas, push Create Canvas$")
	public void iCreateTheNewCanvasPushCreateCanvas() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(Canvas.Create_Canvas)).click();
	}

	@And("^Verify Canvas name$")
	public void verifyUntitledCanvas() throws InterruptedException {
		Thread.sleep(3000);
		assertTrue(driver.findElement(By.id(Canvas.Canvas_UnTitle_name)).getText().equals("Untitled Canvas"));
	}


	@When("^Click on the 'Help' menu item, the click 'Getting started'$")
	public void clickOnTheHelpMenuItemTheClickGettingStarted() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.questionMarkButton)).click();
	    Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.gettinStarted)).click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath(HelpAbout.getttingStartedPage)).getText();
		Thread.sleep(2000);
		assertTrue(text.equals("Getting started"));
		driver.findElement(By.xpath(HelpAbout.closeGettingStarted)).click();
	}

	@And("^Click on the 'Help' menu item, then click on the 'Customer Support'$")
	public void clickOnTheHelpMenuItemThenClickOnTheCustomerSupport() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.questionMarkButton)).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText(HelpAbout.customerSupport)).click();
		Thread.sleep(1000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(1000);
		assertTrue(driver.getCurrentUrl().equals("https://nureva.helpjuice.cm/"));
		Thread.sleep(1000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
}

	@And("^Click on the 'Help' menu item, then on 'About'$")
	public void clickOnTheHelpMenuItemThenOnAbout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.questionMarkButton)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.showAbout)).click();
	}


	@Then("^Span software information panel verification$")
	public void spanSoftwareInformationPanelVerification() throws InterruptedException {
		Thread.sleep(2000);
		String testURL = driver.findElement(By.linkText(HelpAbout.getSpanWorkspaceInformation)).getText();
		assertTrue(testURL.equalsIgnoreCase("http://www.nureva.com/privacy-policy"));

	}

	@And("^Click on Software license and general terms of use panel$")
	public void clickOnSoftwareLicenseAndGeneralTermsOfUsePanel() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.swLicense)).click();

	}

	@And("^Toggle between French and English$")
	public void toggleBetweenFrenchAndEnglish() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.radioFrench)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.radioEnglish)).click();
	}

	@And("^Click on Intellectual property statement$")
	public void clickOnIntellectualPropertyStatement() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.intellectualProperty)).click();
		Thread.sleep(1000);
		String txt = driver.findElement(By.xpath(HelpAbout.statement)).getText();
		Thread.sleep(1000);
		assertTrue(txt.equals("Statement of Intellectual Property"));
		Thread.sleep(1000);
		afterTest();
	}

	@And("^Change Canvas name \"([^\"]*)\"$")
	public void changeCanvasName(String arg0) throws Throwable {
		Thread.sleep(3000);
		WebElement myElem = driver.findElement(By.id(Canvas.Canvas_UnTitle_name));
		myElem.click();
		Thread.sleep(3000);
		myElem.sendKeys(arg0);
		Thread.sleep(3000);
		myElem.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	@And("^I add note to canvas$")
	public void iAddNoteToCanvas() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.Add_Note)).click();
		Thread.sleep(1000);
		driver.findElement(By.id(Canvas.editNote)).sendKeys("Hello world");
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.complete_note)).click();
		Thread.sleep(1000);
		WebElement From = driver.findElement(By.xpath(Canvas.noteFrame));
		Thread.sleep(1000);
		WebElement To = driver.findElement(By.id(Canvas.backgroundImg));
		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(From)

				.moveByOffset(0, -100)

				.release()

				.build();

		dragAndDrop.perform();
	}

	@Then("^Share with few people$")
	public void shareWithFewPeople() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.dots)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.share)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.addUser)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.addQAUser)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.addButton)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.shareButton)).click();
	}

	@And("^Duplicate canvas and verify duplicate window$")
	public void duplicateCanvasAndVerifyDuplicateWindow() throws InterruptedException {

		Thread.sleep(4000);
		driver.findElement(By.xpath(Canvas.dots)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.duplicate)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.checkBox)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.duplicateButton)).click();


	}

	@And("^Verify share users exist in copy$")
	public void verifyShareUsersExistInCopy() throws InterruptedException {
		Thread.sleep(4000);
		driver.findElement(By.xpath(Canvas.dots)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.share)).click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath(Canvas.verifyShareUser)).isDisplayed());
		driver.findElement(By.xpath(Canvas.cancelButton)).click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath(Canvas.getNoteFromCanvas)).isDisplayed());
	}

	@And("^Delete the Copy canvas$")
	public void deleteTheCopyCanvas() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(Canvas.dots)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.moveToTrashButton)).click();
	}


	@And("^Delete the Test canvas$")
	public void deleteTheTestCanvas() throws InterruptedException {
		try {
			if (driver.findElement(By.xpath("//div[@ng-click='ctrl.goToCanvasList()']")).isDisplayed()) {
				driver.findElement(By.xpath("//div[@ng-click='ctrl.goToCanvasList()']")).click();
			}

		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath(Canvas.canvasTest)).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Canvas.dots)).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Canvas.moveToTrashButton)).click();
            Thread.sleep(1000);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}


		afterTest();
	}

	@And("^Create sketch using Create menu$")
	public void createSketchUsingCreateMenu() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.createSketch)).click();
	}

	@And("^Click on the sketch to trigger the quick toolbar$")
	public void clickOnTheSketchToTriggerTheQuickToolbar() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.doneButton)).click();
	}

	@And("^Verify the dots menu for the sketch$")
	public void verifyTheDotsMenuForTheItemOnTheCanvas() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.chevron)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.sketchDots)).click();
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath(Canvas.sketchMenuDuplicate)).isDisplayed());
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath(Canvas.sketchMenuCopt)).isDisplayed());
		Thread.sleep(1000);
		assertTrue(driver.findElement(By.xpath(Canvas.sketchMenuAddLink)).isDisplayed());
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.doneButton)).click();
	}

	@And("^Move sketch on canvas$")
	public void moveSketchOnCanvas() throws InterruptedException {

	}

	@And("^Open the item in editor on the private tray$")
	public void openTheItemInEditorOnThePrivateTray() throws InterruptedException {
        Thread.sleep(1000);
	}

	@And("^Post sketch to canvas from private tray$")
	public void postSketchToCanvasFromPrivateTray() throws InterruptedException {
		Thread.sleep(1000);
		WebElement From = driver.findElement(By.xpath(Canvas.sketchFrame));
		Thread.sleep(1000);
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(From)
				.moveByOffset(100, -200)
				.release()
				.build();
		dragAndDrop.perform();
	}

	@Then("^Edit sketch on canvas$")
	public void editSketchOnCanvas() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.sketchMenuEdit)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchThinPen)).click();
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath(Canvas.sketchCanvas));
		Actions builder = new Actions(driver);
		Action drawAction = builder.moveToElement(element, 100, 120)
				.clickAndHold()
				.moveByOffset(200, 0).moveByOffset(0, 200).moveByOffset(10, -200)
				.release()
				.build();
		drawAction.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchBlueColor)).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.sketchThickPen)).click();
		Thread.sleep(1000);

		drawAction = builder.moveToElement(element, 100, 200)
				.clickAndHold()
				.moveByOffset(350, 0)
				.release()
				.build();
		drawAction.perform();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchEraser)).click();
		Thread.sleep(3000);
		drawAction = builder.moveToElement(element, 200, 10)
				.clickAndHold()
				.moveByOffset(0, 150).moveByOffset(-50, -100).moveByOffset(20, 200)
				.release()
				.build();
		drawAction.perform();
		driver.findElement(By.xpath(Canvas.doneButton)).click();
	}
	@And("^Create group$")
	public void createGroup() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath(Canvas.createGroup)).click();
		Thread.sleep(1000);
		WebElement myElem = driver.findElement(By.id(Canvas.createGroupName));
		myElem.click();
		myElem.clear();
		myElem.sendKeys("Test Group");
		myElem.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.doneButton)).click();
		Thread.sleep(1000);
		WebElement group = driver.findElement(By.xpath(Canvas.addGroup));
		Actions builder = new Actions(driver);

		Action dragAndDrop = builder.clickAndHold(group)

				.moveByOffset(500, -100)

				.release()

				.build();

		dragAndDrop.perform();
	}

	@And("^Resize sketch on canvas$")
	public void resizeSketchOnCanvas() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.xpath(Canvas.sketchZoomIn)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(Canvas.sketchZoomOut)).click();
		WebElement sketchCircleZoom = driver.findElement(By.xpath(Canvas.sketchCircleZoom));
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(sketchCircleZoom)

				.moveByOffset(-40, -40)

				.release()

				.build();
		Thread.sleep(2000);
		dragAndDrop.perform();
		Thread.sleep(2000);
		dragAndDrop = builder.clickAndHold(sketchCircleZoom)

				.moveByOffset(40, 40)

				.release()

				.build();
		Thread.sleep(2000);
		dragAndDrop.perform();
		Thread.sleep(2000);


	}

	@And("^Duplicate sketch on canvas$")
	public void duplicateSketchOnCanvas() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath(Canvas.sketchOnCanvasDots)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchMenuDuplicateIcon)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchOnCanvasDots)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchMenuDelete)).click();

	}

	@And("^Copy sketch on canvas$")
	public void copySketchOnCanvas() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchFocus)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchOnCanvasDots)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@ng-if='quickops.hasCopy()']")).click();

		//WebElement sketchBackgroundRightClick = driver.findElement(By.id("backgroundImg"));
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.id("scaleDiv"))).perform();
		driver.findElement(By.xpath("//button[@class='paste-button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchFocus)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.sketchOnCanvasDots)).click();
		driver.findElement(By.xpath(Canvas.sketchMenuDelete)).click();


	}

	@And("^Verify after all manipulations draw is still there$")
	public void verifyAfterAllManipulationsDrawIsStillThere() throws InterruptedException {
		Thread.sleep(2000);
		assertTrue(driver.findElement(By.xpath("//*[name()='polyline' and @class='ng-scope ng-isolate-scope']")).isEnabled());
	}

	@And("^Add sketches and export canvas$")
	public void addSketchesAndExportCanvas() throws InterruptedException {
        Thread.sleep(2000);
		driver.findElement(By.xpath(Canvas.dots)).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(), 'Export')]")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(), 'Excel')]")).click();
        Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(), 'Send email')]")).click();

	}


	@And("Click on the Help menu item")
	public void clickOnTheHelpMenuItem() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.questionMarkButton)).click();
	}


	@When("Click on Getting Started")
	public void clickOnGettingStarted() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.gettinStarted)).click();
	}

	@Then("Verify Getting Started")
	public void verifyGettingStarted() throws  Throwable {
		String text = driver.findElement(By.xpath(HelpAbout.getttingStartedPage)).getText();
		Thread.sleep(2000);
		assertTrue((text.equals("Getting started")));
		driver.findElement(By.xpath(HelpAbout.closeGettingStarted)).click();
	}

	@When("Click on the Customer Support")
	public void clickOnTheCustomerSupport() {
		driver.findElement(By.linkText(HelpAbout.customerSupport)).click();
	}

	@Then("Verify Customer Support")
	public void verifyCustomerSupport() throws Throwable{
        Thread.sleep(2000);
		String url = driver.getCurrentUrl();
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
        Thread.sleep(2000);

		driver.close();
		driver.switchTo().window(tabs.get(0));

		if(!url.equals("https://nureva.helpjuice.cm/")){
			fail("URL is wrong");
		}
	}

	@When("Click on About")
	public void clickOnAbout() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath(HelpAbout.showAbout)).click();
	}


	@Then("Close driver")
	public void closeDriver() {
		afterTest();
	}
}
