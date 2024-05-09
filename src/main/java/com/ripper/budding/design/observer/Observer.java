package com.ripper.budding.design.observer;

/**
 * 观察者
 * 一个目标可以有任意数目的依赖它的观察者，
 * 一旦目标的状态发生改变，所有的观察者都得到通知，
 * 作为对这个通知的响应，每个观察者都将查询目标以使其状态与目标的状态同步。
 */
public interface Observer {
    void update();
}
