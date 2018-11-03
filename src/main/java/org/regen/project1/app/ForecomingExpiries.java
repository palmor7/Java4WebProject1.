package org.regen.project1.app;
import org.regen.project1.db.GetForecomingExpiries;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class ForecomingExpiries {
    private GetForecomingExpiries getforecomingexpiries;
    private OrderedPlates orderedPlates;
    private ArrayList<String> plates;
    private int days;

    public ForecomingExpiries(GetForecomingExpiries getforecomingexpiries, OrderedPlates orderedPlates){
        this.getforecomingexpiries = getforecomingexpiries;
        this.plates = new ArrayList<>();
        this.orderedPlates = orderedPlates;
    }

    public void setPlates(ArrayList<String> plates) {
            this.plates = plates;
    }

    public void selectOutput(int choice){
        try {
            setPlates(orderedPlates.getOrderedPlates(getforecomingexpiries.getForecomingExpPlate(days)));
        } catch (SQLException e) {
            System.err.println("Something went wrong with SQL query");
            System.exit(-1);
        }
        switch (choice){
            case 1:
                System.out.println("<----- Forecoming_expiries ----->");
                plates.forEach((value) -> System.out.println(value));
                System.out.println("\n"+ plates.size()+" Results");
                break;
            case 2:
                try {
                    writeFile(this.plates);
                } catch (IOException e) {
                    System.err.println("Something went wrong with the file writer");
                    System.exit(-1);
                }
                break;
        }
    }

    private void writeFile(ArrayList<String> Plates) throws IOException {
        FileWriter fileWriter = new FileWriter("forecoming_expiries.csv");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.printf("<----- Forecoming_expiries ----->\n");
        Plates.forEach((value) -> printWriter.printf(value + ","));
        printWriter.printf("\n"+Plates.size()+" Results");

        printWriter.close();
    }

    public void setDays(int days) {
        this.days = days;
    }

}
