package com.example.hp.coffeeh.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.coffeeh.R;
import com.example.hp.coffeeh.interfaces.RecyclerViewOnClickListener;


public class HotTeaHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

  public ImageView iv_hot_tea;
  public TextView tv_hot_tea_name;
  public TextView tv_hot_tea_price;
  private RecyclerViewOnClickListener recyclerViewOnClickListener;

    public void setRecyclerViewOnClickListener(RecyclerViewOnClickListener recyclerViewOnClickListener) {
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
    }

    public HotTeaHolder(View itemView) {
        super(itemView);
        iv_hot_tea = itemView.findViewById(R.id.iv_hot_tea);
        tv_hot_tea_name = itemView.findViewById(R.id.tv_hot_tea_name);
        tv_hot_tea_price = itemView.findViewById(R.id.tv_hot_tea_price);
        iv_hot_tea.setOnClickListener(this);
        tv_hot_tea_price.setOnClickListener(this);
        tv_hot_tea_name.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        recyclerViewOnClickListener.onItemClick(v,getAdapterPosition());
    }
}
