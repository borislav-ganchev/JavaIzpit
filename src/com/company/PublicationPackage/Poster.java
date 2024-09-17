package com.company.PublicationPackage;

import com.company.PaperPackage.PageSize;
import com.company.PaperPackage.Paper;
import com.company.PublicationPackage.Publication;

public class Poster extends Publication {
    private static final long serialVersionUID = 1L;
    private String designer;

    public Poster(String title, int numberOfPages, PageSize pageSize, double sellPrice, String designer) {
        super(title, numberOfPages, pageSize, sellPrice);
        this.designer = designer;
    }

    public String getDesigner() {
        return designer;
    }

    @Override
    public String toString() {
        return "Poster [designer=" + designer + ", " + super.toString() + "]";
    }
}