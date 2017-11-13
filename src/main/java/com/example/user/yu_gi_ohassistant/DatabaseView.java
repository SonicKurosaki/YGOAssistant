package com.example.user.yu_gi_ohassistant;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DatabaseView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void search(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Search.class);
        startActivity(intent);
    }
    public void sort(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Sort.class);
        startActivity(intent);
    }
    public void cardView(View view)
    {
        Intent intent = new Intent(getApplicationContext(), CardView.class);
        startActivity(intent);
    }
    public void cardDatabase(View view)
    {
        Intent intent = new Intent(getApplicationContext(), DatabaseView.class);
        startActivity(intent);
    }
    public void deckList(View view)
    {
        Intent intent = new Intent(getApplicationContext(), DeckList.class);
        startActivity(intent);
    }
    public void calculator(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Calculator.class);
        startActivity(intent);
    }
}
