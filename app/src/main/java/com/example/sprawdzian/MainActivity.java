package com.example.sprawdzian;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Integer valueOfA;
    private Integer valueOfB;
    private Integer valueOfC;
    private double delta;
    private double sqrtDelta;
    private double xOne;
    private double xTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button calculateButton = findViewById(R.id.calculateButton);
        EditText editTextA = findViewById(R.id.valueA);
        EditText editTextB = findViewById(R.id.valueB);
        EditText editTextC = findViewById(R.id.valueC);
        EditText resoult = findViewById(R.id.resoult);
        calculateButton.setOnClickListener((View v) -> {
            resoult.setText("");
            valueOfA = Integer.valueOf(editTextA.getText().toString());
            valueOfB = Integer.valueOf(editTextB.getText().toString());
            valueOfC = Integer.valueOf(editTextC.getText().toString());
            delta = (valueOfB*valueOfB) - 4*valueOfA*valueOfC;
            sqrtDelta = Math.sqrt(delta);
            if(delta < 0){
                Toast toast = new Toast(getBaseContext());
                toast.setText("Brak rozwiązań");
                toast.setDuration(Toast.LENGTH_SHORT);
                toast.show();
            }
            else if (delta == 0) {
                xOne = ((valueOfB*(-1)) + sqrtDelta)/ (2*valueOfA);
                resoult.setText("x={"+xOne+"}");
            }
            else if (delta > 0){
                xOne = ((valueOfB*(-1)) + sqrtDelta)/ (2*valueOfA);
                xTwo = ((valueOfB*(-1)) - sqrtDelta)/ (2*valueOfA);
                resoult.setText("x={"+xOne+" "+ xTwo +"}");
            }
        });
    }
}