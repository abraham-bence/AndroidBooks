package com.example.myapplication;

public class Book {
    private String title;
    private String author;
    private int pageNumber;

    public Book(String title, String author, int pageNumber) {
        this.title = title;
        this.author = author;
        this.pageNumber = pageNumber;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}

