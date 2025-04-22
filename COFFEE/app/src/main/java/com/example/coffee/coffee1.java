package com.example.coffee;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class coffee1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_coffee1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

    }

        public void displaySplash(){
            Thread myThread = new Thread(){
                @Override
                public void run(){
                    try {
                        int displayTime = 3000;
                        sleep(displayTime);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }finally {
                        Intent intent = new Intent(coffee1.this,coffee2.class);
                        startActivity(intent);
                        finish();
                    }
                }

            };
            myThread.start();

        }
}