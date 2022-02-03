package beans;

import exceptions.LineExceptions;
import exceptions.NonPositiveArgumentExceptions;

import java.util.Scanner;

public class Purchase {

    //Fields
    private final String name;
    private final Byn price;
    private final int number;

    //Constructors
    public Purchase() {
        this(null, new Byn(), 0);
    }

    public Purchase(String name, Byn price, int number) {
        if(price.compareTo(new Byn(0)) == 0 ) {
            throw new NonPositiveArgumentExceptions("WRONG VALUE IN PRICE", price.getValue());
        }
        if(name.isEmpty()) {
            throw new LineExceptions("EMPTY NAME", name);
        }
        if(number <= 0) {
            throw new NonPositiveArgumentExceptions("WRONG NUMBER PURCHASE", number);
        }
        this.name = name;
        this.price = price;
        this.number = number;
    }

    public Purchase(Scanner scanner) {
        this(scanner.next(), new Byn(scanner), scanner.nextInt());
    }

    public Purchase(String[] parameters) {
        this(parameters[0], new Byn(parameters[1]), Integer.parseInt(parameters[2]));
    }

    public String getName() {
        return name;
    }

    public Byn getPrice() {
        return price;
    }

    public int getNumber() {
        return number;
    }

    public Byn getCost() {
        return price.mull(number);
    }

    public String fieldsToString() {
        return Purchase.class.getSimpleName() + ";" + name + ";" + price + ";" + number;
    }

    @Override
    public String toString() {
        return fieldsToString() + fieldsToString() + ";" + getCost();
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() * price.hashCode() * number;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Purchase)) {
            return false;
        }
        Purchase purchase = (Purchase) obj;
        return price.equals(purchase.price) && name.equals(purchase.name);
    }
}
