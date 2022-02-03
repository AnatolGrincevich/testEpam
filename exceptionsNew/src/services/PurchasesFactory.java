package services;

import beans.PriceDiscountPurchase;
import beans.Purchase;
import exceptions.LineExceptions;

public class PurchasesFactory {

    public static final int PURCHASE_FIELDS_NUMBER = 3;
    public static final int DISCOUNT_PURCHASE_FIELDS_NUMBER = 4;

    private enum PurchaseKind{
        PURCHASE{
            @Override
            protected Purchase getPurchase(String[] parameters) {
                return new Purchase(parameters);
            }
        },
        DISCOUNT_PURCHASE{
            @Override
            protected Purchase getPurchase(String[] parameters) {
                return new PriceDiscountPurchase(parameters);
            }
        };

       abstract protected Purchase getPurchase(String[] parameters);
        }

    public static Purchase getPurchaseFromFactory(String data) {
        String[] parameters = data.split(";");
        if(parameters.length != PURCHASE_FIELDS_NUMBER && parameters.length != DISCOUNT_PURCHASE_FIELDS_NUMBER) {
            throw new LineExceptions("WRONG LINE FORMAT", data);
        }
        try {
            return PurchaseKind.values()[parameters.length - 3].getPurchase(parameters);
        } catch (IndexOutOfBoundsException e) {
            throw new LineExceptions("WRONG VALUE IN", data);
        } catch(RuntimeException e) {
            throw new LineExceptions("WRONG LINE FORMAT", data);
        }
    }
}
