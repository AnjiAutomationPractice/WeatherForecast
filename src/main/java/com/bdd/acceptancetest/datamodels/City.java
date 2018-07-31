package com.bdd.acceptancetest.datamodels;


public class City
{
  private int id;
  private String name;
  private Coord coord;
  private String country;
  private int population;
  private Sys sys;

  public int getId() { return this.id; }

  public void setId(int id) { this.id = id; }

  public String getName() { return this.name; }

  public void setName(String name) { this.name = name; }

  public Coord getCoord() { return this.coord; }

  public void setCoord(Coord coord) { this.coord = coord; }

  public String getCountry() { return this.country; }

  public void setCountry(String country) { this.country = country; }

  public int getPopulation() { return this.population; }

  public void setPopulation(int population) { this.population = population; }

  public Sys getSys() { return this.sys; }

  public void setSys(Sys sys) { this.sys = sys; }
}
