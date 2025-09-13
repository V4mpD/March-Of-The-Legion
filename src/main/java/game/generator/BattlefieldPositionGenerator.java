package game.generator;

import game.utils.RandomHelper;

import java.util.*;

public class BattlefieldPositionGenerator {
    public static List<Integer[]> generateUniquePositions(int sizeRow, int sizeCol, int qtdPositions) {
        Boolean isSizeValid = ((sizeRow * sizeCol) >= qtdPositions);

        if (!isSizeValid) {
            throw new IllegalArgumentException("Invalid size row, col or qtd positions");
        }

        Set<Integer[]> positions = new HashSet<>();

        while (positions.size() < qtdPositions) {
            Integer[] position = {
                    RandomHelper.getRandomIntBetween(0, sizeRow - 1),
                    RandomHelper.getRandomIntBetween(0, sizeCol - 1),
            };

            Boolean anyValueIsRepeat = positions.stream()
                    .anyMatch(existing -> Arrays.equals(existing, position));

            if (!anyValueIsRepeat) {
                positions.add(position);
            }
        }

        return new ArrayList<>(positions);
    }
}
