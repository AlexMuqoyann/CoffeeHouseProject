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

public class SmoothiesHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public ImageView iv_smoothies;
    public TextView tv_smoothie_text;
    public TextView tv_smoothie_price;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener recyclerViewOnClickListener) {
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
    }

    public SmoothiesHolder(View itemView) {
        super(itemView);
        iv_smoothies = itemView.findViewById(R.id.iv_smoothie);
        tv_smoothie_price = itemView.findViewById(R.id.tv_smoothie_price);
        tv_smoothie_text = itemView.findViewById(R.id.tv_smoothie_text);
        iv_smoothies.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        recyclerViewOnClickListener.onItemClick(v,getAdapterPosition());
    }
}
