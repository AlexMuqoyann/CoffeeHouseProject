package com.example.hp.coffeeh.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.coffeeh.R;
import com.example.hp.coffeeh.interfaces.RecyclerViewOnClickListener;
import com.example.hp.coffeeh.models.University;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class UniversityAdapter extends RecyclerView.Adapter<UniversityAdapter.ViewHolder> {

       private Context context;
       private LayoutInflater inflater;
       private List<University> univerSity = Collections.emptyList();
       private RecyclerViewOnClickListener recyclerViewOnClickListener;


       public UniversityAdapter(Context context, ArrayList<University>univerSity,RecyclerViewOnClickListener recyclerViewOnClickListener){
           inflater = LayoutInflater.from(context);
           this.context = context;
           this.univerSity = univerSity;
           this.recyclerViewOnClickListener = recyclerViewOnClickListener;

       }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.university_row,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
           University currentUniversity = univerSity.get(position);
           holder.tv_work_time.setText(currentUniversity.getWorkTime());
           holder.tv_company_name.setText(currentUniversity.getName());
           holder.iv_university.setImageResource(currentUniversity.getImage());
    }

    @Override
    public int getItemCount() {
        return univerSity.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
           private ImageView iv_university;
           private TextView tv_company_name;
           private TextView tv_work_time;




        public ViewHolder(View itemView) {
            super(itemView);
            iv_university = itemView.findViewById(R.id.iv_university);
            tv_company_name = itemView.findViewById(R.id.tv_company_name);
            tv_work_time = itemView.findViewById(R.id.tv_work_time);
            iv_university.setOnClickListener(this);
            tv_company_name.setOnClickListener(this);
            tv_work_time.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            recyclerViewOnClickListener.onItemClick(v,getAdapterPosition());
        }
    }
}
