package com.xqcode.decorator;

/**
 * 小怪接口
 */
public interface Troll {

  /**
   * 小怪攻击
   */
  void attack();

  /**
   * 获取小怪的攻击力
   */
  int getAttackPower();

  /**
   * 小怪逃跑
   */
  void fleeBattle();
}
