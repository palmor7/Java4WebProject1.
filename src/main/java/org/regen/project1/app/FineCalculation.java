package org.regen.project1.app;
import org.regen.project1.db.GetUninsuranceVehicle;
import java.sql.SQLException;

public class FineCalculation {
    private String lastName;
    private int fine;
    GetUninsuranceVehicle getUninsuranceVehicle;

    public FineCalculation(GetUninsuranceVehicle getUninsuranceVehicle) {
        this.getUninsuranceVehicle = getUninsuranceVehicle;
    }

    public int finePrice() throws SQLException {
        int totalFine;
        int veh = getUninsuranceVehicle.getUninsurancedVehicles(lastName);
        if (veh == 0) {
             totalFine=0;
        } else {
            totalFine = this.fine * veh;
        }
        return totalFine;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}
