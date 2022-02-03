package exceptions;

public class NonPositiveArgumentExceptions extends IllegalArgumentException{
    private final int value;

    public NonPositiveArgumentExceptions(int value) {
        this.value = value;
    }

    public NonPositiveArgumentExceptions(String s, int value) {
        super(s);
        this.value = value;
    }

    public NonPositiveArgumentExceptions(String message, Throwable cause, int value) {
        super(message, cause);
        this.value = value;
    }

    public NonPositiveArgumentExceptions(Throwable cause, int value) {
        super(cause);
        this.value = value;
    }
}
