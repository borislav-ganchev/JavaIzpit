package com.company.PublicationPackage;

import com.company.PaperPackage.PageSize;
import com.company.PaperPackage.Paper;

import java.io.Serializable;

public abstract class Publication implements Serializable {
    private static final long serialVersionUID = 1L;
    private String title;
    private int numberOfPages;
    private PageSize pageSize;
    private double sellPrice;


    public Publication(String title, int numberOfPages, PageSize pageSize, double sellPrice) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.pageSize = pageSize;
        this.sellPrice = sellPrice;
    }

    public double getSellPrice() {
        return  sellPrice;
    }

    public String getTitle() {
        return title;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public PageSize getPageSize() {
        return pageSize;
    }



    @Override
    public String toString() {
        return "Publication [title=" + title + ", numberOfPages=" + numberOfPages + ", pageSize=" + pageSize + " ]";
    }
}