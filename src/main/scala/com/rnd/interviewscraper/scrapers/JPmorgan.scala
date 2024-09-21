package main.scala.com.rnd.interviewscraper.scrapers

import org.openqa.selenium.{By, WebElement}
import org.openqa.selenium.chrome.{ChromeDriver, ChromeOptions}
import org.openqa.selenium.remote.RemoteWebDriver

import java.time.Duration
import scala.io.Source

class JPmorgan {
  System.setProperty("webdriver.chrome.driver" , "/Users/shikalga/Downloads/chromedriver-mac-x64/chromedriver")

  val url: String = "https://jpmc.fa.oraclecloud.com/hcmUI/CandidateExperience/en/sites/CX_1001"
//  val html: String = "JPMorgan.html"

    def scrape(): Unit = {
      val options = new ChromeOptions
      options.addArguments("--remote-allow-origins=*")
      val driver = new ChromeDriver(options)
      driver.manage.window.maximize()
      driver.manage.deleteAllCookies()
      driver.manage.timeouts.pageLoadTimeout(Duration.ofSeconds(40))
      driver.manage.timeouts.implicitlyWait(Duration.ofSeconds(30))

      driver.get(url);

      val jobTitleInput = driver.findElement(By.cssSelector("input[placeholder='Job title, skill, keyword']"))
      Thread.sleep(1000)
      jobTitleInput.clear()
      jobTitleInput.sendKeys("Software Engineer")

      val locationInput = driver.findElement(By.cssSelector("input[placeholder='City, state, country']"))
      Thread.sleep(1000)
      locationInput.clear()
      locationInput.sendKeys("India")

      val searchButton: WebElement = driver.findElement(By.cssSelector("button[title='Search for Jobs']"))
      searchButton.click()

      print("aa")
    }

}
