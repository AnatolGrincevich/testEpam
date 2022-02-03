package exceptions;

public class LineExceptions extends IllegalArgumentException{

    private final String line;

    public LineExceptions(String line) {
        this.line = line;
    }

    public LineExceptions(String s, String line) {
        super(s);
        this.line = line;
    }

    public LineExceptions(String message, Throwable cause, String line) {
        super(message, cause);
        this.line = line;
    }

    public LineExceptions(Throwable cause, String line) {
        super(cause);
        this.line = line;
    }

    @Override
    public String toString() {
        return line + "-->" + getMessage();
    }
}
