package com.example.user.yu_gi_ohassistant;

import android.media.Image;

/**
 * Created by User on 11/6/2017.
 */

public class MonsterCard extends Card
{
    String attribute;
    int level;
    String type;
    int attack;
    int defense;
    public MonsterCard()
    {
        this.attribute = "";
        this.level = 0;
        this.type = "";
        this.attack = 0;
        this.defense = 0;
    }
    public MonsterCard(String name, String text, String effect, Image image, String attribute, int level, String type, int attack, int defense)
    {
        this.name = name;
        this.text = text;
        this.effect = effect;
        this.image = image;
        this.type = type;
        this.attribute = attribute;
        this.level = level;
        this.attack = attack;
        this.defense = defense;
    }

    public int getAttack()
    {
        return attack;
    }
    public int getDefense()
    {
        return defense;
    }

    public int getLevel()
    {
        return level;
    }

    public String getAttribute()
    {
        return attribute;
    }

    public String getType()
    {
        return type;
    }

    public void setAttack(int attack)
    {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setAttribute(String attribute)
    {
        this.attribute = attribute;
    }

    public void setLevel(int level)
    {
        this.level = level;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
