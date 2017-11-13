package com.example.user.yu_gi_ohassistant;

/**
 * Created by User on 11/6/2017.
 */
import android.media.Image;

import java.util.List;
public class SynchroMonsterCard extends MonsterCard
{
    String material;
    public SynchroMonsterCard(String name, String text, String effect, Image image, String attribute, int level, String type, int attack, int defense, String material)
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
    }
    public void setMaterial(String material)
    {
        this.material = material;
    }
    public String getMaterial()
    {
        return material;
    }
}
