package com.example.myapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class BooksAdapter extends BaseAdapter {

    private List<Book> books;
    private Context context;

    public BooksAdapter(List<Book> books, Context context) {
        this.books = books;
        this.context = context;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.book_item, viewGroup, false);

        TextView titleText =view.findViewById(R.id.titleText);
        TextView authorText = view.findViewById(R.id.authorText);
        TextView pagetext = view.findViewById(R.id.pageText);

        Book book = books.get(i);

        titleText.setText(book.getTitle());
        authorText.setText(book.getAuthor());
        pagetext.setText(String.valueOf(book.getPageNumber()));

        Button deleteBtn = view.findViewById(R.id.deleteBtn);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("TITLE", book.getTitle());
                intent.putExtra("AUTHOR", book.getAuthor());
                intent.putExtra("PAGES", String.valueOf(book.getPageNumber()));

                context.startActivity(intent);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete");
                builder.setMessage("Are you sure you want to delete this item?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        books.remove(i);
                        notifyDataSetChanged();

                    }
                });
                builder.setNegativeButton("No", null);
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


        return view;
    }
}
