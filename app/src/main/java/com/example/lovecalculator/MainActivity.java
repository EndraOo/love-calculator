package com.example.lovecalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edtCrushName;
    private EditText edtName;
    private Button btnCalculate;

    private String crushName;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCrushName = findViewById(R.id.edtCrushName);
        edtName = findViewById(R.id.edtName);
        btnCalculate = findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doCalculate();
            }
        });
    }

    private boolean isInputOK() {

        boolean ok = true;

        this.crushName = edtCrushName.getText().toString();
        this.name = edtName.getText().toString();

        if (this.crushName.isEmpty()) {
            ok = false;
            edtCrushName.setError("Enter your crush name.");
        }
        if (name.isEmpty()) {
            ok = false;
            edtName.setError("Enter your name.");
        }

        return ok;
    }

    private void doCalculate() {

        if (isInputOK()) {
            Intent intent = new Intent(this, ResultActivity.class);
            intent.putExtra("crush-name", this.crushName);
            intent.putExtra("name", this.name);
            startActivity(intent);
        }
    }
}

        
    
