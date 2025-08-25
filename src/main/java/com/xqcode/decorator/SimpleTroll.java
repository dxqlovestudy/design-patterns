package com.xqcode.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 简单的小怪，直接实现{@link Troll}接口。
 * @author dengxingquan
 */
@Slf4j
public class SimpleTroll implements Troll {

  /**
   * 小怪攻击
   */
  @Override
  public void attack() {
    log.info("小怪尝试攻击你");
  }

  /**
   * 获取小怪的攻击力
   */
  @Override
  public int getAttackPower() {
    return 10;
  }

  /**
   * 小怪逃跑
   */
  @Override
  public void fleeBattle() {
    log.info("小怪惊恐地尖叫并逃跑");
  }
}
