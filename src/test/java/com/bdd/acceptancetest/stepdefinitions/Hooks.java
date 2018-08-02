package com.bdd.acceptancetest.stepdefinitions;

import com.bdd.acceptancetest.util.BrowserDriver;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import java.net.MalformedURLException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


public class Hooks {

  public static WebDriver driver;
  public static String baseUrl = "https://weather-acceptance.herokuapp.com/";


  @Before
  /**
   * Delete all cookies at the start of each scenario to avoid
   * shared state between tests
   */
  public void openBrowser() throws MalformedURLException {
    System.out.println("Navigate to the homepage");
    driver = BrowserDriver.getCurrentDriver();
  }


  @After
  /**
   * Embed a screenshot in test report if test is marked as failed
   */
  public void embedScreenshot(Scenario scenario) {

    if(scenario.isFailed()) {
      try {
        scenario.write("Current Page URL is " + driver.getCurrentUrl());
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
      } catch (WebDriverException somePlatformsDontSupportScreenshots) {
        System.err.println(somePlatformsDontSupportScreenshots.getMessage());
      }

    }
    driver = null;
  }
}
