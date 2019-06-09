package com.example.lovecalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


        public class ResultActivity extends AppCompatActivity {

            private static final int LOADING_TIME = 3000;

            private TextView txvCrushName;
            private TextView txvName;
            private TextView txvLovePercentage;
            private Button btnCalculateAgain;

            private String crushName;
            private String name;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_result);

                Intent intent = getIntent();
                this.crushName = intent.getStringExtra("crush-name");
                this.name = intent.getStringExtra("name");

                txvCrushName = findViewById(R.id.txvCrushName);
                txvName = findViewById(R.id.txvName);
                txvLovePercentage = findViewById(R.id.txvLovePercentage);
                btnCalculateAgain = findViewById(R.id.btnCalculateAgain);


                txvCrushName.setText(crushName);
                txvName.setText(name);

                this.calculateLovePercentage();

                btnCalculateAgain.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onBackPressed();
                    }
                });
            }

            private void calculateLovePercentage() {

                new Handler().postDelayed(new Runnable() {

                    public void run() {

                        int random = (int) (Math.random() * 50 + 1);
                        txvLovePercentage.setText(String.format("%d%%", random));


                        txvLovePercentage.setVisibility(View.VISIBLE);
                        btnCalculateAgain.setVisibility(View.VISIBLE);
                    }
                }, LOADING_TIME);
            }
        }




