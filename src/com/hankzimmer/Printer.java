package com.hankzimmer;

public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean isDuplex;

    //Constructor for duplex choice
    public Printer(boolean isDuplex) {
        this(100, 0, isDuplex);
    }

    //Constructor
    public Printer(int tonerLevel, int pagesPrinted, boolean isDuplex) {
        if (tonerLevel > -1 && tonerLevel <= 100) {
            this.tonerLevel = tonerLevel;
        } else {
            this.tonerLevel = -1;
        }
        this.pagesPrinted = pagesPrinted;
        this.isDuplex = isDuplex;
    }

    //Method for adding toner
    public int addToner(int tonerAmount) {
        //Only add toner if the current level is valid
        if (tonerLevel >= 0 && tonerLevel < 100) {
            //Don't allow overfilling
            if (tonerLevel + tonerAmount > 100) {
                return -1;
            }
            //Add toner
            tonerLevel += tonerAmount;
            System.out.println("Added " + tonerAmount + " toner. Toner level is " + tonerLevel + "%.");
            return tonerLevel;
        } else {
            return -1;
        }
    }

    public void printPages(int pages) {
        tonerLevel -= pages;
        if (isDuplex) {
            pages = (pages / 2) + (pages % 2);
            System.out.println("Printing in duplex mode");
        }
        this.pagesPrinted += pages;
        System.out.println("Printed " + pages + " pages. Pages printed: " + pagesPrinted + ". Toner level is " + tonerLevel + "%.");
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public boolean isDuplex() {
        return isDuplex;
    }
}
