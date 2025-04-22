package com.example.mobilecoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    private Button buttonS, buttonM, buttonL;
    private Button placeOrderBtn;

    private String selectedSize = "S"; // default size
    private final String productName = "Cappuccino";
    private final double productPrice = 3.80;
    private final int quantity = 2; // you can make this dynamic

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Initialize buttons
        buttonS = findViewById(R.id.buttonS);
        buttonM = findViewById(R.id.buttonM);
        buttonL = findViewById(R.id.buttonL);
        placeOrderBtn = findViewById(R.id.placeOrderBtn); // Make sure this button exists in your XML

        // Size button listener
        View.OnClickListener sizeClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Deselect all first
                buttonS.setSelected(false);
                buttonM.setSelected(false);
                buttonL.setSelected(false);

                // Set selected
                v.setSelected(true);

                if (v == buttonS) {
                    selectedSize = "S";
                } else if (v == buttonM) {
                    selectedSize = "M";
                } else if (v == buttonL) {
                    selectedSize = "L";
                }
            }
        };

        buttonS.setOnClickListener(sizeClickListener);
        buttonM.setOnClickListener(sizeClickListener);
        buttonL.setOnClickListener(sizeClickListener);

        // Place order button click
        placeOrderBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ProductDetailsActivity.this, ReviewOrderActivity.class);
            intent.putExtra("product", productName);
            intent.putExtra("price", productPrice);
            intent.putExtra("quantity", quantity);
            intent.putExtra("size", selectedSize);
            startActivity(intent);
        });
    }
}
