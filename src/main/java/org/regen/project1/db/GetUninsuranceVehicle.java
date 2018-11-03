package org.regen.project1.db;
import java.sql.*;

public class GetUninsuranceVehicle {
    private Connection conn;
    public GetUninsuranceVehicle(Connection dbConnection) {
            this.conn = dbConnection;
    }

    public int getUninsurancedVehicles(String last_name) throws SQLException {
        ResultSet rs= null;
        try {
            PreparedStatement preparedStatement = conn.prepareStatement("Select exp_date from Vehicle v, User u where  u.last_name=? and u.id=v.user_id");
            preparedStatement.setString(1, last_name);
            rs = preparedStatement.executeQuery();
        }catch (SQLException e) {
            System.err.println("Something wrong with the sql query!");
            System.exit(-1);
        }
        java.util.Date date = new java.util.Date();
        int count = 0;

        while (rs.next()) {
            Date rsex_date = rs.getDate("exp_date");
            if ((rsex_date.compareTo(date) == -1)) {
                count++;
            }
        }
        return count;
    }
}
