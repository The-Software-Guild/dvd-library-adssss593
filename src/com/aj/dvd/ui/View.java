package com.aj.dvd.ui;

public class View {
    UserIO io = new UserIOConsoleImpl();

    public void displayMenu() {
        System.out.println(
                "1.Add a DVD\n" + //multiple at same time
                "2.Remove a DVD\n" +//""
                "3.Edit a DVD's info\n" + //""
                "4.List all DVDs\n" +
                "5.Display a DVD's info\n" +
                "6.Search for a DVD\n" +
                "7.Load a DVD\n" +
                "8.Exit");
    }

    public int getUserChoice () {
        return io.readInt("Please choose an option",1,8);
    }

}
