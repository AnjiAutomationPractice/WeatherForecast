package com.bdd.acceptancetest.datamodels;


import java.util.ArrayList;

public class RootObject
{
  private City city;
  private String cod;
  private double message;
  private int cnt;
  private ArrayList<List> list;

  public City getCity() { return this.city; }

  public void setCity(City city) { this.city = city; }



  public String getCod() { return this.cod; }

  public void setCod(String cod) { this.cod = cod; }



  public double getMessage() { return this.message; }

  public void setMessage(double message) { this.message = message; }



  public int getCnt() { return this.cnt; }

  public void setCnt(int cnt) { this.cnt = cnt; }



  public ArrayList<List> getList() { return this.list; }

  public void setList(ArrayList<List> list) { this.list = list; }
}
