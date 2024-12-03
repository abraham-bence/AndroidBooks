package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.details_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }


    public void init() {
        TextView titleTextView = findViewById(R.id.titleDetails);
        TextView authorTextView = findViewById(R.id.authorDetails);
        TextView pagesTextView = findViewById(R.id.pagesDetails);
        TextView yearTextView = findViewById(R.id.yearDetails);
        Button backButton = findViewById(R.id.back_button);

        String title = getIntent().getStringExtra("TITLE");
        String author = getIntent().getStringExtra("AUTHOR");
        String pages = getIntent().getStringExtra("PAGES");

        titleTextView.setText("Title: " + title);
        authorTextView.setText("Author: " + author);
        pagesTextView.setText("Pages: " + pages);

        Random random = new Random();
        yearTextView.setText("Year: " + (random.nextInt(2025-1900) + 1900) );

        backButton.setOnClickListener(v -> finish());
    }
}