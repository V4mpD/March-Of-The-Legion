package game.utils;

import java.util.ArrayList;
import java.util.List;

public class ListMatrixConverter {

    public static <T> List<T> toList(List<List<T>> matrix) {
        List<T> list = new ArrayList<>();
        for (int i = 0; i < matrix.size(); i++) {
            List<T> row = matrix.get(i);
            for (int j = 0; j < row.size(); j++) {
                list.add(row.get(j));
            }
        }
        return list;
    }

    public static <T> List<List<T>> toMatrix(List<T> list, Integer numCol) {
        List<List<T>> matrix = new ArrayList<>();
        int total = list.size();
        int i = 0;

        while (i < total) {
            int end = Math.min(i + numCol, total);
            List<T> row = new ArrayList<>(list.subList(i, end));
            matrix.add(row);
            i += numCol;
        }

        return matrix;
    }
}
