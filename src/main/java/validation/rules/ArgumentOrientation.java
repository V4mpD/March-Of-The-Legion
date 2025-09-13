package validation.rules;

public enum ArgumentOrientation {
    NORTH("n"),
    SOUTH("s"),
    EAST("e"),
    WEST("w");

    char symbol;

    ArgumentOrientation(String symbol) {
        this.symbol =  symbol.toLowerCase().charAt(0);
    }

    public static boolean verifySymbol(char symbol) {
        return symbol == 'n' || symbol == 's' || symbol == 'e' || symbol == 'w';
    }

    public static String getNameBySymbol(char symbol) {
        return switch (symbol) {
            case 'n' -> "[North]";
            case 's' -> "[South]";
            case 'e' -> "[East]";
            case 'w' -> "[West]";
            default -> "[Invalid]";
        };
    }

}
