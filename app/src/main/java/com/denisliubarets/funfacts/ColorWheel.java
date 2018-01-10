package com.denisliubarets.funfacts;


import android.graphics.Color;

import java.util.Random;

public class ColorWheel {

    private Random randomGenerator = new Random();
    private String[] mColors = {
            "#39add1", // light blue
            "#3079ab", // dark blue
            "#c25975", // mauve
            "#e15258", // red
            "#f9845b", // orange
            "#838cc7", // lavender
            "#7d669e", // purple
            "#53bbb4", // aqua
            "#51b46d", // green
            "#e0ab18", // mustard
            "#637a91", // dark gray
            "#f092b0", // pink
            "#b7c0c7"  // light gray
    };

    int getColor() {
        int colorIndex = nextRandomColor();
        return Color.parseColor(mColors[colorIndex]);
    }

    // Last color index is used so the same color never rolls twice
    private static int lastColorIndex = 0;

    private int nextRandomColor() {
        int bound = mColors.length;
        int colorIndex = randomGenerator.nextInt(bound);

        if (colorIndex == lastColorIndex) {
            colorIndex = nextRandomColor();
        }

        lastColorIndex = colorIndex;
        return colorIndex;
    }

}