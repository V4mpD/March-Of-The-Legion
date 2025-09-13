package entities.common;

import java.util.List;

public class Grid<T> {

    private List<List<T>> matrix;

    public Grid(List<List<T>> matrix) {
        this.matrix = matrix;
    }

    public List<List<T>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<T>> matrix) {
        this.matrix = matrix;
    }

}
