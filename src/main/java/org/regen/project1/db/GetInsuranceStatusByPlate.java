package org.regen.project1.db;
import java.sql.*;

public class GetInsuranceStatusByPlate {
    private Connection conn;
    private Date expDate = null;

    public GetInsuranceStatusByPlate(Connection dbConnection) throws Exception {
        this.conn = dbConnection;
    }

    public void SqlQuery(String plate) {
        String query = "Select exp_date from vehicle where plate=?";

        try (PreparedStatement preparedStatement = conn.prepareStatement(query)) {
            preparedStatement.setString(1, plate);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                expDate = rs.getDate("exp_date");

            } else {
                System.err.println("No result !!!");
                System.exit(0);
            }
        } catch (SQLException e) {
            System.err.println("Something went wrong with the SQL");
            System.exit(-1);
        }
    }

    public Date getExpDate() {
        return expDate;
    }

}



