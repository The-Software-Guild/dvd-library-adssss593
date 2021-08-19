package com.aj.dvd.controller;

import com.aj.dvd.ui.View;

public class Controller {

    View view = new View();

    public void run() {

        boolean whilstRunning = true;
        int userChoice;
        while (whilstRunning) {
            view.displayMenu();
            userChoice = view.getUserChoice();

            switch (userChoice) {
                case 1:
                    addDVD();
                    break;
                case 2:
                    removeDVD();
                    break;
                case 3:
                    editDVD();
                    break;
                case 4:
                    listDVDs();
                    break;
                case 5:
                    displayDVD();
                    break;
                case 6:
                    searchDVD();
                    break;
                case 7:
                    loadDVD();
                    break;
                case 8:
                    whilstRunning = false;
                    exit();
                    break;
                default:
                    System.out.println("default message");

            }
        }
    }

    public void addDVD() {
        System.out.println("adding...");
    }

    public void removeDVD() {
        System.out.println("removing...");
    }

    public void editDVD() {
        System.out.println("editing...");
    }

    public void listDVDs() {
        System.out.println("listing...");
    }

    public void displayDVD() {
        System.out.println("displaying...");
    }

    public void searchDVD() {
        System.out.println("searching...");
    }

    public void loadDVD() {
        System.out.println("loading...");
    }

    public void exit() {
        System.out.println("exiting...");
    }

}
