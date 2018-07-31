package com.bdd.acceptancetest.datamodels;

import java.util.ArrayList;

public class List
{
  private int dt;
  private Main main;
  private ArrayList<Weather> weather;
  private Clouds clouds;
  private Wind wind;
  private Rain rain;
  private Sys2 sys;
  private String dt_txt;

  public int getDt() { return this.dt; }

  public void setDt(int dt) { this.dt = dt; }



  public Main getMain() { return this.main; }

  public void setMain(Main main) { this.main = main; }



  public ArrayList<Weather> getWeather() { return this.weather; }

  public void setWeather(ArrayList<Weather> weather) { this.weather = weather; }



  public Clouds getClouds() { return this.clouds; }

  public void setClouds(Clouds clouds) { this.clouds = clouds; }


  public Wind getWind() { return this.wind; }

  public void setWind(Wind wind) { this.wind = wind; }


  public Rain getRain() { return this.rain; }

  public void setRain(Rain rain) { this.rain = rain; }



  public Sys2 getSys() { return this.sys; }

  public void setSys(Sys2 sys) { this.sys = sys; }


  public String getDtTxt() { return this.dt_txt; }

  public void setDtTxt(String dt_txt) { this.dt_txt = dt_txt; }
}
