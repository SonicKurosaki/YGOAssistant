package com.example.user.yu_gi_ohassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CardView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
    }
    public void packView(View view)
    {
        Intent intent = new Intent(getApplicationContext(), PackViewer.class);
        startActivity(intent);
    }
    public void deckList(View view)
    {
        Intent intent = new Intent(getApplicationContext(), DeckList.class);
        startActivity(intent);
    }
}
