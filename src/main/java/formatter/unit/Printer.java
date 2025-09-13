package formatter.unit;

public interface Printer<T> {
    String format(T text);
    default String spacing(T unit) {
        return "    ";
    }
}
