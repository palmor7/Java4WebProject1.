package org.regen.project1.ui;
import org.regen.project1.app.FineCalculation;
import org.regen.project1.app.ForecomingExpiries;
import org.regen.project1.app.StatusByPlate;
import org.regen.project1.app.OrderedPlates;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private int num;
    private StatusByPlate statusByPlate;
    private FineCalculation fineCalculation;
    private ForecomingExpiries forecomingExpiries;
    private OrderedPlates orderedPlates;

    public Menu(FineCalculation fineCalculation, StatusByPlate statusByPlate, ForecomingExpiries forecomingExpiries, OrderedPlates orderedPlates) {
        this.fineCalculation = fineCalculation;
        this.statusByPlate = statusByPlate;
        this.forecomingExpiries = forecomingExpiries;
        this.orderedPlates = orderedPlates;
    }

    public void start() throws Exception {
        System.out.println("<--- Welcome to the vehicle’s insurance --->\n");
        System.out.println("Select functionality to perform:");
        System.out.println("Press 1 for vehicle insurance status");
        System.out.println("Press 2 for forecoming expiries");
        System.out.println("Press 3 for fine calculation");
        System.out.println("Press 0 for exit");
        try {
            Scanner scanner = new Scanner(System.in);
            num = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Non acceptable input!");
            System.exit(-1);
        }
        switch (num) {
            case 1:
                System.out.println("Vehicle insurance status");
                System.out.println("Give vehicle’s plate!");
                Scanner scanner = new Scanner(System.in);
                String givenPlate = scanner.nextLine();

                while (!givenPlate.matches("[A-Z]{3}-[0-9]{4}")) {
                    System.out.println("Wrong format. Please use the ‘ABC-1234’ format ");
                    givenPlate = scanner.nextLine();
                }
                statusByPlate.setPlate(givenPlate);
                statusByPlate.getStatus();
                break;
            case 2:
                System.out.println("Forecoming expiries");
                System.out.println("Give days to check the upcoming expires!");
                try {
                    scanner = new Scanner(System.in);
                    int days = scanner.nextInt();
                    forecomingExpiries.setDays(days);
                    //
                    System.out.println("Do you want it in alphanumerical order? (y/n)");
                    scanner = new Scanner(System.in);
                    String orderChoice = scanner.nextLine();
                    while (!orderChoice.matches("[y,n]")) {
                        System.out.println("Wrong input. Please enter (y/n) ");
                        orderChoice = scanner.nextLine();
                    }
                    orderedPlates.setOrderChoice(orderChoice);
                    System.out.println("Press 1 for console.\nPress 2 for File format.");
                    int input = scanner.nextInt();
                    forecomingExpiries.selectOutput(input);
                    break;
                } catch (InputMismatchException e) {
                    System.err.println("Non acceptable input!");
                    System.exit(-1);
                }
            case 3:
                System.out.println("Fine calculation");
                System.out.println("Give the last name");
                scanner = new Scanner(System.in);
                String lastName = scanner.nextLine();
                fineCalculation.setLastName(lastName);
                System.out.println("Give the fine per car");
                int fine = scanner.nextInt();
                fineCalculation.setFine(fine);
                System.out.println(fineCalculation.finePrice());
                break;
            case 0:
                System.out.println("Bye bye !!!");
                break;
            default:
                System.err.println("Non acceptable input!");
                System.exit(-1);
        }
    }
}
