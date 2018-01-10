package com.denisliubarets.funfacts;

import android.content.res.Resources;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FactBook {

    private String[] mFacts;
    private Resources mResources;

    public FactBook(Resources resources) throws IOException {
        mResources = resources;
        mFacts = loadFile();
    }

    public String getFact() {
        // Randomly select a fact
        Random randomGenerator = new Random();
        int randomNumber = randomGenerator.nextInt(mFacts.length);

        return mFacts[randomNumber];
    }

    private String[] loadFile() throws IOException {

        InputStream is = mResources.openRawResource(R.raw.facts);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));


        List<String> lines = new ArrayList<>();
        String line;

        while ((line = br.readLine()) != null) {
            lines.add(line);
        }

        return lines.toArray(new String[0]);
    }

}
