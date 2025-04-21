package com.example.mobilecoffee;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ImageView cappuccinoImage; // Declare the ImageView for Cappuccino

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initialize Bottom Navigation View
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set listener for bottom navigation items
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.nav_favorite) {
                Toast.makeText(this, "Favorite clicked", Toast.LENGTH_SHORT).show();
                return true;
            } else if (id == R.id.nav_profile) {
                Toast.makeText(this, "Profile clicked", Toast.LENGTH_SHORT).show();
                return true;
            }

            return false;
        });

        // Initialize the Cappuccino image view
        cappuccinoImage = findViewById(R.id.productImage); // Replace with the correct ID if necessary

        // Set click listener on the image
        cappuccinoImage.setOnClickListener(v -> {
            // When the image is clicked, navigate to the product details page
            Intent intent = new Intent(DashboardActivity.this, ProductDetailsActivity.class);
            startActivity(intent); // Start the ProductDetailsActivity
        });
    }
}
