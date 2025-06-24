package pages

import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.Select

object FormSubmissionPage {

  // initialize driver
  val driver: WebDriver = new ChromeDriver()
  // instantiating executor so we can scroll down to the specified element
  val js: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]

  // navigate to correct page

  def launchBrowser(): Unit = {
    driver.get("https://www.techlistic.com/p/selenium-practice-form.html")
  }

  // accept cookies
  def acceptCookies(): Unit = {
    driver.findElement(By.id("ez-accept-necessary")).click()
  }

  // First name
  def inputFirstName(text: String): Unit = {
    val firstnameInput: WebElement = driver.findElement(By.name("firstname"))
    js.executeScript("arguments[0].scrollIntoView(true);", firstnameInput)
    firstnameInput.clear()
    firstnameInput.sendKeys(text)
  }

  // Last name
  def inputLastName(text: String): Unit = {
    val lastnameInput:WebElement = driver.findElement(By.name("lastname"))
    lastnameInput.clear()
    lastnameInput.sendKeys(text)
  }

  // gender radio button
  def selectGender(gender: String): Unit = {
    val id:String = gender.trim.toLowerCase match {
      case "male" => "sex-0"
      case "female" => "sex-1"
    }
    driver.findElement(By.id(id)).click()
  }

  // experience
  def selectExperience(years: Int): Unit = {
    if (years < 1 || years > 7) {
      println("Years of experience must be between 1 and 7")
    }
    // turn the number entered into an id that matches ( they start at 0 so -1)
    val id = s"exp-${years - 1}"
    driver.findElement(By.id(id)).click()
  }

  //date
  def enterDate(date: String): Unit = {
    val dateField = driver.findElement(By.id("datepicker"))
    dateField.clear()
    dateField.sendKeys(date)
  }

  // profession
  // Make sure to call this with a list, even if its one element
  def selectProfessions(professions: List[String]): Unit = {

    professions.foreach {
      case "manual tester" =>
        val manualCheckbox = driver.findElement(By.id("profession-0"))
        if (!manualCheckbox.isSelected){
          manualCheckbox.click()
        }
      case "automation tester" =>
        val automationCheckbox = driver.findElement(By.id("profession-1"))
        if (!automationCheckbox.isSelected){
          automationCheckbox.click()
        }
    }
  }

  // automation tools
  def selectAutomationTools(tools: List[String]): Unit = {
    tools.foreach {
      case "qtp" =>
        val uft = driver.findElement(By.id("tool-0"))
        if (!uft.isSelected) uft.click()
      case "selenium ide" =>
        val protractor = driver.findElement(By.id("tool-1"))
        if (!protractor.isSelected) protractor.click()
      case "selenium webdriver" =>
        val selenium = driver.findElement(By.id("tool-2"))
        if (!selenium.isSelected) selenium.click()
    }
  }

  // continent
  def selectContinent(continent: String): Unit = {
    // finding drop down
    val continentDropdown:WebElement = driver.findElement(By.id("continents"))
    // creating a selenium dropdown element
    val select = new Select(continentDropdown)
    // select by visible text
    select.selectByVisibleText(continent)
  }

  // file upload

  def uploadImage(filePath:String): Unit = {
    driver.findElement(By.id("photo")).sendKeys(filePath)
  }

  // submit
  def clickSubmit(): Unit = {
    val button:WebElement = driver.findElement(By.id("submit"))
  }
}
