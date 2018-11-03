package org.regen.project1.app;
import java.util.ArrayList;
import java.util.Collections;

public class OrderedPlates {
    private String orderChoice;

    public ArrayList<String> getOrderedPlates(ArrayList<String> arrayList) {
        switch (orderChoice){
            case "y":
                Collections.sort(arrayList);
                System.out.println("Sorted!!!");
                break;
            case "n":
                Collections.shuffle(arrayList);
                break;
            default:
                break;
        }
        return arrayList;
    }

    public void setOrderChoice(String orderChoice){
        this.orderChoice = orderChoice;
    }
}

