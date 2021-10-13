package com.aj.dvd.controller;

import com.aj.dvd.dao.Dao;
import com.aj.dvd.dao.DaoException;
import com.aj.dvd.dao.DaoFileImpl;
import com.aj.dvd.dto.DVD;
import com.aj.dvd.ui.View;

import java.util.Collection;


public class Controller {

    View view;
    Dao dao;

    public Controller(View view, Dao dao) {
        this.view = view;
        this.dao = dao;
    }

    public void run() {

        boolean whilstRunning = true;
        int userChoice;
        try {
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
                        whilstRunning = false;
                        exit();
                        break;
                    default:
                        System.out.println("default message");

                }
            }
        } catch (DaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    public void addDVD() throws DaoException {
        boolean adding = true;
        do {
            DVD newDVD = view.getNewDVD();
            dao.addDVD(newDVD);
            adding = view.addDVDSuccess();
        } while (adding);
    }

    public void removeDVD() throws DaoException{
        boolean removing = true;
        do {
            String title = view.getTitle();
            DVD exDVD = dao.removeDVD(title);
            removing = view.dvdRemoveMessage(exDVD);
        }
        while (removing);
    }

    public void editDVD() throws DaoException{
        String title = view.getTitle();
        DVD dvd = dao.getDVDFromTitle(title);
        DVD editedDVD = view.editDVD(dvd);
        dao.addDVD(editedDVD);
    }

    public void listDVDs() throws DaoException{
        Collection<String> dvds = dao.listDVDs();
        view.listDVDs(dvds);
    }

    public void displayDVD() throws DaoException{
        String title = view.getTitle();
        DVD dvd = dao.getDVDFromTitle(title);
        view.displayDVDInfo(dvd);
    }

    public void searchDVD() throws DaoException{
        String title = view.getTitle();
        DVD dvd = dao.getDVDFromTitle(title);
        view.dvdSearch(dvd);
    }

    public void exit() {
        view.exitingMessage();
    }
}
