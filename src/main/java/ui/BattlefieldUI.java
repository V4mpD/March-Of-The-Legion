package ui;

import entities.common.Grid;
import entities.units.CombatUnit;
import entities.units.Empty;
import ui.component.GridUI;
import ui.component.TroopUI;
import validation.ArgumentValidator;
import validation.rules.ArgumentAlgorithm;
import validation.rules.ArgumentOrientation;
import validation.rules.ArgumentType;
import validation.rules.ArgumentUnit;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BattlefieldUI extends JFrame {

    private int width;
    private int height;
    private ArgumentValidator argumentValidator;
    private List<Grid<CombatUnit>> grips;

    public BattlefieldUI() {
    }

    public BattlefieldUI(int sizeWindow, List<Grid<CombatUnit>> grips, ArgumentValidator argumentValidator) {
        this.width = sizeWindow;
        this.height = sizeWindow;
        this.argumentValidator = argumentValidator;
        this.grips = grips;

        int size = grips.get(grips.size()-1).getMatrix().get(0).size();

        // Initial Config
        setTitle("Battlefield");
        setSize(this.width, this.height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(new ImageIcon("src\\main\\resources\\static\\image\\icon\\battlefield-icon.png").getImage());

        // Instance JPanel
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#d4ec28"));
        panel.setLayout(null);

        insertTroopOnGridBlock(size, panel);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BattlefieldUI::new);
    }

    private void insertTroopOnGridBlock(int size, JPanel panel) {
        final int[] index = {0};
        Timer timer = new Timer(500, null);

        timer.addActionListener(e -> {
            if (index[0] < grips.size()) {
                if (panel.getComponentCount() > 0) {
                    panel.removeAll();
                }

                List<List<CombatUnit>> battlefield = grips.get(index[0]).getMatrix();

                GridUI gridUI = new GridUI(width - 70, height - 70, size, size);
                gridUI.setBounds(25, 35, width - 70, height - 70);

                JLabel text = new JLabel(
                        "Sorting: " + ArgumentAlgorithm.getNameBySymbol(argumentValidator.getAlgorithm()) + "  "
                        + "Type: " + ArgumentType.getNameBySymbol(argumentValidator.getType()) + "  "
                        + "Troops: " + ArgumentUnit.getValueUnit(argumentValidator.getUnits()) + "  "
                        + "Orientation: " + ArgumentOrientation.getNameBySymbol(argumentValidator.getOrientation()) + "  "
                        + "Size: " + "[" + argumentValidator.getFieldSize() + "]"
                );
                text.setFont(new Font("Segoe UI", Font.PLAIN, 12));
                text.setBounds(25, 5, 450, 30);


                int sizeTroop = gridUI.getWidth() / gridUI.getCol();

                for (int i = 0; i < gridUI.getRow(); i++) {
                    for (int j = 0; j < gridUI.getCol(); j++) {
                        CombatUnit typeTroop = null;

                        try {
                            typeTroop = battlefield.get(i).get(j);
                        }
                        catch (RuntimeException error) {
                            typeTroop = new Empty();
                        }

                        TroopUI troop = new TroopUI(
                                sizeTroop,
                                sizeTroop,
                                ArgumentOrientation.getNameBySymbol(argumentValidator.getOrientation()),
                                typeTroop
                        );

                        gridUI.add(troop);
                    }
                }

                panel.add(text);
                panel.add(gridUI);
                panel.revalidate();
                panel.repaint();

                index[0]++;
            } else {
                ((Timer) e.getSource()).stop();
            }
        });

        timer.start();
    }

}
