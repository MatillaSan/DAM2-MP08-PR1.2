package com.example.pr12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Random rand = new Random();

    int numberCount = 0;
    int winNum = rand.nextInt(100);
    String numbersUsed = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button checkButton = findViewById(R.id.checkButton);
        EditText textBox = findViewById(R.id.textBox);
        TextView textAttemptCount = findViewById(R.id.attempsNumber);
        TextView textNumbersUsed = findViewById(R.id.textNumbersUseds);
        ScrollView scrollUsedNumbers = findViewById(R.id.scrollNumbers);
        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!textBox.getText().toString().equals("")) {
                    Integer usrNum = Integer.parseInt(String.valueOf(textBox.getText()));

                    if (usrNum > winNum) {
                        Toast toast = Toast.makeText(MainActivity.this, "Your number is higher!", Toast.LENGTH_SHORT);
                        toast.show();
                        numberCount++;
                        numbersUsed += usrNum.toString() + " is higher\n";
                        textAttemptCount.setText("Attemps Number: " + numberCount);
                        textNumbersUsed.setText(numbersUsed);
                        // scrollUsedNumbers.scrollTo(scrollUsedNumbers.getRight(), 0);
                        scrollUsedNumbers.fullScroll(ScrollView.FOCUS_RIGHT);
                        textBox.setText("");

                    } else if (usrNum < winNum) {
                        Toast toast = Toast.makeText(MainActivity.this, "Your number is lower!", Toast.LENGTH_SHORT);
                        toast.show();
                        numberCount++;
                        numbersUsed += usrNum.toString() + " is lower\n";
                        textAttemptCount.setText("Attemps Number: " + numberCount);
                        textNumbersUsed.setText(numbersUsed);
                        scrollUsedNumbers.fullScroll(ScrollView.FOCUS_RIGHT);
                        textBox.setText("");

                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                        builder.setMessage("You has won the game!")
                                .setTitle("Congratulations!")
                                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        textBox.setText("");
                                        winNum = rand.nextInt(100);
                                        numberCount = 0;
                                        textAttemptCount.setText("Attemps Number: " + 0);
                                        numbersUsed = "";
                                        textNumbersUsed.setText("");
                                        textNumbersUsed.refreshDrawableState();
                                    }
                                })
                                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        finish();
                                        System.exit(0);
                                    }
                                });

                        AlertDialog dialog = builder.create();

                        dialog.show();

                    }
                } else {
                    textNumbersUsed.setText("");
                }
            }
        });
    }
}