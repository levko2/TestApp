package test.levkovskiy.testapplication.net;

import android.os.Handler;
import android.os.Looper;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import test.levkovskiy.testapplication.net.response.CustomerProfileModel2;
import test.levkovskiy.testapplication.observer.net.NetSubscriber;


public class NetManager implements Net {
    Retrofit retrofit;
    private final Handler mainThreadHandler = new Handler(Looper.getMainLooper());
    private Api api;
    public static final String BASE_URL = "http://mobileqa.clipcall.it/api/";
    private final List<NetSubscriber> subscribers = new ArrayList<>();
    public static final int REQUEST_GET_INFO = 1;

    public NetManager() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        api = retrofit.create(Api.class);
    }

    @Override
    public void getInfo() {
        api.getInfo().enqueue(new Callback<CustomerProfileModel2>() {
            @Override
            public void onResponse(Call<CustomerProfileModel2> call, Response<CustomerProfileModel2> response) {
                notifySuccess(REQUEST_GET_INFO, response.body());
            }

            @Override
            public void onFailure(Call<CustomerProfileModel2> call, Throwable t) {
                notifyError(REQUEST_GET_INFO, t.getLocalizedMessage());
                t.printStackTrace();
            }
        });


    }


    @Override
    public void subscribe(NetSubscriber subscriber) {
        if (!subscribers.contains(subscriber)) {
            subscribers.add(subscriber);
        }
    }

    @Override
    public void unsubscribe(NetSubscriber subscriber) {
        if (subscribers.contains(subscriber)) {
            subscribers.remove(subscriber);
        }
    }

    @Override
    public boolean isSubscribe(NetSubscriber subscriber) {
        return false;
    }

    private void notifySuccess(final int requestId, final Object data) {
        for (NetSubscriber subscriber : subscribers) {
            subscriber.onNetSuccess(requestId, data);
        }
    }

    private void notifyError(final int requestId, final String error) {
        mainThreadHandler.post(new Runnable() {
            @Override
            public void run() {
                for (NetSubscriber subscriber : subscribers) {
                    subscriber.onNetError(requestId, error);
                }
            }
        });
    }
}
