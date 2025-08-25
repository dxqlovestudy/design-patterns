package com.xqcode.singleton;

/**
 * 枚举单例实现。Effective Java 2nd Edition (Joshua Bloch) p. 18
 *
 * <p>这种实现是线程安全的，但是添加任何其他方法和其线程安全性是开发人员需要负责的。
 */
public enum EnumIvoryTower {

  /** 单例实例，由Java枚举单例模式创建。 */
  INSTANCE;

  @Override
  public String toString() {
    return getDeclaringClass().getCanonicalName() + "@" + hashCode();
  }
}
