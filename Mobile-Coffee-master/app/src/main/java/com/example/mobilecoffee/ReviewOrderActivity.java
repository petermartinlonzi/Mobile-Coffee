package com.example.mobilecoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewOrderActivity extends AppCompatActivity {

    TextView totalPrice, bottomTotal;
    Button placeOrderBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_order);

        totalPrice = findViewById(R.id.totalPrice);
        bottomTotal = findViewById(R.id.bottomTotal);
        placeOrderBtn = findViewById(R.id.placeOrderBtn);

        // Get data from intent
        String product = getIntent().getStringExtra("product");
        double price = getIntent().getDoubleExtra("price", 3.80);
        int quantity = getIntent().getIntExtra("quantity", 2);
        double total = price * quantity;

        totalPrice.setText("$" + String.format("%.2f", total));
        bottomTotal.setText("Total:\n$" + String.format("%.2f", total));

        placeOrderBtn.setOnClickListener(view ->
                Toast.makeText(this, "Order Placed Successfully!", Toast.LENGTH_LONG).show()
        );

        // Place Order button listener
        placeOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReviewOrderActivity.this, OrderConfirmationActivity.class);
                startActivity(intent);
                finish(); // Close ProductActivity
            }

            ;
        });

    }
}
