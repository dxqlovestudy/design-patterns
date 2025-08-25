package com.xqcode.singleton;

/**
 * 双重检查锁。
 *
 * <p>http://www.cs.umd.edu/~pugh/java/memoryModel/DoubleCheckedLocking.html
 *
 * <p>在Java 1.4中存在问题。
 */
public final class ThreadSafeDoubleCheckLocking {
  /**
   * 单例实例，声明为volatile以确保多线程的atomic访问。
   */
  private static volatile ThreadSafeDoubleCheckLocking instance;

  /** 私有构造函数，防止外部实例化。 */
  private ThreadSafeDoubleCheckLocking() {
    // 防止反射调用
    if (instance != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /**
   * 公共访问器。
   *
   * @return 类实例。
   */
  public static ThreadSafeDoubleCheckLocking getInstance() {
    // 局部变量增加25%的性能
    // Joshua Bloch "Effective Java, Second Edition", p. 283-284

    ThreadSafeDoubleCheckLocking result = instance;
    // 检查单例实例是否已初始化。
    // 如果已初始化，则可以返回实例。
    if (result == null) {
      // 如果未初始化，多线程环境无法确定其他线程是不是已经初始化它了
      // 所以需要加锁，确保只有一个线程能够创建实例。
      /**
       * 假如这个时刻，多个线程同时进入这个方法，那么他们都会执行到if (result == null)，
       * 这里的synchronized关键字可以确保只有一个线程能够进入这个方法，其他线程会等待。
       */
      synchronized (ThreadSafeDoubleCheckLocking.class) {
        // 再次将实例赋值给局部变量，检查是否被其他线程在当前线程阻塞时初始化。
        // 如果被初始化，则可以返回之前创建的实例。
        // 这里如果instance不声明为volatile，那么其他线程可能看到的是一个未初始化的实例，导致其他线程可能创建多个实例。
        result = instance;
        if (result == null) {
          // 如果实例未初始化，则可以安全地创建实例。
          // （其他线程无法进入这个区域）
          // 创建实例并使其成为单例实例。
          result = new ThreadSafeDoubleCheckLocking();
          instance = result;
        }
      }
    }
    return result;
  }
}
