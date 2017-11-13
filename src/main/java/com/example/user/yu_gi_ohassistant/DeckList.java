package com.example.user.yu_gi_ohassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DeckList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deck_list);
    }
    public void deckView(View view)
    {
        Intent intent = new Intent(getApplicationContext(), Deck.class);
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
