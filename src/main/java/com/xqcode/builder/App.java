package com.xqcode.builder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

  /**
   * Program entry point.
   *
   * @param args command line args
   */
  public static void main(String[] args) {

    Hero test = Hero.builder().weapon(Weapon.SWORD).armor(Armor.CLOTHES).build();
    System.out.println(test.toString());

  }
}
