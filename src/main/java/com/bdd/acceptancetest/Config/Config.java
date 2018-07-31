package com.bdd.acceptancetest.Config;

public interface Config {

  String baseUrl        = System.getProperty("baseUrl", "https://weather-acceptance.herokuapp.com");
  String browser        = System.getProperty("browser", "chrome");
  String os             = System.getProperty("os", "win10");

}
