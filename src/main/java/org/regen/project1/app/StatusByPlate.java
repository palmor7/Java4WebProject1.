package org.regen.project1.app;
import org.regen.project1.db.GetInsuranceStatusByPlate;
import java.sql.Date;

public class StatusByPlate {
    private String plate;
    private GetInsuranceStatusByPlate getInsuranceStatusByPlate;

    public StatusByPlate(GetInsuranceStatusByPlate getInsuranceStatusByPlate) {
        this.getInsuranceStatusByPlate = getInsuranceStatusByPlate;
    }

    public void getStatus() {
        getInsuranceStatusByPlate.SqlQuery(plate);
        Date expDate = getInsuranceStatusByPlate.getExpDate();
        java.util.Date currdate = new java.util.Date();
        if (expDate.compareTo(currdate) == -1) {
            System.out.println("Expired at: " + expDate);
        } else {
            System.out.println("The insurance will expire at: " + expDate);
        }
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }
}
