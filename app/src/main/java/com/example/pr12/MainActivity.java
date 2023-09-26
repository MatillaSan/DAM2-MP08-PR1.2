package com.example.pr12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random rand = new Random();
        final Button checkButton = findViewById(R.id.checkButton);
        EditText textBox = findViewById(R.id.textBox);
        final int winNum = rand.nextInt(100);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer usrNum = Integer.parseInt(String.valueOf(textBox.getText()));

                if (usrNum > winNum) {
                    Toast toast = Toast.makeText(MainActivity.this, "Your number is higher!", Toast.LENGTH_SHORT);
                    toast.show();
                } else if (usrNum < winNum) {
                    Toast toast = Toast.makeText(MainActivity.this, "Your number is lower!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Toast toast = Toast.makeText(MainActivity.this, "You win!", Toast.LENGTH_SHORT);
                    toast.show();
                }


            }
        });
    }
}