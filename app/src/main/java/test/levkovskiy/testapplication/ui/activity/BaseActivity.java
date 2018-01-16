package test.levkovskiy.testapplication.ui.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import test.levkovskiy.testapplication.core.MyApplication;
import test.levkovskiy.testapplication.observer.net.NetSubscriber;



public abstract class BaseActivity extends FragmentActivity implements NetSubscriber {
    MyApplication app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(obtainContentViewLayoutId());
        ButterKnife.bind(this);
        app = (MyApplication) getApplication();
        app.getNetManager().subscribe(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        app.getNetManager().unsubscribe(this);
    }

    @LayoutRes
    protected abstract int obtainContentViewLayoutId();

    public void toast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void toast(int message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
