package com.xqcode.singleton;

/**
 * 线程安全的单例类。实例是懒加载的，因此需要同步机制。
 */
public final class ThreadSafeLazyLoadedIvoryTower {

  /**
   * 单例实例，声明为volatile以确保多线程的atomic访问。
   */
  private static volatile ThreadSafeLazyLoadedIvoryTower instance;

  /** 私有构造函数，防止外部实例化。 */
  private ThreadSafeLazyLoadedIvoryTower() {
    // 防止反射调用
    if (instance != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /**
   * 实例在第一次调用方法时才创建。
   * 使用synchronized关键字确保在多线程环境下，只有一个线程能够创建实例。
   *
   * @return 类实例。
   */
  public static synchronized ThreadSafeLazyLoadedIvoryTower getInstance() {
    // 如果实例为空，则创建实例，第一次调用时，instance为空，则创建实例，之后调用时，instance不为空，则直接返回实例。
    if (instance == null) {
      instance = new ThreadSafeLazyLoadedIvoryTower();
    }
    return instance;
  }
}
