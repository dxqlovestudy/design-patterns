package com.xqcode.singleton;

/**
 * Bill Pugh单例实现。
 *
 * <p>这种单例模式实现方式利用了Java内存模型的类初始化保证。
 * 每个类只被初始化一次，当它第一次被使用时。
 * 如果类还没有被使用，它不会被加载到内存，也不会为静态实例分配内存。
 * 这使得单例实例是懒加载的，并且是线程安全的。
 */
public final class BillPughImplementation {

  /** 私有构造函数，防止外部实例化。 */
  private BillPughImplementation() {
    // 防止反射调用
    if (InstanceHolder.instance != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /**
   * InstanceHolder是一个静态内部类，它持有单例实例。
   * 它不会在getInstance()方法被调用时加载到内存。
   */
  private static class InstanceHolder {
    /** 单例实例。 */
    private static BillPughImplementation instance = new BillPughImplementation();
  }

  /**
   * 公共访问器。
   *
   * <p>当这个方法被调用时，InstanceHolder被加载到内存并创建单例实例。
   * 这个方法提供了一个全局访问点。
   *
   * @return 类实例。
   */
  // 全局访问点
  public static BillPughImplementation getInstance() {
    return InstanceHolder.instance;
  }
}
