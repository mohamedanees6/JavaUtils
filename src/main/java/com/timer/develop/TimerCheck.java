package com.timer.develop;

public class TimerCheck {
  public static void main(String[] args) {
    String a = "Anees";
    change(a);
    System.out.println(a);
  }

  private static void change(String a) {
    a += "Bheem";
    System.out.println("A in method" + a);
  }
}
