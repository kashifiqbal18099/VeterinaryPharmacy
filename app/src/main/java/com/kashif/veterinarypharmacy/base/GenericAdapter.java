package com.kashif.veterinarypharmacy.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericAdapter<T, D> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<T> mArrayList;

    public abstract int getLayoutResId();

    public abstract void onBindData(T model, int position, D dataBinding);

    public abstract void onItemClick(T model, int position,D dataBinding);

    public GenericAdapter(Context context, List<T> arrayList) {
        this.mContext = context;
        this.mArrayList = arrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewDataBinding dataBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayoutResId(), parent, false);
        RecyclerView.ViewHolder holder = new ItemViewHolder(dataBinding);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        onBindData(mArrayList.get(position), position, ((ItemViewHolder) holder).mDataBinding);

        ((ViewDataBinding) ((ItemViewHolder) holder).mDataBinding).getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClick(mArrayList.get(position), position,((ItemViewHolder) holder).mDataBinding);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mArrayList.size();
    }

    public void addItems(ArrayList<T> arrayList) {
        mArrayList = arrayList;
        this.notifyDataSetChanged();
    }

    public T getItem(int position) {
        return mArrayList.get(position);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        protected D mDataBinding;
        public ItemViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            mDataBinding = (D) binding;
        }
    }
}