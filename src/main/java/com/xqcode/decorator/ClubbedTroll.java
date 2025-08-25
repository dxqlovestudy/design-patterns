package com.xqcode.decorator;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 装饰器，为小怪添加一个棍子。
 */
@Slf4j
@RequiredArgsConstructor
public class ClubbedTroll implements Troll {

  private final Troll decorated;

  @Override
  public void attack() {
    log.info("小怪挥舞着棍子向你冲来");
    decorated.attack();
  }

  @Override
  public int getAttackPower() {
    return decorated.getAttackPower() + 10;
  }

  @Override
  public void fleeBattle() {
    decorated.fleeBattle();
  }
}
