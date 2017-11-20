package com.example.user.yu_gi_ohassistant;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 11/17/2017.
 */

public class FillDatabaseTest
{
    private FillDatabase fb;

    @Before
    public final void before() {
            fb = new FillDatabase();
        }

    @Test
    public void convert() throws Exception
    {
        File file = new File("app/TestCSV.csv");
        fb.fill(null);
    }

}
