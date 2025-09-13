package ui.component;

import javax.swing.*;
import java.awt.*;

public class GridUI extends JPanel {

    private int row;
    private int col;

    public GridUI(int width, int height, int row, int col) {
        this.row = row;
        this.col = col;
        setPreferredSize(new Dimension(width, height));
        setLayout(new GridLayout(row, col));
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.decode("#d4ec28"));
        g.fillRect(0, 0, getWidth(), getHeight());
    }
}
