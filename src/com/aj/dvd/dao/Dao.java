package com.aj.dvd.dao;

import com.aj.dvd.dto.DVD;

import java.util.Collection;

public interface Dao {
    public void addDVD(DVD dvd)throws DaoException;
    public DVD removeDVD(String title) throws DaoException;
    public DVD editDVD(DVD dvd)throws DaoException;
    public Collection<String> listDVDs()throws DaoException;
    public DVD getDVDFromTitle (String title)throws DaoException;
}
