package test.levkovskiy.testapplication.ui.adapters;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07.11.2016.
 */

public abstract class BaseRecyclerAdapter <A extends RecyclerView.ViewHolder, BaseResponse>
        extends RecyclerView.Adapter<A> {
    protected final List<BaseResponse> items = new ArrayList<>();

    private final OnItemClickListener itemClickListener;
    private final Context context;

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }

    public BaseRecyclerAdapter(Context context,
                                   @Nullable OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void add(@Nullable List<BaseResponse> newItems) {
        if (newItems == null) return;
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    public void addWithClear(List<BaseResponse> newItems) {
        items.clear();
        add(newItems);
    }

    public void add(BaseResponse newItem) {
        items.add(newItem);
    }

    public BaseResponse getItem(int position) {
        return items.get(position);
    }

    protected View inflateView(@LayoutRes int layoutRes, ViewGroup container) {
        return LayoutInflater.from(getContext()).inflate(layoutRes, container, false);
    }

    protected Context getContext() {
        return context;
    }

    protected final OnItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public interface OnCheckChangeListener {
        void onCheckChanged(CompoundButton buttonView, boolean isChecked, int position);
    }
}