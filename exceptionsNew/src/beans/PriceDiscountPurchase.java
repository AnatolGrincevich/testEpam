package beans;

import exceptions.NonPositiveArgumentExceptions;

import java.util.Scanner;

public class PriceDiscountPurchase extends Purchase{

    //Fields
    private final Byn discount;

    public PriceDiscountPurchase(Byn discount) {
        this.discount = discount;
    }

    //Constructors
    public PriceDiscountPurchase(String name, Byn price, int number, Byn discount) {
        super(name, price, number);
        if(price.compareTo(discount) <= 0) {
            throw new NonPositiveArgumentExceptions("WRONG VALUE IN FIELD DISCOUNT", discount.getValue());
        }
        this.discount = discount;
    }

    public PriceDiscountPurchase(String[] parameters) {
        super(parameters);
        Byn discount = new Byn(Integer.parseInt(parameters[3]));
        if(super.getPrice().compareTo(discount) <= 0) {
            throw new NonPositiveArgumentExceptions("WRONG VALUE IN FIELD DISCOUNT", discount.getValue());
        }
        this.discount = new Byn(parameters[3]);
    }

    @Override
    public Byn getCost() {
        return super.getCost().sub(discount.mull(getNumber()));
    }

    @Override
    public String fieldsToString() {
        return super.fieldsToString() + ";" + discount;
    }

    @Override
    public int hashCode() {
        return super.hashCode() * discount.hashCode();
    }
}
