package com.bdd.acceptancetest.pageobjects;


import com.bdd.acceptancetest.util.BrowserDriver;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;
import static com.bdd.acceptancetest.util.BrowserDriver.*;



public class Homepage extends BasePage {

  private static final Logger LOGGER = Logger.getLogger(Homepage.class.getName());

  By citylocator = By.id("city");
  By totalDays = By.cssSelector("#root > div > div > div.summary > span:nth-child(1) > span.name");
  By dayOneSelector = By.cssSelector("#root > div > div:nth-child(2) > div.summary > span:nth-child(1) > span.name");

  String dayPartOne = "#root > div > div:nth-child(";
  String dayPartTwo = ") > div.summary > span:nth-child(1)";

  String hourPartOne = "#root > div > div:nth-child(";
  String hourPartTwo =  ") > div.details > div:nth-child(1) > span:nth-child(1) > span";


  String hourlyForecastPartOne = "#root > div > div:nth-child(";
  String hourForecastPartOne = "#root > div > div:nth-child(";
  String hourlyForecastPartTwo = ") > div.details > div > span:nth-child(1) > span";

  String hourForecastPartTwo = ") > div.details > div:nth-child(";
  String hourForecastPartThree = ") > span:nth-child(1) > span";

  public Homepage(WebDriver driver){
    super(driver);
    visit(baseUrl + "/");

    waitForTextToAppear(driver,"Five Day Weather Forecast",find(By.cssSelector("h1")));

  }

  public void enterCity(String city){
    try {
      clear(citylocator);
      type(city, citylocator);
    }
    catch (RuntimeException e) {
      takeScreenshot(e, "searchError");
    }
  }

  public int gettotalDayForecast(){
    return findElements(totalDays).size();
  }

  public String getDayOne(){
    return waitUntilElemenetLocated(dayOneSelector).getText();
  }


  public void choseADay(int day) {
    int daySelector = day + 1;
    clickOnElement(By.cssSelector(dayPartOne + daySelector + dayPartTwo));
    waitForElement(find(By.cssSelector(hourPartOne + daySelector + hourPartTwo)));


  }

  public boolean getHourlyForecastTimes(int day){
    boolean result = false;
    int daySelector = day + 1;
    int totalHourlyForecasts = findElements(By.cssSelector(hourlyForecastPartOne + daySelector + hourlyForecastPartTwo)).size();
    for(int i=1; i < totalHourlyForecasts-1; i ++ ){

      int firstHour = Integer.parseInt(find(By.cssSelector(hourForecastPartOne + daySelector + hourForecastPartTwo + i  + hourForecastPartThree )).getText());
      int secondHour = Integer.parseInt(find(By.cssSelector(hourForecastPartOne + daySelector + hourForecastPartTwo + (i+1) + hourForecastPartThree )).getText());

      if (secondHour-firstHour != 300){
        break;
      } else {
        result = true;
      }

    }
    return result;
  }

  public boolean isHourlyForecastHidden(int day) {
    boolean result = false;
    int daySelector = day + 1;
    List<WebElement> forecastHours = findElements(By.cssSelector(hourlyForecastPartOne + daySelector + hourlyForecastPartTwo));
    int totalHoursCount = forecastHours.size();
    for (int i = 0; i < totalHoursCount; i++) {
      int x = forecastHours.get(i).getLocation().getX();
      if (x != 8) {
        break;
      } else {
        result = true;
      }
    }
    return result;
  }

// TO-DO Improvement
// Ensure CSS Selectors moved to Page Object locators section


  public int getMaxTemperature(int dayTemp, int hourTemp) {
    By maxTempLocator = By.xpath("//*[@id='root']/div/div[" + dayTemp + "]/div[2]/div[" + hourTemp + "]/span[3]/span[1]");
    String maxTempText = getText(maxTempLocator);
    int maxTemp = Integer.parseInt(maxTempText.substring(0,maxTempText.length()-1));
    Math.round(maxTemp);
    return maxTemp;
  }

  public int getMinTemperature(int dayTemp, int hourTemp){
    By minTempLocator = By.xpath("//*[@id='root']/div/div[" + dayTemp + "]/div[2]/div[" + hourTemp + "]/span[3]/span[2]");
    String minTempText = getText(minTempLocator);
    int minTemp = Integer.parseInt(minTempText.substring(0,minTempText.length()-1));
    Math.round(minTemp);
    return minTemp;
  }

  public int getAggregateRainfall(int day){
    int daySelector = day+1;
    By aggregateRainFallLocator = By.cssSelector("div:nth-child("+daySelector+") div.summary span.cell:nth-child(5) > span.rainfall");
    String aggregateRainfallText = getText(aggregateRainFallLocator);
    int aggregateRainfall = Integer.parseInt(aggregateRainfallText.substring(0,aggregateRainfallText.length()-2));
    return aggregateRainfall;
  }

  public int getWindSpeed(int day){
    int daySelector = day+1;
    By windSpeedLocator = By.cssSelector("div:nth-child("+daySelector+") div.summary span.cell:nth-child(4) > span.speed");
    String windSpeedText = getText(windSpeedLocator);
    int windSpeed = Integer.parseInt(windSpeedText.substring(0, windSpeedText.length()-3));
    return windSpeed;
  }

  public int getWindDirection(int day){
    By windDirectionLocator = By.xpath("//body/div[@id='root']/div[@data-radium='true']/div["+day+"]/div[1]/span[4]/span[2]/*[1]");
    String windDirectionText = getText(windDirectionLocator);
    int windDirection = Integer.parseInt(windDirectionText);
    return windDirection;
  }

  public int getPressure(int day){
    int daySelector = day+1;
    By pressureLocator = By.cssSelector("div:nth-child("+ daySelector+") div.summary span.cell:nth-child(5) > span.rmq-5ea3c959.pressure");
    String pressureText = getText(pressureLocator);
    int pressure = Integer.parseInt(pressureText.substring(0,pressureText.length()-2));
    return pressure;
  }
}
