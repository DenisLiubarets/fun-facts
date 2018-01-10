package com.denisliubarets.funfacts;


import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class FunFactsActivity extends AppCompatActivity {

    private Resources resources;

    private FactBook mFactBook;
    private ColorWheel mColorWheel;

    // Declare our View variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        resources = getResources();
        try {
            mFactBook = new FactBook(resources);
        } catch (IOException e) {
            Toast toast = Toast.makeText(this, "File: not found!", Toast.LENGTH_LONG);
            toast.show();
        }
        mColorWheel = new ColorWheel();

        // Assign the views from the layout file to the corresponding variables
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        generateRandomFact();
        generateRandomColor();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generateRandomFact();
                generateRandomColor();
            }
        };
        mShowFactButton.setOnClickListener(listener);
    }

    private void generateRandomFact() {
        String fact = mFactBook.getFact();
        mFactTextView.setText(fact);
    }

    private void generateRandomColor() {
        int color = mColorWheel.getColor();
        mRelativeLayout.setBackgroundColor(color);
        mShowFactButton.setTextColor(color);
    }
}
