package com.example.user.yu_gi_ohassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
    }
    public void cardView(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CardView.class);
        startActivity(intent);
    }
}
