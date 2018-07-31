package com.bdd.acceptancetest.Constants;

public enum Platforms {
  WIN10,
  OSX;


  public static Platforms platformForName(String operatingSystem) throws IllegalArgumentException{
    for(Platforms b: values()){
      if(b.toString().equalsIgnoreCase(operatingSystem)){
        return b;
      }
    }
    throw osNotFound(operatingSystem);
  }

  private static IllegalArgumentException osNotFound(String outcome) {
    return new IllegalArgumentException(("Invalid operating System [" + outcome + "]"));
  }
}
