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

public class IceCoffeeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView iv_ice_cf_image;
    public TextView tv_ice_cf_text;
    public TextView  tv_ice_cf_price;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;



    public IceCoffeeHolder(View itemView) {
        super(itemView);
        iv_ice_cf_image = itemView.findViewById(R.id.iv_ice_cf_image);
        tv_ice_cf_text = itemView.findViewById(R.id.tv_ice_cf_text);
        tv_ice_cf_price = itemView.findViewById(R.id.tv_ice_cf_price);
        tv_ice_cf_price.setOnClickListener(this);
        iv_ice_cf_image.setOnClickListener(this);
        tv_ice_cf_text.setOnClickListener(this);
    }
    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener recyclerViewOnClickListener) {
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
    }

    @Override
    public void onClick(View v) {
        recyclerViewOnClickListener.onItemClick(v,getAdapterPosition());
    }
}
