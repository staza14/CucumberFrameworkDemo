package support

import io.cucumber.scala.{EN, ScalaDsl}
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}


class Hooks extends ScalaDsl with EN {

  val options = new ChromeOptions()
  options.addArguments("--headless=new")

  Before("@login") {
    println("Launching browser before scenario...")
    DriverManager.driver = new ChromeDriver(options)
    DriverManager.driver.manage().window().maximize()
  }

  After("@login") {
    println("Closing browser after scenario...")
    DriverManager.driver.quit()
  }

  Before("@form") {
    println("Launching *form* browser before scenario...")
//    // initialize driver
//    val driver: WebDriver = new ChromeDriver()
//    driver.manage().window().maximize()
//    driver.get("https://www.techlistic.com/p/selenium-practice-form.html")
  }

  After("@form") {
    println("Closing *form* browser after scenario...")
//    DriverManager.driver.quit()
  }


}
