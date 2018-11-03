package org.regen.project1.db;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class GetForecomingExpiries {

    private Connection conn;
    private ArrayList<String> Plates = new ArrayList<String>();

    public GetForecomingExpiries(Connection conn) {
        this.conn = conn;
    }

    public ArrayList<String> getForecomingExpPlate(int days) throws SQLException{
        Date nextDay = convertToDateViaSqlDate(LocalDate.now().plusDays(days));
        java.util.Date date = new java.util.Date();
        PreparedStatement preparedStatement = conn.prepareStatement("Select plate, exp_date from vehicle");
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            String rsPlate = rs.getString("plate");
            Date rsExpDate = rs.getDate("exp_date");
            if ((rsExpDate.compareTo(date) == 1) && (rsExpDate.compareTo(nextDay) == -1)) {
                Plates.add(rsPlate);
            }
        }
        preparedStatement.close();
        return Plates;
    }
        private Date convertToDateViaSqlDate (LocalDate dateToConvert){
            return Date.valueOf(dateToConvert);
        }
}





