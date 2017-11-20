package com.example.user.yu_gi_ohassistant;

import android.app.ListActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DatabaseView extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database_view);//originally activity
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.cardStoring);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SQLiteHelper db = new SQLiteHelper(this);
        FillDatabase fb = new FillDatabase();
        List<Card> cards;
        List<Card> cards2 = db.getAllCards();
        for(int i = 0; i < cards2.size(); i++)
        {
            TextView name = new TextView(this);
            final Card card = cards2.get(i);
            card.setId(i);
            View.OnClickListener linkVRAINS = new View.OnClickListener(){
                public void onClick(View v)
                {
                    Intent intent = new Intent(getApplicationContext(), CardView.class);
                    intent.putExtra("id", card.getId());
                    startActivity(intent);
                }
            };
            name.setText(card.getName());
            linearLayout.addView(name);
            name.setOnClickListener(linkVRAINS);
        }
    }
    public void populate(View view) throws Exception
    {
        SQLiteHelper db = new SQLiteHelper(this);
        FillDatabase fb = new FillDatabase();
        List<Card> cards;
        cards = fb.fill(this);
        //db.insertCards(cards);
        List<Card> cards2 = db.getAllCards();//The database is persisting, so make sure that I can get rid of the duplicates
        for (Card cn : cards2) {
            String log = "Name: " + cn.getName() + " ,Name: " + cn.getName() + " ,Type: " + cn.getCardType();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }
        //db.deleteAllCards();
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
