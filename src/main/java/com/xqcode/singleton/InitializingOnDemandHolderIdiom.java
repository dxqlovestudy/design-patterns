package com.xqcode.singleton;

/**
 * 这种初始化即持有实现方式是一个安全的懒加载单例对象的实现方式。
 *
 * 这种实现方式是懒加载的，并且可以在所有已知的Java版本中工作。
 * 它利用了Java语言关于类初始化的保证，因此可以在所有符合Java规范的编译器和虚拟机中正确工作。
 *
 * 这种实现方式是线程安全的，不需要特殊的语言构造（如volatile或synchronized）。
 */
public final class InitializingOnDemandHolderIdiom {

  /** 私有构造函数，防止外部实例化。 */
  private InitializingOnDemandHolderIdiom() {
    // 防止反射调用
    if (HelperHolder.INSTANCE != null) {
      throw new IllegalStateException("Already initialized.");
    }
  }

  /**
   * 单例实例。
   *
   * @return 单例实例。
   */
  public static InitializingOnDemandHolderIdiom getInstance() {
    return HelperHolder.INSTANCE;
  }

  /** 提供懒加载的单例实例。 */
  private static class HelperHolder {

    /** 单例实例。 */
    private static final InitializingOnDemandHolderIdiom INSTANCE =
        new InitializingOnDemandHolderIdiom();
  }
}
