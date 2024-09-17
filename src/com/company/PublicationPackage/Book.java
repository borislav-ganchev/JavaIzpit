package com.company.PublicationPackage;

import com.company.PaperPackage.PageSize;
import com.company.PaperPackage.Paper;
import com.company.PublicationPackage.Publication;

public class Book extends Publication {
    private static final long serialVersionUID = 1L;
    private String author;

    public Book(String title, int numberOfPages, PageSize pageSize,double sellPrice ,String author) {
        super(title, numberOfPages, pageSize, sellPrice);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", " + super.toString() + "]";
    }
}