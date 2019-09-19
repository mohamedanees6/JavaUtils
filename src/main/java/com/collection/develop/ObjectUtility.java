package com.collection.develop;

import java.util.HashMap;

public class ObjectUtility {

  public static void main(String[] args) {
    Object o = castToType(10,new HashMap<Integer,Integer>());
    o.getClass();   
    
  }
  
  private static <V,T> T castToType(V value, T type){
    return (T) value;
  }

}
