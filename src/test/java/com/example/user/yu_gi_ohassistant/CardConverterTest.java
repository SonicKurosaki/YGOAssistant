package com.example.user.yu_gi_ohassistant;
import com.example.user.yu_gi_ohassistant.*;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CardConverterTest {
    private CardConverter cc;

    @Before
    public final void before() {
        cc = new CardConverter();
    }

    @Test
    public void makeMonsterCard() throws Exception {
        MonsterCard card = (MonsterCard) cc.convertCard(",LOB-000,Tri-Horned Dragon,Normal Monster,Secret Rare,None,Dark,Dragon,8,2850,2350,An unworthy dragon with three sharp horns sprouting from its head.");
        System.out.println(card.getName());
        System.out.println(card.getText());
        System.out.println(card.getEffect());
        System.out.println(card.getAttack());
        System.out.println(card.getDefense());
        System.out.println(card.getLevel());
        System.out.println(card.getType());
        System.out.println(card.getAttribute());
    }

    @Test
    public void makeSpellCard() throws Exception {
        SpellCard card = (SpellCard) cc.convertCard(",LOB-041,Beast Fangs,Spell,Common,Increase ATK/DEF,,Equip,,,,A Beast-Type monster equipped with this card increases its ATK and DEF by 300 points.");
        System.out.println(card.getName());
        System.out.println(card.getText());
        System.out.println(card.getEffect());
        System.out.println(card.getType());
    }

    @Test
    public void makeTrapCard() throws Exception {
        TrapCard card = (TrapCard) cc.convertCard(",LOB-045,Dragon Capture Jar,Trap,Rare,Change Position,,Continuous,,,,All Dragon-Type monsters on the field are switched to Defense Position and remain in this position as long as this card is active.");
        System.out.println(card.getName());
        System.out.println(card.getText());
        System.out.println(card.getEffect());
        System.out.println(card.getType());
    }

    @Test
    public void makeFusionMonsterCard() throws Exception {
        FusionMonsterCard card = (FusionMonsterCard) cc.convertCard(",LOB-125,Gaia the Dragon Champion,Fusion Monster,Secret Rare,None,Wind,Dragon,7,2600,2100,\"\"\"Gaia the Fierce Knight\"\" + \"\"Curse of Dragon\"\",\"\"Gaia the Fierce Knight\"\" + \"\"Curse of Dragon\"\"\"");
        System.out.println(card.getName());
        System.out.println(card.getText());
        System.out.println(card.getEffect());
        System.out.println(card.getAttack());
        System.out.println(card.getDefense());
        System.out.println(card.getLevel());
        System.out.println(card.getType());
        System.out.println(card.getAttribute());
        System.out.println(card.getMaterial());
    }

    @Test
    public void makeSynchroMonsterCard() throws Exception {
        SynchroMonsterCard card = (SynchroMonsterCard) cc.convertCard(",LOB-125,Stardust Dragon,Synchro Monster,Secret Rare,Negate,Wind,Dragon,8,2500,2000,1 Tuner + 1 or more non-Tuner monsters,\"During either player's turn, when a card or effect is activated that would destroy a card(s) on the field: You can Tribute this card; negate the activation, and if you do, destroy it. During the End Phase, if this effect was activated this turn (and was not negated): You can Special Summon this card from your Graveyard.\"");
        System.out.println(card.getName());
        System.out.println(card.getText());
        System.out.println(card.getEffect());
        System.out.println(card.getAttack());
        System.out.println(card.getDefense());
        System.out.println(card.getLevel());
        System.out.println(card.getType());
        System.out.println(card.getAttribute());
        System.out.println(card.getMaterial());
    }

    @Test
    public void makeXYZMonsterCard() throws Exception {
        XYZMonsterCard card = (XYZMonsterCard) cc.convertCard(",GENF-EN039,Number 17: Leviathan Dragon,XYZ Monster,Ultra Rare,Increase ATK/DEF,Water,Dragon,3,2000,0,2 Level 3 monsters,\"Once per turn: You can detach 1 Xyz Material from this card; this card gains 500 ATK. If this card has no Xyz Material, it cannot attack your opponent directly.\n\"");
        System.out.println(card.getName());
        System.out.println(card.getText());
        System.out.println(card.getEffect());
        System.out.println(card.getAttack());
        System.out.println(card.getDefense());
        System.out.println(card.getRank());
        System.out.println(card.getType());
        System.out.println(card.getAttribute());
        System.out.println(card.getMaterial());
    }
    @Test
    public void convertBEWD() throws Exception
    {
        File file = new File("C:\\Users\\User\\AndroidStudioProjects\\Yu-Gi-OhAssistant\\app\\TestCSV.csv");
        Scanner scan = new Scanner(file);
        int i = 0;
        while(scan.hasNextLine())
        {
            Card card = cc.convertCard(scan.nextLine());
            System.out.println(card.getName());
            System.out.println(card.getText());
            card.setId(i);
            i++;
        }
    }
}
