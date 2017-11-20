package com.example.user.yu_gi_ohassistant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CardView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_view);
        Intent mIntent = getIntent();
        int intValue = mIntent.getIntExtra("id", 0);
        SQLiteHelper db = new SQLiteHelper(this);
        Card card = db.getCard(intValue);
        System.out.println(card.getCardType());
        TextView type = (TextView) findViewById(R.id.type);
        TextView level = (TextView) findViewById(R.id.level);
        TextView attack = (TextView) findViewById(R.id.attack);
        TextView defense = (TextView) findViewById(R.id.defense);
        TextView attribute = (TextView) findViewById(R.id.attribute);
        if(card.getCardType().equals("Spell"))
        {
            System.out.println("Hi");
            SpellCard cards = (SpellCard)db.getCard(intValue);
            type.setText(cards.getType());
            level.setText("");
            attack.setText("");
            defense.setText("");
            attribute.setText("");
        }
        else if(card.getCardType().equals("Trap"))
        {
            TrapCard cards = (TrapCard)db.getCard(intValue);
            type.setText(cards.getType());
            level.setText("");
            attack.setText("");
            defense.setText("");
            attribute.setText("");
        }
        else if(card.getCardType().equals("Normal Monster") || card.getCardType().equals("Effect Monster") || card.getCardType().equals("Union Monster") || card.getCardType().equals("Gemini Monster"))
        {
            MonsterCard cards = (MonsterCard) db.getCard(intValue);
            type.setText(cards.getType());
            level.setText("LEVEL " + cards.getLevel());
            attack.setText("ATK " + cards.getAttack());
            defense.setText("DEF " + cards.getDefense());
            attribute.setText(cards.getAttribute());
        }
        else if(card.getCardType().equals("Fusion Monster") || card.getCardType().equals("Fusion/Effect Monster"))
        {
            FusionMonsterCard cards = (FusionMonsterCard)db.getCard(intValue);
            type.setText(cards.getType());
            level.setText("LEVEL " + cards.getLevel());
            attack.setText("ATK " + cards.getAttack());
            defense.setText("DEF " + cards.getDefense());
            attribute.setText(cards.getAttribute());
        }
        else if(card.getCardType().equals("Synchro Monster"))
        {
            SynchroMonsterCard cards = (SynchroMonsterCard)db.getCard(intValue);
            type.setText(cards.getType());
            level.setText("LEVEL " + cards.getLevel());
            attack.setText("ATK " + cards.getAttack());
            defense.setText("DEF " + cards.getDefense());
            attribute.setText(cards.getAttribute());
        }
        else if(card.getCardType().equals("XYZ Monster"))
        {
            XYZMonsterCard cards = (XYZMonsterCard)db.getCard(intValue);
            type.setText(cards.getType());
            level.setText("LEVEL " + cards.getLevel());
            attack.setText("ATK " + cards.getAttack());
            defense.setText("DEF " + cards.getDefense());
            attribute.setText(cards.getAttribute());
        }
        TextView name = (TextView) findViewById(R.id.card_name);
        TextView text = (TextView) findViewById(R.id.text);
        TextView effect = (TextView) findViewById(R.id.effect);
        name.setText(card.getName());
        text.setText(card.getText());
        effect.setText(card.getEffect());
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
