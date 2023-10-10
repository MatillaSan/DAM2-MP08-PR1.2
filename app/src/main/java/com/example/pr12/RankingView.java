package com.example.pr12;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RankingView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_view);
        final Button backButton = findViewById(R.id.backButton);
        TextView rankingTitle = findViewById(R.id.rankingTitle);
        TextView rankingHead = findViewById(R.id.rankingHead);
        TextView rankingBox = findViewById(R.id.rankingBox);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(RankingView.this, "Closing ranking view", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(RankingView.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}