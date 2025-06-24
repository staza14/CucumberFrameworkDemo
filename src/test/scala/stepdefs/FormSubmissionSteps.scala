package stepdefs

import io.cucumber.scala.{EN, ScalaDsl}
import pages.FormSubmissionPage
import pages.FormSubmissionPage.{acceptCookies, clickSubmit, enterDate, inputFirstName, inputLastName, launchBrowser, selectAutomationTools, selectContinent, selectExperience, selectGender, selectProfessions, uploadImage}

class FormSubmissionSteps extends ScalaDsl with EN {

  Given("""the user is on the practice form page""") { () =>
    launchBrowser()
    println("Browser launched")
  }

  And("""accepts the webpage cookies""") { () =>
    acceptCookies()
    println("accepted cookies")
  }

  And("""enters a first name""") { () =>
    inputFirstName("Jane")
    println("Entered first name")
  }

  And("""enters a last name""") { () =>
    inputLastName("Doe")
    println("Entered last name")
  }

  And("""selects a gender radio button""") { () =>
    selectGender("Female")
    println("Gender selected")
  }

  And("""selects an experience radio button""") { () =>
    selectExperience(4)
    println("Selected experience")
  }

  And("""enters a date""") { () =>
    enterDate("19/06/2025")
    println("Entered date")
  }

  And("""checks a profession""") { () =>
    selectProfessions(List("automation tester"))
    println("Chose profession")
  }

  And("""chooses automation tools""") { () =>
    selectAutomationTools(List("qtp", "selenium webdriver"))
    println("chose automation tools ")
  }

  And("""chooses a continent""") { () =>
    selectContinent("Europe")
    println("chose continent ")
  }

  And("""uploads a file""") { () =>
    uploadImage("/Users/anastasia.florentis/Desktop/testImage.jpg")
    println("uploaded image")
  }

  When("""the user clicks on the submit button""") { () =>
    clickSubmit()
  }

  Then("""the a line should be printed saying "button found"""") { () =>
    println("Submit button found and 'clicked'")
  }

}