package test.levkovskiy.testapplication.net;


import test.levkovskiy.testapplication.observer.Publisher;
import test.levkovskiy.testapplication.observer.net.NetSubscriber;

public interface Net extends Publisher<NetSubscriber> {
    void getInfo();

}
