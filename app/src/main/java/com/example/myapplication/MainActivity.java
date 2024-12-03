package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText titleInput;
    private EditText authorInput;
    private EditText pageInput;

    private Button addBtn;

    private List<Book> books;
    private ListView booksListView;
    private BooksAdapter adapter;

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
        init();

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString();
                String author = authorInput.getText().toString();
                String page = pageInput.getText().toString();

                if (title.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Title field must be filled", Toast.LENGTH_SHORT).show();
                }
                else if (author.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Author field must be filled", Toast.LENGTH_SHORT).show();
                }
                else if (page.isEmpty()) {
                    Toast.makeText(MainActivity.this,"Page field must be filled", Toast.LENGTH_SHORT).show();
                }
                else {
                    try {
                        int pageNumber = Integer.parseInt(page);
                        if (pageNumber > 50) {
                            books.add(new Book(title, author, pageNumber));
                            adapter.notifyDataSetChanged();
                            titleInput.setText("");
                            authorInput.setText("");
                            pageInput.setText("");
                        }
                        else {
                            Toast.makeText(MainActivity.this,"Page must be greater than 50", Toast.LENGTH_SHORT).show();
                        }

                    } catch (NumberFormatException e ) {
                        Toast.makeText(MainActivity.this,"Page must be a valid number", Toast.LENGTH_SHORT).show();

                    }

                }
            }
        });

    }
    public void init() {
        titleInput = findViewById(R.id.titleInput);
        authorInput = findViewById(R.id.authorInput);
        pageInput = findViewById(R.id.pageNumberInput);
        addBtn = findViewById(R.id.addBtn);
        booksListView = findViewById(R.id.booksListview);

        books = new ArrayList<>();

        books.add(new Book("Mindenkorra", "Bármi áron", 78));
        books.add(new Book("subidu", "Kandisz Nóra", 1231));
        books.add(new Book("Miakő" ,"Tyúkanyó",51));
        books.add(new Book("Petőfiről" ,"Toldi", 34534));


        adapter = new BooksAdapter(books, MainActivity.this);
        booksListView.setAdapter(adapter);
    }
}