package test.levkovskiy.testapplication.ui.fragments;

import android.content.Context;
import android.os.Bundle;

import test.levkovskiy.testapplication.R;

public class RecordsFragment extends BaseFragment {


    public RecordsFragment() {
        // Required empty public constructor
    }

    public static RecordsFragment newInstance(int page) {
        RecordsFragment pageFragment = new RecordsFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(arguments);
        return pageFragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int obtainContentViewLayoutId() {
        return R.layout.fragment_records;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onNetSuccess(int requestId, Object data) {

    }

    @Override
    public void onNetError(int requestId, String error) {

    }

    @Override
    public void onNetConnectionError(int requestId) {

    }
}
