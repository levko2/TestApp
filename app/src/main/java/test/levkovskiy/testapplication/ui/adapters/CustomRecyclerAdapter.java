package test.levkovskiy.testapplication.ui.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import test.levkovskiy.testapplication.R;
import test.levkovskiy.testapplication.net.response.CustomerProfileModel2;

/**
 * Created by Admin on 07.11.2016.
 */

public class CustomRecyclerAdapter  extends BaseRecyclerAdapter<CustomRecyclerAdapter.MyViewHolder, CustomerProfileModel2> {

    public CustomRecyclerAdapter(Context context, @Nullable OnItemClickListener itemClickListener) {
        super(context, itemClickListener);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(inflateView(R.layout.recycler_item, parent));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }


    public static final class MyViewHolder extends RecyclerView.ViewHolder {


        public MyViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
