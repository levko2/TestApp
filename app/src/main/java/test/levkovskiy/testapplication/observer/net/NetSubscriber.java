package test.levkovskiy.testapplication.observer.net;


import test.levkovskiy.testapplication.observer.Subscriber;

public interface NetSubscriber extends Subscriber {
    void onNetSuccess(int requestId, Object data);

    void onNetError(int requestId, String error);

    void onNetConnectionError(int requestId);
}
