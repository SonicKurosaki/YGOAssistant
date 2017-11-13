package com.example.user.yu_gi_ohassistant;

import android.media.Image;

/**
 * Created by User on 11/6/2017.
 */

public class TrapCard extends Card
{
    String type;
    public TrapCard(String name, String text, String effect, Image image, String type)
    {
        this.name = name;
        this.text = text;
        this.effect = effect;
        this.image = image;
        this.type = type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
