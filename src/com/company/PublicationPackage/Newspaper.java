package com.company.PublicationPackage;

import com.company.PaperPackage.PageSize;
import com.company.PaperPackage.Paper;
import com.company.PublicationPackage.Publication;

public class Newspaper extends Publication {
    private static final long serialVersionUID = 1L;
    private String editor;

    public Newspaper(String title, int numberOfPages, PageSize pageSize, double sellPrice, String editor) {
        super(title, numberOfPages, pageSize, sellPrice);
        this.editor = editor;
    }

    public String getEditor() {
        return editor;
    }

    @Override
    public String toString() {
        return "Newspaper [editor=" + editor + ", " + super.toString() + "]";
    }
}
