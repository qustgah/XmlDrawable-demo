package com.example.apple.xmldrawable;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {


    RecyclerView example;
    RecyclerView.LayoutManager layoutManager;
    DrawableExampleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        example = (RecyclerView) findViewById(R.id.example);
        layoutManager = new LinearLayoutManager(this);
        example.setLayoutManager(layoutManager);
        adapter = new DrawableExampleAdapter();
        example.setAdapter(adapter);
        Drawable drawable;
    }



}
