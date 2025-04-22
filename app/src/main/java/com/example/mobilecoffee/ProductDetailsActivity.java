package com.example.mobilecoffee;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    private Button buttonS, buttonM, buttonL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);  // Make sure this XML has the correct buttons

        // Initialize the buttons
        buttonS = findViewById(R.id.buttonS);
        buttonM = findViewById(R.id.buttonM);
        buttonL = findViewById(R.id.buttonL);

        // Create a single click listener for all buttons
        View.OnClickListener sizeClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deselect all first
                buttonS.setSelected(false);
                buttonM.setSelected(false);
                buttonL.setSelected(false);

                // Set the clicked button as selected
                v.setSelected(true);
            }
        };

        // Set the same listener to all buttons
        buttonS.setOnClickListener(sizeClickListener);
        buttonM.setOnClickListener(sizeClickListener);
        buttonL.setOnClickListener(sizeClickListener);
    }
}
