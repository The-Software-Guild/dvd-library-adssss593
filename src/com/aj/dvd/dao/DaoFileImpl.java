package com.aj.dvd.dao;

import com.aj.dvd.dto.DVD;

import java.io.*;
import java.util.*;

import static java.lang.System.out;

public class DaoFileImpl implements Dao{

    Map<String, DVD> DVDs = new HashMap<>();
    public static final String DELIMITER = "::";
    public static final String FILE = "dvds.txt";

    @Override
    public void addDVD(DVD dvd) throws DaoException{
        readData();
        DVDs.put(dvd.getTitle(),dvd);
        writeData();
    }

    @Override
    public DVD removeDVD (String title) throws DaoException{
      readData();
      DVD exDVD = DVDs.remove(title);
      writeData();
      return exDVD;
    }

    @Override
    public DVD editDVD(DVD dvd) throws DaoException {

        return null;
    }

    @Override
    public Collection<String> listDVDs ()throws DaoException{//coded with relation to the interface
        readData();
        return DVDs.keySet();
    }

    @Override
    public DVD getDVDFromTitle(String title) throws DaoException{
        readData();
        return DVDs.get(title);
    }

    public DVD unMarshall(String dvdString) {
        String[] elements = dvdString.split(DELIMITER,-2);
        DVD dvd = new DVD(elements[0]);
        dvd.setReleaseData(elements[1]);
        dvd.setmPPARating(elements[2]);
        dvd.setDirector(elements[3]);
        dvd.setStudio(elements[4]);
        dvd.setUserNote(elements[5]);
        return dvd;
    }

    public void readData() throws DaoException{
        Scanner scanner = null;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(FILE)));
        } catch (FileNotFoundException e) {
            throw new DaoException("Could not find file");
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            DVD newDVD = unMarshall(line);
            DVDs.put(newDVD.getTitle(),newDVD);
        }

    }

    public String marshall(DVD dvd) {
        String dvdAsText =
                dvd.getTitle() + DELIMITER
                + dvd.getReleaseDate() + DELIMITER
                + dvd.getmPPARating() + DELIMITER
                + dvd.getDirector() + DELIMITER
                + dvd.getStudio() + DELIMITER
                + dvd.getUserNote();
        return dvdAsText;
    }

    public void writeData () throws DaoException {
        PrintWriter writer;
        try {
            writer = new PrintWriter(new FileWriter(FILE));
        }catch (IOException e) {
            throw new DaoException("Could not save data");
        }
        Collection<String> allDVDs = listDVDs();
        for (String dvd: allDVDs) {
            String student = marshall(DVDs.get(dvd));
            writer.println(student);
            writer.flush();
        }
        writer.close();
    }
}
