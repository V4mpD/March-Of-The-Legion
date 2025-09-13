package validation.rules;

public enum ArgumentAlgorithm {
    BUBBLESORT("b"),
    SELECTIONSORT("s"),
    QUICKSORT("q"),
    MERGESORT("m");

    char symbol;
    ArgumentAlgorithm(String symbol) {
        this.symbol =  symbol.toLowerCase().charAt(0);
    }

    public static boolean verifySymbol(char symbol) {
        return symbol == 'b' || symbol == 's' || symbol == 'q' || symbol == 'm';
    }

    public static String getNameBySymbol(char symbol) {
        return switch (symbol) {
            case 'b' -> "[BubbleSort]";
            case 's' -> "[SelectionSort]";
            case 'q' -> "[QuickSort]";
            case 'm' -> "[MergeSort]";
            default -> "[Invalid]";
        };
    }
}


