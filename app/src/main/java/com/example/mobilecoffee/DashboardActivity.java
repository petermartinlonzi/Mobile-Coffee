package com.example.mobilecoffee;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DashboardActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Bottom Navigation setup
        bottomNavigationView = findViewById(R.id.bottom_navigation);
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

        // Handle click on Cappuccino With Oat Milk card
        LinearLayout cappuccinoLayout = findViewById(R.id.cappuccinoLayout);
        cappuccinoLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate to ProductDetailsActivity
                Intent intent = new Intent(DashboardActivity.this, ProductDetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
