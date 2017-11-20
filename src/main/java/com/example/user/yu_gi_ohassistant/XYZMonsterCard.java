package com.example.user.yu_gi_ohassistant;

import android.media.Image;

import java.util.List;

/**
 * Created by User on 11/6/2017.
 */

public class XYZMonsterCard extends MonsterCard
{
    String material;
    int rank;
    public XYZMonsterCard(String name, String text, String effect, Image image, String cardtype, String attribute, int level, String type, int attack, int defense, String material, int rank)
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
        this.material = material;
        this.cardtype = cardtype;
        this.rank = rank;
    }
    public void setMaterial(String material)
    {
        this.material = material;
    }
    public String getMaterial()
    {
        return material;
    }
    public int getRank()
    {
        return rank;
    }
    public void setRank(int rank)
    {
        this.rank = rank;
    }
}
