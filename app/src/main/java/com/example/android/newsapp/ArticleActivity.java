package com.example.android.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ArticleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.article_list_item);
    }
}