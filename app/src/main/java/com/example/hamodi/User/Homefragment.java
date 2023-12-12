package com.example.hamodi.User;

import static com.example.hamodi.DataTables.TablesString.ProductTable.*;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.BaseColumns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hamodi.Classes.Product;
import com.example.hamodi.Classes.ProductsAdapter;
import com.example.hamodi.DataTables.DBHelper;
import com.example.hamodi.R;


import java.util.ArrayList;
import java.util.List;

public class Homefragment extends Fragment {

    List<Product> productList;
    RecyclerView recyclerView;
    ProductsAdapter mAdapter;
    DBHelper dbHelper;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_homefragment, container, false);
        recyclerView = view.findViewById(R.id.games_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(null));
        productList = new ArrayList<>();
        dbHelper = new DBHelper(inflater.getContext());
        dbHelper = dbHelper.OpenReadAble();
        Product p = new Product();
        Cursor c = p.Select(dbHelper.getDb());
        c.moveToFirst();
        while(!c.isAfterLast()){
            p.setPid(c.getInt(c.getColumnIndexOrThrow(BaseColumns._ID)));
            p.setGameName(c.getString(c.getColumnIndexOrThrow(COLUMN_PRODUCT_NAME)));
            p.setProdDisc(c.getString(c.getColumnIndexOrThrow(COLUMN_PRODUCT_DESCRIPTION)));
            p.setGameprice(c.getDouble(c.getColumnIndexOrThrow(COLUMN_PRODUCT_BUYPRICE)));
            p.setSaleprice(c.getDouble(c.getColumnIndexOrThrow(COLUMN_PRODUCT_SALEPRICE)));
            p.setQuantity(c.getInt(c.getColumnIndexOrThrow(COLUMN_PRODUCT_STOCK)));
            p.setImageByte(c.getBlob(c.getColumnIndexOrThrow(COLUMN_PRODUCT_IMAGE)));
            productList.add(p);
            c.moveToNext();
            p=new Product();
        }
        // adapter
        mAdapter = new ProductsAdapter(inflater.getContext(), productList);
        recyclerView.setAdapter(mAdapter);
        // Inflate the layout for this fragment
        return  view;
    }
}