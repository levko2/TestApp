package test.levkovskiy.testapplication.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import test.levkovskiy.testapplication.core.MyApplication;
import test.levkovskiy.testapplication.observer.net.NetSubscriber;

/**
 * Created by Admin on 07.11.2016.
 */

public abstract class BaseFragment extends Fragment implements NetSubscriber {
    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";
    private int pageNumber;
    MyApplication app;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(getActivity());
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);
        app = (MyApplication) getActivity().getApplication();
        app.getNetManager().subscribe(this);
    }

    @LayoutRes
    protected abstract int obtainContentViewLayoutId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(obtainContentViewLayoutId(), container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        app.getNetManager().unsubscribe(this);
    }
}
