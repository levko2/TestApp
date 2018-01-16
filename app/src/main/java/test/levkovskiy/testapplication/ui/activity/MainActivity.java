package test.levkovskiy.testapplication.ui.activity;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import test.levkovskiy.testapplication.R;
import test.levkovskiy.testapplication.net.response.CustomerProfileModel2;
import test.levkovskiy.testapplication.ui.fragments.AboutFragment;
import test.levkovskiy.testapplication.ui.fragments.RecordsFragment;
import test.levkovskiy.testapplication.ui.view.RoundedImageView;

public class MainActivity extends BaseActivity {
    static final String TAG = "myLogs";
    static final int PAGE_COUNT = 2;
    @Bind(R.id.pager)
    ViewPager pager;
    @Bind(R.id.icon)
    RoundedImageView icon;
    @Bind(R.id.tv_name)
    TextView name;
    PagerAdapter pagerAdapter;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Thread(new Runnable() {
            @Override
            public void run() {
                app.getNetManager().getInfo();
            }
        }).start();

        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        // addTabs();
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                Log.d(TAG, "onPageSelected, position = " + position);

            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    ActionBar.TabListener tabListener = new ActionBar.TabListener() {
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            // show the given tab
        }

        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            // hide the given tab
        }

        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
            // probably ignore this event
        }
    };

    private void addTab(String text) {
        // Specify that tabs should be displayed in the action bar.
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create a tab listener that is called when the user changes tabs.

        // Add 3 tabs, specifying the tab's text and TabListener

        actionBar.addTab(
                actionBar.newTab()
                        .setText(text)
                        .setTabListener(tabListener));

    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return AboutFragment.newInstance(position);
                case 1:
                    return RecordsFragment.newInstance(position);
            }
            return null;

        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

    }

    @Override
    protected int obtainContentViewLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void onNetSuccess(int requestId, Object data) {
        CustomerProfileModel2 user = (CustomerProfileModel2) data;
        if (user != null) {
            Picasso.with(getApplicationContext()).load(user.getImageUrl()).into(icon);
            name.setText(user.getName());
        }

    }

    @Override
    public void onNetError(int requestId, String error) {

    }

    @Override
    public void onNetConnectionError(int requestId) {

    }
}
