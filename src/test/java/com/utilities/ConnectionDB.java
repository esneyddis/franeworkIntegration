package com.utilities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectionDB {
    private static Connection con = null;
    public static List<String> getQuery(String query) throws SQLException {
        //String Query="select top 10* from ev_call";
        con = ConnectionManager.getConnection();
        Statement St = con.createStatement();
        ResultSet rs = St.executeQuery(query);
        List<String> values = new ArrayList<String>();
        while (rs.next()) {
            values.add(rs.getString(1));
        }
        return values;
    }
}
