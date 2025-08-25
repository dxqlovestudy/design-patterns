package com.xqcode.singleton;

/** 单例类。静态实例保证线程安全。 */
public final class IvoryTower {

  /** 私有构造函数，防止外部实例化。 */
  private IvoryTower() {
    // 防止反射调用
    if (INSTANCE != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /** 
   * 单例实例变量 - 饿汉式实现
   * <p>
   * static关键字的作用：
   * 1. 类级别变量：使INSTANCE属于类本身，而不是某个具体的对象实例
   * 2. 类加载时初始化：在类第一次被加载时就创建实例，确保全局唯一
   * 3. 线程安全：Java类加载机制本身是线程安全的，无需额外同步
   * 4. 无需实例化访问：1.可以通过类名直接访问，2.支持getInstance()静态方法
   * <p>
   * final关键字的作用：
   * 1. 不可变引用：一旦赋值后不能再被修改，防止INSTANCE被重新赋值、确保实例的唯一性，避免意外覆盖，单例模式要求实例唯一且不可变
   * 2. 编译优化：编译器会对常量进行优化，提高性能
   * 3. 内存可见性：配合static确保多线程环境下的可见性
   *    - Java内存模型中，每个线程都有自己的工作内存（CPU缓存）
   *    - static final变量在类加载时初始化，所有线程共享同一个主内存中的值
   *    - final保证变量不会被修改，避免了缓存一致性问题
   *    - 类加载过程本身具有同步语义，确保所有线程看到的是同一个初始化完成的实例
   */
  private static final IvoryTower INSTANCE = new IvoryTower();

  /**
   * 被用户调用以获取类实例。
   *
   * @return 单例实例。
   */
  public static IvoryTower getInstance() {
    return INSTANCE;
  }
}
