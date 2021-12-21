package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    /*
    global variables to maintain the alternating pattern for the text label and background color
    depending on the parities for each

    Note: if the alternating pattern was interrupted by any external means like
          a custom label or resetting everything the pattern will restart from
          scratch again

    */
    int Background_var = 0;
    int setText_var = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myText = findViewById(R.id.text);
        TextView Button = findViewById(R.id.button);
        TextView BackgroundButton = findViewById(R.id.Background_button);
        TextView customTextButton = findViewById(R.id.textCustomButton);
        RelativeLayout layout = findViewById(R.id.mainFrame);



        //user can change the text background color from purple to white and vice versa (alternating pattern)
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (myText.getCurrentTextColor() == getResources().getColor(R.color.white)) {
                    myText.setTextColor(getResources().getColor(R.color.OrangeBrownish));
                }
                else {
                    myText.setTextColor(getResources().getColor(R.color.white));
                }
            }
        });


        //user can change the whole screen background color from its original dark blue to green (and vice versa)
        BackgroundButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Background_var % 2 == 0) {
                    layout.setBackgroundColor(getResources().getColor(R.color.lightBlue));
                }
                else{
                    layout.setBackgroundColor(getResources().getColor(R.color.darkBlue));
                }
                Background_var += 1;
            }
        });

        // change the text on the label (Just two options going back and forth) alternatively
        findViewById(R.id.textChangeButton).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (setText_var % 2 == 0) {
                    myText.setText("I love you!");
                }
                else{
                    myText.setText("Hello from Abdel!");
                }
                setText_var += 1;
            }
        });


        //when tap on the screen background, reset all the settings
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset everything back to the original status including the variables
                myText.setTextColor(getResources().getColor(R.color.white));
                layout.setBackgroundColor(getResources().getColor(R.color.darkBlue));
                myText.setText("Hello from Abdel!");
                setText_var = 0;
                Background_var = 0;
            }
        });

        customTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String givenString = ((EditText) findViewById(R.id. editText)).getText().toString();
                if (givenString.length() != 0) {
                    myText.setText(givenString);
                }
                else{
                    myText.setText("Hello from Abdel!");
                }
                setText_var = 0;
            }
        });
    }
}