package com.example.bakery;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.firestore.FirebaseFirestore;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;


public class Product extends Fragment {
    ListView list;
    private List<Products> allproducts= new ArrayList<Products>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product,
                container, false);
        ListView list=view.findViewById(R.id.lst_view);
        populatelist();
        ArrayAdapter<Products> adapter=new MyListAdapter();
        list.setAdapter(adapter);

        return view;
    }
    private void populatelist(){
        allproducts.add(new Products("Chocolate Cake",8,R.drawable.choco,"120"));
        allproducts.add(new Products("Donut",12,R.drawable.donut,"80"));
        allproducts.add(new Products("Pastry",15,R.drawable.pastry,"50"));
        allproducts.add(new Products("Cupcake",6,R.drawable.cuppy,"40"));

    }

    private class MyListAdapter extends ArrayAdapter<Products>{
        public MyListAdapter(){
            super(Product.this.getActivity(),R.layout.product_view,allproducts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView =convertView;
            if(itemView==null){
                itemView=getActivity().getLayoutInflater().inflate(R.layout.product_view,parent,false);

            }
            Products currentpro=allproducts.get(position);

            ImageView imageView= (ImageView)itemView.findViewById(R.id.imageView);
            imageView.setImageResource(currentpro.getImageid());

            TextView makeText=itemView.findViewById(R.id.item_name);
            makeText.setText(currentpro.getProductName());

            TextView avaText=itemView.findViewById(R.id.item_ava);
            avaText.setText("Available :"+currentpro.getAvailable());

            TextView priceText=itemView.findViewById(R.id.item_price);
            priceText.setText("Rs : "+currentpro.getPrice());
            return itemView;

        }
    }

}
