package com.xqcode.singleton;

import lombok.extern.slf4j.Slf4j;

/**
 * 单例模式确保一个类只有一个实例，并提供全局访问。
 *
 * <p>单例模式有以下风险：
 * 1. 在分布式环境中，单例模式可能导致调试困难，因为如果只在一个类加载器中调试，问题可能不会出现。
 * 2. 单例模式可能导致问题在实现后一段时间内才显现，因为它们可能一开始是同步的，但随着时间的推移，可能变成异步的，因此可能不清楚为什么会出现某些行为变化。
 *
 * <p>单例模式有多种实现方式。第一种是饿汉式，即在类加载时就初始化实例。这种方式是线程安全的，但可能会浪费内存。{@link IvoryTower}
 * 第二种是懒汉式，即在需要时才初始化实例。这种方式不是线程安全的，但可以节省内存。
 * 第三种是枚举，即使用枚举来实现单例模式。这种方式是线程安全的，但可能会浪费内存。{@link EnumIvoryTower}.
 * 第四种是双重检查锁，即在需要时才初始化实例。这种方式是线程安全的，但可能会浪费内存。{@link ThreadSafeDoubleCheckLocking}
 * 第五种是初始化即持有，即在类加载时就初始化实例。这种方式是线程安全的，但可能会浪费内存。{@link InitializingOnDemandHolderIdiom}
 */
@Slf4j
public class App {
  public static void main(String[] args) {
    // 饿汉式
    IvoryTower ivoryTower1 = IvoryTower.getInstance();
    IvoryTower ivoryTower2 = IvoryTower.getInstance();
    log.info("ivoryTower1={}", ivoryTower1);
    log.info("ivoryTower2={}", ivoryTower2);

    // 懒汉式
    ThreadSafeLazyLoadedIvoryTower threadSafeIvoryTower1 = ThreadSafeLazyLoadedIvoryTower.getInstance();
    ThreadSafeLazyLoadedIvoryTower threadSafeIvoryTower2 = ThreadSafeLazyLoadedIvoryTower.getInstance();
    log.info("threadSafeIvoryTower1={}", threadSafeIvoryTower1);
    log.info("threadSafeIvoryTower2={}", threadSafeIvoryTower2);

    // 枚举类创建单例，比较少见
    EnumIvoryTower enumIvoryTower1 = EnumIvoryTower.INSTANCE;
    EnumIvoryTower enumIvoryTower2 = EnumIvoryTower.INSTANCE;
    log.info("enumIvoryTower1={}", enumIvoryTower1);
    log.info("enumIvoryTower2={}", enumIvoryTower2);

    // 双重检查锁
    ThreadSafeDoubleCheckLocking dcl1 = ThreadSafeDoubleCheckLocking.getInstance();
    log.info(dcl1.toString());
    ThreadSafeDoubleCheckLocking dcl2 = ThreadSafeDoubleCheckLocking.getInstance();
    log.info(dcl2.toString());

    // 初始化即持有，和下面的实例方式一样
    InitializingOnDemandHolderIdiom demandHolderIdiom = InitializingOnDemandHolderIdiom.getInstance();
    log.info(demandHolderIdiom.toString());
    InitializingOnDemandHolderIdiom demandHolderIdiom2 = InitializingOnDemandHolderIdiom.getInstance();
    log.info(demandHolderIdiom2.toString());

    // 使用Bill Pugh的实现方式初始化单例
    BillPughImplementation billPughSingleton = BillPughImplementation.getInstance();
    log.info(billPughSingleton.toString());
    BillPughImplementation billPughSingleton2 = BillPughImplementation.getInstance();
    log.info(billPughSingleton2.toString());
  }
}
