package com.bdd.acceptancetest.util;

import com.bdd.acceptancetest.Config.Config;
import com.bdd.acceptancetest.Constants.Browsers;
import com.bdd.acceptancetest.Constants.Platforms;
import java.awt.Toolkit;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

  private static final String BROWSER_PROP_KEY = "browser";
  private static final String OS_PROP_KEY = "os";

  /**
   * creates the browser driver specified in the system property "browser"
   * if no property is set then a chrome browser driver is created.
   * The allowed property is chrome
   * e.g to run with chrome, pass in the option -Dbrowser=chrome at runtime
   * @return WebDriver
   */
  public static WebDriver getBrowser() {
    Browsers browser;
    Platforms os;
    WebDriver driver;


    browser = Browsers.browserForName(Config.browser);
    os = Platforms.platformForName(Config.os);
     // os = Platforms.platformForName(System.getProperty(OS_PROP_KEY));

    switch (os){
      case OSX:
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome_mac64/chromedriver");
         break;
      case WIN10:
      default:
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chrome_win64/chromedriver.exe");
        break;
    }

    switch(browser){
      case CHROME:
        default:
        driver = createChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-extensions");
        break;
     }

    addAllBrowserSetup(driver);
    return driver;
  }

  private static WebDriver createSafariDriver() {
    return new SafariDriver();
  }

  private static WebDriver createChromeDriver() {
    return new ChromeDriver();
  }

  private static void addAllBrowserSetup(WebDriver driver) {
    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    driver.manage().window().setPosition(new Point(0, 0));
    java.awt.Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension dim = new Dimension((int) screenSize.getWidth(), (int) screenSize.getHeight());
    driver.manage().window().setSize(dim);
  }


}
