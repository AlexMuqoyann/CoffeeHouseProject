package com.example.hp.coffeeh.viewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.coffeeh.R;
import com.example.hp.coffeeh.interfaces.RecyclerViewOnClickListener;

/**
 * Created by HP on 13.11.2017.
 */

public class HotCoffeeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView iv_hot_cf;
    public TextView tv_hot_cf;
    public TextView tv_hot_cf_price;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener recyclerViewOnClickListener) {
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
    }

    public HotCoffeeHolder(View itemView) {
        super(itemView);
        iv_hot_cf = itemView.findViewById(R.id.iv_hot_cf);
        tv_hot_cf = itemView.findViewById(R.id.tv_hot_cf);
        tv_hot_cf_price = itemView.findViewById(R.id.tv_hot_cf_price);
        iv_hot_cf.setOnClickListener(this);
        tv_hot_cf.setOnClickListener(this);
        tv_hot_cf_price.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        recyclerViewOnClickListener.onItemClick(v,getAdapterPosition());
    }
}
