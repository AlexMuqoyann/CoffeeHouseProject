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
import com.example.hp.coffeeh.models.CoffeeDetail;
import com.example.hp.coffeeh.models.SmoothieDetail;
import com.example.hp.coffeeh.models.Smoothies;
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
public class SmoothieDetailsFragment extends Fragment {
    private ImageView iv_smoothie_detail;
    private TextView tv_smoothie_detail_name,tv_smoothie_detail_price;
    private FloatingActionButton fl_smoothie_detail;
    private ElegantNumberButton smoothie_detail_elButton;
    private DatabaseReference smoothie;
    private EditText smoothie_sugar;
    private RadioGroup smoothie_order;
    private String OrderIn;
    private String count;
    private String Type;
    private String smoothieId = "";
    private DatabaseReference Slavonic;
    private DatabaseReference Aleq_Manukyan;
    private DatabaseReference Bryusov;
    private DatabaseReference Asue;
    private DatabaseReference Polytech;


    public SmoothieDetailsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_smoothie_details, container, false);
        smoothie = FirebaseDatabase.getInstance().getReference("Smoothie");
        Slavonic = FirebaseDatabase.getInstance().getReference("Slavonic");
        Aleq_Manukyan = FirebaseDatabase.getInstance().getReference("AleqManukyan");
        Bryusov = FirebaseDatabase.getInstance().getReference("Bryusov");
        Asue = FirebaseDatabase.getInstance().getReference("Asue");
        Polytech = FirebaseDatabase.getInstance().getReference("Polytech");
        iv_smoothie_detail = view.findViewById(R.id.iv_smoothie_detail);
        tv_smoothie_detail_name = view.findViewById(R.id.tv_smoothie_detail_name);
        tv_smoothie_detail_price = view.findViewById(R.id.tv_smoothie_detail_price);
        fl_smoothie_detail = view.findViewById(R.id.fl_smoothie_detail);
        smoothie_sugar = view.findViewById(R.id.smoothie_sugar);
        smoothie_order = view.findViewById(R.id.smoothie_order);
        smoothie_detail_elButton = view.findViewById(R.id.smoothie_detail_elButton);

        Bundle args = getArguments();
        if(args!=null){
            smoothieId = args.getString("smoothieId");
            if(!smoothieId.isEmpty()){
                getDetailSmoothie(smoothieId);
            }
        }
        smoothie_detail_elButton.setOnValueChangeListener(new ElegantNumberButton.OnValueChangeListener() {
            @Override
            public void onValueChange(ElegantNumberButton view, int oldValue, int newValue) {
                count = smoothie_detail_elButton.getNumber();
            }
        });
        smoothie_order.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.smoothie_5min){
                    OrderIn = "5 min";
                }
                else if(checkedId ==R.id.smoothie_10min){
                    OrderIn = "10 min";
                }
                else if(checkedId ==R.id.smoothie_15min){
                    OrderIn = "15 min";
                }
                else if(checkedId ==R.id.smoothie_20min){
                    OrderIn = "20 min";
                }
                else if(checkedId ==R.id.smoothie_25min){
                    OrderIn = "25 min";
                }
                else if(checkedId ==R.id.smoothie_30min){
                    OrderIn = "30 min";
                }
            }
        });
        fl_smoothie_detail.setOnClickListener(new View.OnClickListener() {
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
                            String Name = tv_smoothie_detail_name.getText().toString();
                            String Price = tv_smoothie_detail_price.getText().toString();
                            String sugar = smoothie_sugar.getText().toString();
                            String id = Slavonic.push().getKey();
                            SmoothieDetail detail = new SmoothieDetail(Name,Price,count,sugar,OrderIn,id,new Date(System.currentTimeMillis()).toString());
                            Slavonic.child(id).setValue(detail);
                        }
                        if (Cb_aleq_manukyan.isChecked()){
                            String Name = tv_smoothie_detail_name.getText().toString();
                            String Price = tv_smoothie_detail_price.getText().toString();
                            String sugar = smoothie_sugar.getText().toString();
                            String id = Aleq_Manukyan.push().getKey();
                            SmoothieDetail detail = new SmoothieDetail(Name,Price,count,sugar,OrderIn,id,new Date(System.currentTimeMillis()).toString());
                            Aleq_Manukyan.child(id).setValue(detail);
                        }
                        if (Cb_bryusov.isChecked()){
                            String Name = tv_smoothie_detail_name.getText().toString();
                            String Price = tv_smoothie_detail_price.getText().toString();
                            String sugar = smoothie_sugar.getText().toString();
                            String id = Bryusov.push().getKey();
                            SmoothieDetail detail = new SmoothieDetail(Name,Price,count,sugar,OrderIn,id,new Date(System.currentTimeMillis()).toString());
                            Bryusov.child(id).setValue(detail);
                        }
                        if (Cb_asue.isChecked()){
                            String Name = tv_smoothie_detail_name.getText().toString();
                            String Price = tv_smoothie_detail_price.getText().toString();
                            String sugar = smoothie_sugar.getText().toString();
                            String id = Asue.push().getKey();
                            SmoothieDetail detail = new SmoothieDetail(Name,Price,count,sugar,OrderIn,id,new Date(System.currentTimeMillis()).toString());
                            Asue.child(id).setValue(detail);
                        }
                        if (Cb_polytech.isChecked()){
                            String Name = tv_smoothie_detail_name.getText().toString();
                            String Price = tv_smoothie_detail_price.getText().toString();
                            String sugar = smoothie_sugar.getText().toString();
                            String id = Polytech.push().getKey();
                            SmoothieDetail detail = new SmoothieDetail(Name,Price,count,sugar,OrderIn,id,new Date(System.currentTimeMillis()).toString());
                            Polytech.child(id).setValue(detail);
                        }
                    }
                });
                mBuilder.create();
                mBuilder.show();
            }

        });

        return view;
    }

    private void getDetailSmoothie(String smoothieId) {
        smoothie.child(smoothieId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Smoothies smoothies = dataSnapshot.getValue(Smoothies.class);
                Picasso.with(getContext()).load(smoothies.getImage()).into(iv_smoothie_detail);
                tv_smoothie_detail_name.setText(smoothies.getName());
                tv_smoothie_detail_price.setText(smoothies.getPrice());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
