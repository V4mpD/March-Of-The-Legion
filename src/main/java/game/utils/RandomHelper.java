package game.utils;

public class RandomHelper {

    public static Integer getRandomIntBetween(Integer min, Integer max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

    public static Integer[] getTwoRandomIntsBetween(Integer min, Integer max) {
        Integer[] values = new Integer[2];
        values[0] = getRandomIntBetween(min, max);
        values[1] = getRandomIntBetween(min, max);
        return values;
    }

}
