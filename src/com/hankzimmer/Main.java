package com.hankzimmer;

public class Main {

    public static void main(String[] args) {
        Printer printer = new Printer(true);

        printer.printPages(5);
        printer.printPages(60);
        printer.addToner(20);
    }
}
