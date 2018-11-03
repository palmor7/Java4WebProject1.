import org.regen.project1.app.FineCalculation;
import org.regen.project1.app.ForecomingExpiries;
import org.regen.project1.app.OrderedPlates;
import org.regen.project1.app.StatusByPlate;
import org.regen.project1.db.DBConnection;
import org.regen.project1.db.GetForecomingExpiries;
import org.regen.project1.db.GetInsuranceStatusByPlate;
import org.regen.project1.db.GetUninsuranceVehicle;
import org.regen.project1.ui.Menu;
import java.sql.Connection;

public class main {
    public static void main(String[] args) throws Exception {
        DBConnection dbConnection = new DBConnection();
        Connection connection= dbConnection.getDBConnection();
        GetUninsuranceVehicle getUninsuranceVehicle = new GetUninsuranceVehicle(connection);
        FineCalculation fineCalculation = new FineCalculation(getUninsuranceVehicle);
        GetInsuranceStatusByPlate getInsuranceStatusByPlate = new GetInsuranceStatusByPlate(connection);
        StatusByPlate statusByPlate = new StatusByPlate(getInsuranceStatusByPlate);
        GetForecomingExpiries getForecomingExpiries = new GetForecomingExpiries(connection);
        OrderedPlates orderedPlates = new OrderedPlates();
        ForecomingExpiries forecomingexpiries =new ForecomingExpiries(getForecomingExpiries, orderedPlates);

        Menu menu = new Menu(fineCalculation, statusByPlate, forecomingexpiries, orderedPlates);
        menu.start();
        dbConnection.closeDBConnection();
    }
}
