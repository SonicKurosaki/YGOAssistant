package com.example.user.yu_gi_ohassistant;

import android.media.Image;
/**
 * Created by User on 11/6/2017.
 */

public class Card extends Object
{
    String name;
    String text;
    String effect;
    Image image;

    public String getCardType() {
        return cardtype;
    }

    public void setCardType(String cardtype) {
        this.cardtype = cardtype;
    }

    String cardtype;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    int id;
    public Card()
    {
    }

    public Card(String name, String text, String effect, Image image, String cardtype, int id)
    {
        this.name = name;
        this.text = text;
        this.effect = effect;
        this.image = image;
        this.cardtype = cardtype;
        this.id = id;
    }

    public String getText()
    {
        return text;
    }
    public String getName()
    {
        return name;
    }
    public String getEffect()
    {
        return effect;
    }
    public Image getImage()
    {
        return image;
    }

    public void setEffect(String effect)
    {
        this.effect = effect;
    }

    public void setImage(Image image)
    {
        this.image = image;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
