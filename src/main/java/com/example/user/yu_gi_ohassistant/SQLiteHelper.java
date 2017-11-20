package com.example.user.yu_gi_ohassistant;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper
{
    public static final String TABLE_NAME = "CARDS";
    public static final String COLUMN_ID = "ID";
    //card name
    public static final String COLUMN_CARD_NAME = "CARD_NAME";
    //type
    public static final String COLUMN_CARD_TYPE = "CARD_TYPE";
    //card level
    public static final String COLUMN_CARD_LEVEL = "CARD_LEVEL";
    //card type
    public static final String COLUMN_CARD_CARDTYPE = "CARD_CARDTYPE";
    //card attack
    public static final String  COLUMN_CARD_ATTACK = "CARD_ATTACK";
    //card defense
    public static final String COLUMN_CARD_DEFENSE = "CARD_DEFENSE";
    //card effect
    public static final String COLUMN_CARD_EFFECTS = "CARD_EFFECTS";
    //card attribute
    public static final String COLUMN_CARD_ATTRIBUTES = "CARD_ATTRIBUTES";
    //card text
    public static final String COLUMN_CARD_TEXT = "CARD_TEXT";
    public static final String COLUMN_CARD_MATERIAL ="CARD_MATERIAL";
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "YGODatabase.db";
    private SQLiteDatabase database;
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_CARD_NAME + " VARCHAR, " + COLUMN_CARD_TYPE + " VARCHAR, " + COLUMN_CARD_LEVEL + " INTEGER, " + COLUMN_CARD_CARDTYPE + " VARCHAR, " + COLUMN_CARD_ATTACK + " INTEGER, " + COLUMN_CARD_DEFENSE + " INTEGER, " + COLUMN_CARD_EFFECTS + " VARCHAR, " + COLUMN_CARD_ATTRIBUTES + " VARCHAR, " + COLUMN_CARD_MATERIAL + " VARCHAR, " + COLUMN_CARD_TEXT + " VARCHAR);");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    public void insertCards(List<Card> cards)
    {
        database = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        Card temp;
        for(int i = 0; i < cards.size(); i++)
        {
            temp = cards.get(i);
            contentValues.put(COLUMN_CARD_NAME, temp.getName());
            contentValues.put(COLUMN_CARD_EFFECTS, temp.getEffect());
            contentValues.put(COLUMN_CARD_TEXT, temp.getText());
            contentValues.put(COLUMN_CARD_CARDTYPE, temp.getCardType());
            if(cards.get(i).getCardType().equals("Spell"))
            {
                SpellCard temps = (SpellCard)cards.get(i);
                contentValues.put(COLUMN_CARD_TYPE, temps.getType());
            }
            else if(cards.get(i).getCardType().equals("Trap"))
            {
                TrapCard temps = (TrapCard)cards.get(i);
                contentValues.put(COLUMN_CARD_TYPE, temps.getType());
            }
            else if(cards.get(i).getCardType().equals("Normal Monster") || cards.get(i).getCardType().equals("Effect Monster") || cards.get(i).getCardType().equals("Union Monster") || cards.get(i).getCardType().equals("Gemini Monster"))
            {
                MonsterCard temps = (MonsterCard)cards.get(i);
                contentValues.put(COLUMN_CARD_TYPE, temps.getType());
                contentValues.put(COLUMN_CARD_LEVEL, temps.getLevel());
                contentValues.put(COLUMN_CARD_ATTACK, temps.getAttack());
                contentValues.put(COLUMN_CARD_DEFENSE, temps.getDefense());
                contentValues.put(COLUMN_CARD_ATTRIBUTES, temps.getAttribute());
            }
            else if(cards.get(i).getCardType().equals("Fusion Monster") || cards.get(i).getCardType().equals("Fusion/Effect Monster"))
            {
                FusionMonsterCard temps = (FusionMonsterCard)cards.get(i);
                contentValues.put(COLUMN_CARD_TYPE, temps.getType());
                contentValues.put(COLUMN_CARD_LEVEL, temps.getLevel());
                contentValues.put(COLUMN_CARD_ATTACK, temps.getAttack());
                contentValues.put(COLUMN_CARD_DEFENSE, temps.getDefense());
                contentValues.put(COLUMN_CARD_ATTRIBUTES, temps.getAttribute());
                contentValues.put(COLUMN_CARD_MATERIAL, temps.getMaterial());
            }
            else if(cards.get(i).getCardType().equals("Synchro Monster"))
            {
                SynchroMonsterCard temps = (SynchroMonsterCard)cards.get(i);
                contentValues.put(COLUMN_CARD_TYPE, temps.getType());
                contentValues.put(COLUMN_CARD_LEVEL, temps.getLevel());
                contentValues.put(COLUMN_CARD_ATTACK, temps.getAttack());
                contentValues.put(COLUMN_CARD_DEFENSE, temps.getDefense());
                contentValues.put(COLUMN_CARD_ATTRIBUTES, temps.getAttribute());
                contentValues.put(COLUMN_CARD_MATERIAL, temps.getMaterial());
            }
            else if(cards.get(i).getCardType().equals("XYZ Monster"))
            {
                XYZMonsterCard temps = (XYZMonsterCard)cards.get(i);
                contentValues.put(COLUMN_CARD_TYPE, temps.getType());
                contentValues.put(COLUMN_CARD_LEVEL, temps.getLevel());
                contentValues.put(COLUMN_CARD_ATTACK, temps.getAttack());
                contentValues.put(COLUMN_CARD_DEFENSE, temps.getDefense());
                contentValues.put(COLUMN_CARD_ATTRIBUTES, temps.getAttribute());
                contentValues.put(COLUMN_CARD_MATERIAL, temps.getMaterial());
            }
            database.insert(TABLE_NAME, null, contentValues);
        }
        database.close();
    }
    public List<Card> getAllCards() {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        List<Card> cards = new ArrayList<Card>();
        Card temp;
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                System.out.println("This is "+i);
                cursor.moveToNext();
                temp = new Card();
                temp.setName(cursor.getString(1));
                temp.setCardType(cursor.getString(4));
                cards.add(i,temp);
            }
        }
        cursor.close();
        database.close();
        return cards;
    }
    public Card getCard(int id)
    {
        database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        cursor.moveToPosition(id);
        Card card;
        card = new Card(cursor.getString(1), cursor.getString(10), cursor.getString(7), null, cursor.getString(4), cursor.getInt(0));
        if(card.getCardType().equals("Spell"))
        {
            SpellCard cards = new SpellCard(card.getName(),card.getText(),card.getEffect(),null,card.getCardType(),null);
            cards.setType(cursor.getString(2));
            cursor.close();
            database.close();
            return cards;
        }
        else if(card.getCardType().equals("Trap"))
        {
            TrapCard cards = new TrapCard(card.getName(),card.getText(),card.getEffect(),null,card.getCardType(),null);
            cards.setType(cursor.getString(2));
            cursor.close();
            database.close();
            return cards;
        }
        else if(card.getCardType().equals("Normal Monster") || card.getCardType().equals("Effect Monster") || card.getCardType().equals("Union Monster") || card.getCardType().equals("Gemini Monster"))
        {
            MonsterCard cards = new MonsterCard(card.getName(),card.getText(),card.getEffect(),null,card.getCardType(),null,0,null,0,0);
            cards.setType(cursor.getString(2));
            cards.setLevel(cursor.getInt(3));
            cards.setAttack(cursor.getInt(5));
            cards.setDefense(cursor.getInt(6));
            cards.setAttribute(cursor.getString(8));
            cursor.close();
            database.close();
            return cards;
        }
        else if(card.getCardType().equals("Fusion Monster") || card.getCardType().equals("Fusion/Effect Monster"))
        {
            FusionMonsterCard cards = new FusionMonsterCard(card.getName(),card.getText(),card.getEffect(),null,card.getCardType(),null,0,null,0,0, null);
            cards.setType(cursor.getString(2));
            cards.setLevel(cursor.getInt(3));
            cards.setAttack(cursor.getInt(5));
            cards.setDefense(cursor.getInt(6));
            cards.setAttribute(cursor.getString(8));
            cards.setMaterial(cursor.getString(9));
            cursor.close();
            database.close();
            return cards;
        }
        else if(card.getCardType().equals("Synchro Monster"))
        {
            SynchroMonsterCard cards = new SynchroMonsterCard(card.getName(),card.getText(),card.getEffect(),null,card.getCardType(),null,0,null,0,0, null);
            cards.setType(cursor.getString(2));
            cards.setLevel(cursor.getInt(3));
            cards.setAttack(cursor.getInt(5));
            cards.setDefense(cursor.getInt(6));
            cards.setAttribute(cursor.getString(8));
            cards.setMaterial(cursor.getString(9));
            cursor.close();
            database.close();
            return cards;
        }
        else if(card.getCardType().equals("XYZ Monster"))
        {
            XYZMonsterCard cards = new XYZMonsterCard(card.getName(),card.getText(),card.getEffect(),null,card.getCardType(),null,0,null,0,0, null, 0);
            cards.setType(cursor.getString(2));
            cards.setRank(cursor.getInt(3));
            cards.setAttack(cursor.getInt(5));
            cards.setDefense(cursor.getInt(6));
            cards.setAttribute(cursor.getString(8));
            cards.setMaterial(cursor.getString(9));
            cursor.close();
            database.close();
            return cards;
        }
        cursor.close();
        database.close();
        return card;
    }
    public void deleteCard(Card card)
    {
        database = this.getWritableDatabase();
        database.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(card.getId()) });
        database.close();
    }
    public void deleteAllCards()
    {
        database = this.getWritableDatabase();
        Cursor cursor = database.query(TABLE_NAME, null, null, null, null, null, null);
        if (cursor.getCount() > 0) {
            for (int i = 0; i < cursor.getCount(); i++) {
                database.delete(TABLE_NAME, COLUMN_ID + " = ?", new String[] { String.valueOf(i) });
                cursor.moveToNext();
            }
        }
        cursor.close();
        database.close();
    }
}