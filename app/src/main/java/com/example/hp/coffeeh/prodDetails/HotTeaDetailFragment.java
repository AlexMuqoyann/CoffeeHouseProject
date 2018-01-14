package com.example.hp.coffeeh.prodDetails;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.hp.coffeeh.R;
import com.example.hp.coffeeh.models.HotTea;
import com.example.hp.coffeeh.models.TeaDetail;
import com.example.hp.coffeeh.models.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.Date;

/**
 * A simple {@link Fragment} subclass.
 */
public class HotTeaDetailFragment extends Fragment {
    private ImageView iv_hot_tea_detail;
    private TextView tv_hot_tea_detail_name,tv_hot_tea_detail_price;
    private FloatingActionButton fl_hot_tea_detail;
    private ElegantNumberButton hot_tea_detail_elButton;
    private DatabaseReference hotTea;
    private EditText hot_tea_sugar;
    private RadioGroup hot_tea_order;
    private String Orderin = "";
    private String count;
    private String Type = "Hot";
    private String hotTeaId = "";
    private DatabaseReference Slavonic;
    private DatabaseReference Aleq_Manukyan;
    private DatabaseReference Bryusov;
    private DatabaseReference Asue;
    private DatabaseReference Polytech;






    public HotTeaDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_hot_tea_detail, container, false);
        hotTea = FirebaseDatabase.getInstance().getReference("Hottea");
        Slavonic = FirebaseDatabase.getInstance().getReference("Slavonic");
        Aleq_Manukyan = FirebaseDatabase.getInstance().getReference("AleqManukyan");
        Bryusov = FirebaseDatabase.getInstance().getReference("Bryusov");
        Asue = FirebaseDatabase.getInstance().getReference("Asue");
        Polytech = FirebaseDatabase.getInstance().getReference("Polytech");
        iv_hot_tea_detail = view.findViewById(R.id.iv_hot_tea_detail);
        tv_hot_tea_detail_name = view.findViewById(R.id.tv_hot_tea_detail_name);
        tv_hot_tea_detail_price = view.findViewById(R.id.tv_hot_tea_detail_price);
        fl_hot_tea_detail = view.findViewById(R.id.fl_hot_tea_detail);
        hot_tea_sugar = view.findViewById(R.id.hot_tea_sugar);
        hot_tea_order = view.findViewById(R.id.hot_tea_order);
        hot_tea_detail_elButton = view.findViewById(R.id.hot_tea_detail_elButton);
        Bundle bundle = getArguments();
        if(bundle!=null){
            hotTeaId = bundle.getString("hotTeaId");
            if(!hotTeaId.isEmpty()){
                getDetailTea(hotTeaId);
            }
        }



        fl_hot_tea_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder mBuilder = new AlertDialog.Builder(getActivity());
                LayoutInflater layoutInflater;
                layoutInflater = LayoutInflater.from(getActivity());
                View myView = layoutInflater.inflate(R.layout.custom_dialog,null);
                final CheckBox Cb_slavonic = myView.findViewById(R.id.Cb_slavonic);
                final CheckBox Cb_aleq_manukyan = myView.findViewById(R.id.Cb_aleq_manukyan);
                final CheckBox Cb_bryusov = myView.findViewById(R.id.Cb_bryusov);
                final CheckBox Cb_asue = myView.findViewById(R.id.Cb_asue);
                final CheckBox Cb_polytech = myView.findViewById(R.id.Cb_polytech);
                mBuilder.setView(myView);
                mBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (Cb_slavonic.isChecked()){
                            String name = tv_hot_tea_detail_name.getText().toString();
                            String price = tv_hot_tea_detail_price.getText().toString();
                            String sugar = hot_tea_sugar.getText().toString();
                            String id = Slavonic.push().getKey();
                            TeaDetail detail = new TeaDetail(name,price,count,sugar,Orderin,Type,id,new Date(System.currentTimeMillis()).toString());
                            Slavonic.child(id).setValue(detail);

                        }
                       else if (Cb_aleq_manukyan.isChecked()){
                            String name = tv_hot_tea_detail_name.getText().toString();
                            String price = tv_hot_tea_detail_price.getText().toString();
                            String sugar = hot_tea_sugar.getText().toString();
                            String id = Aleq_Manukyan.push().getKey();
                            TeaDetail detail = new TeaDetail(name,price,count,sugar,Orderin,Type,id,new Date(System.currentTimeMillis()).toString());
                            Aleq_Manukyan.child(id).setValue(detail);

                        }
                        else if (Cb_bryusov.isChecked()){
                            String name = tv_hot_tea_detail_name.getText().toString();
                            String price = tv_hot_tea_detail_price.getText().toString();
                            String sugar = hot_tea_sugar.getText().toString();
                            String id = Bryusov.push().getKey();
                            TeaDetail detail = new TeaDetail(name,price,count,sugar,Orderin,Type,id,new Date(System.currentTimeMillis()).toString());
                            Bryusov.child(id).setValue(detail);

                        }
                        else if (Cb_asue.isChecked()){
                            String name = tv_hot_tea_detail_name.getText().toString();
                            String price = tv_hot_tea_detail_price.getText().toString();
                            String sugar = hot_tea_sugar.getText().toString();
                            String id = Asue.push().getKey();
                            TeaDetail detail = new TeaDetail(name,price,count,sugar,Orderin,Type,id,new Date(System.currentTimeMillis()).toString());
                            Asue.child(id).setValue(detail);

                        }
                        else if (Cb_polytech.isChecked()){
                            String name = tv_hot_tea_detail_name.getText().toString();
                            String price = tv_hot_tea_detail_price.getText().toString();
                            String sugar = hot_tea_sugar.getText().toString();
                            String id = Polytech.push().getKey();
                            TeaDetail detail = new TeaDetail(name,price,count,sugar,Orderin,Type,id,new Date(System.currentTimeMillis()).toString());
                            Polytech.child(id).setValue(detail);

                        }
                    }
                });
                mBuilder.create();
                mBuilder.show();
            }
        });
        hot_tea_detail_elButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                count = hot_tea_detail_elButton.getNumber();
            }
        });
        hot_tea_order.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.rb_5min_hot_tea){
                    Orderin = "5 min";
                }
                else if(checkedId==R.id.rb_10min_hot_tea){
                    Orderin = "10 min";
                }
                else if(checkedId==R.id.rb_15min_hot_tea){
                    Orderin = "15 min";
                }
                else if(checkedId==R.id.rb_20min_hot_tea){
                    Orderin = "20 min";
                }
                else if(checkedId==R.id.rb_25min_hot_tea){
                    Orderin = "25 min";
                }
                else if(checkedId==R.id.rb_30min_hot_tea){
                    Orderin = "30 min";
                }
            }
        });
        return view;
    }

    private void getDetailTea(String hotTeaId) {
        hotTea.child(hotTeaId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                HotTea hotTeaa = dataSnapshot.getValue(HotTea.class);
                Picasso.with(getContext()).load(hotTeaa.getImage()).into(iv_hot_tea_detail);
                tv_hot_tea_detail_name.setText(hotTeaa.getName());
                tv_hot_tea_detail_price.setText(hotTeaa.getPrice());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
