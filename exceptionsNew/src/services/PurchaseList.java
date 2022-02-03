package services;

import beans.Purchase;
import exceptions.LineExceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class PurchaseList {

    private final List<Purchase> purchaseList;
    private final boolean isSorted;

    public PurchaseList() {
        purchaseList = new ArrayList<>();
        isSorted = false;
    }

    public int size() {
        return purchaseList.size();
    }

    public List<Purchase> getPurchaseList() {
        return purchaseList;
    }

    public PurchaseList(String fileName) {
        this();
        try (Scanner scanner = new Scanner(new FileReader(fileName))) {
            while (scanner.hasNextLine()) {
                try {
                    Purchase purchase = PurchasesFactory.getPurchaseFromFactory(scanner.nextLine());
                    purchaseList.add(purchase);
                } catch (RuntimeException e) {
                    System.err.println(e);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println();
        }


    }
}
