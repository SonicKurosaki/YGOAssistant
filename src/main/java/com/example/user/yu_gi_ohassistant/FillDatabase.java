package com.example.user.yu_gi_ohassistant;
import com.example.user.yu_gi_ohassistant.*;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User on 11/14/2017.
 */

public class FillDatabase
{
    public FillDatabase() {
    }

    private CardConverter cc;
    public List<Card> fill(Context context) throws Exception
    {
        AssetManager assetManager = context.getAssets();
        InputStream csvStream = assetManager.open("TestCSV.csv");
        InputStreamReader csvStreamReader = new InputStreamReader(csvStream);
        cc = new CardConverter();
        System.out.println("hi");
        Scanner scan = new Scanner(csvStream);
        List<Card> cards = new ArrayList<Card>();
        while(scan.hasNextLine())
        {
            System.out.println("hi");
            Card card = cc.convertCard(scan.nextLine());
            System.out.println(card.getName());
            cards.add(card);
        }
        return cards;
    }
}


