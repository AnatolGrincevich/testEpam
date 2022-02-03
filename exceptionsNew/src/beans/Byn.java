package beans;

import exceptions.NonPositiveArgumentExceptions;
import services.RoundMethod;

import java.util.Scanner;

public final class Byn implements Comparable<Byn>{

    //Fields
    private final int value;

    //Constructors
    public Byn() {
        this(0);
    }
    public Byn(int value) {
        if(value < 0) {
            throw new NonPositiveArgumentExceptions("WRONG BYN VALUE", value);
        }
        this.value = value;
    }

    public Byn(Scanner scanner) {
        this(scanner.nextInt());
    }

    public Byn(String stringValue) {
        this(Integer.parseInt(stringValue));
    }

    //getters()
    public int getValue() {
        return value;
    }

    //Arithmetic methods()
    public Byn add(Byn byn){
        return new Byn(this.value + byn.value);
    }

    public Byn sub(Byn byn) {
        return new Byn(this.value - byn.value);
    }

    public Byn mull(int value) {
        return new Byn(this.value * value);
    }

    public Byn mul(double k, RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value * k, d));
    }

    public Byn round(RoundMethod roundMethod, int d) {
        return new Byn(roundMethod.round(value, d));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Byn byn = (Byn) o;
        return value == byn.value;
    }

    @Override
    public int hashCode() {
        return 31 * value;
    }

    @Override
    public String toString() {
        return String.format("%d.%02d", value / 100, value % 100);
    }

    @Override
    public int compareTo(Byn o) {
        return value - o.value;
    }
}
