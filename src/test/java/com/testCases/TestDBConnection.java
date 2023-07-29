package com.testCases;

import com.api.AbstractTest;
import com.utilities.ConnectionDB;

import java.sql.SQLException;
import java.util.List;

public class TestDBConnection extends AbstractTest {

    public static void main(String[] args) throws SQLException {
       List<String> test = ConnectionDB.getQuery(getProperties("select.by.id"));
        System.out.println("test.get(0) = " + test.get(0));
    }
}
