package com.xqcode.decorator;

import lombok.extern.slf4j.Slf4j;

/**
 * 装饰器模式是一种更灵活的替代子类化的方式。装饰器类实现与目标相同的接口，并使用组合来“装饰”对目标的调用。
 * 使用装饰器模式可以在运行时改变类的行为。
 * <p>
 * 在这个例子中，我们展示了简单的小怪在战斗中如何攻击和逃跑。然后我们装饰小怪{@link SimpleTroll}，
 * 使其拥有巨大的棍子{@link ClubbedTroll}，并再次攻击。你可以看到装饰后的行为变化。
 */
@Slf4j
public class App {

  /**
   * 程序入口
   */
  public static void main(String[] args) {

    // 简单的小怪
    log.info("一个简单的小怪出现了");
    Troll troll = new SimpleTroll();
    troll.attack();
    troll.fleeBattle();
    log.info("小怪的攻击力: {}", troll.getAttackPower());

    // 通过装饰器改变小怪的行为
    log.info("一个拿着巨大棍子的小怪出现了");
    Troll clubbedTroll = new ClubbedTroll(troll);
    clubbedTroll.attack();
    clubbedTroll.fleeBattle();
    log.info("小怪的攻击力: {}", clubbedTroll.getAttackPower());
  }
}
