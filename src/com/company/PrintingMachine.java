package com.company;

import com.company.PaperPackage.Paper;
import com.company.PublicationPackage.Publication;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class PrintingMachine implements Serializable {
    private static final long serialVersionUID = 1L;
    private boolean supportsColor;
    private boolean supportsBlackAndWhite;
    private int pagesPerMinute;
    private int loadedPaper;
    private Map<Publication, Integer> printedPublications = new HashMap<>();
    private int totalPagesPrinted = 0;

    public Map<Publication, Integer> getPrintedPublications() {
        return printedPublications;
    }

    public PrintingMachine(boolean supportsColor, boolean supportsBlackAndWhite, int pagesPerMinute) {
        this.supportsColor = supportsColor;
        this.supportsBlackAndWhite = supportsBlackAndWhite;
        this.pagesPerMinute = pagesPerMinute;
    }

    public void loadPaper(int paper) {
        this.loadedPaper = paper;
    }

    public void print(Publication publication, boolean color ) {
        if (loadedPaper <= 0) {
            throw new IllegalStateException("No paper loaded in the printing machine.");
        }

        if ((color && !supportsColor) || (!color && !supportsBlackAndWhite)) {
            throw new UnsupportedOperationException("Printing machine does not support the requested printing variant.");
        }
        loadedPaper -= publication.getNumberOfPages();
        totalPagesPrinted += publication.getNumberOfPages();
        printedPublications.put(publication, printedPublications.getOrDefault(publication, 0) + 1);
        System.out.println("Publication " + publication + " has been printed");
    }

    public int getTotalPagesPrinted(){return totalPagesPrinted;}

    @Override
    public String toString() {
        return "PrintingMachine [supportsColor=" + supportsColor + ", supportsBlackAndWhite=" + supportsBlackAndWhite +
                ", pagesPerMinute=" + pagesPerMinute + "]";
    }
}