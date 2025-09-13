package ui.component;

import entities.units.*;
import game.utils.RandomHelper;

import javax.swing.*;
import java.awt.*;

public class TroopUI extends JPanel {

    private int width;
    private int height;
    private CombatUnit combatUnit;
    private Image image;
    private String orientation;

    public TroopUI(int width, int height, String orientation, CombatUnit combatUnit) {
        this.width = width;
        this.height = height;
        this.combatUnit = combatUnit;
        this.orientation = orientation;
        this.image = new ImageIcon(pathImageCombatUnit()).getImage();
        setSize(width, height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.drawImage(image, 0, 0, width, height, this);
    }

    private String pathImageCombatUnit() {
        if (orientation.equals("[East]") || orientation.equals("[North]")) {
            return switch (combatUnit) {
                case Commander c -> "src\\main\\resources\\static\\image\\troops\\reverse\\commander.png";
                case Doctor d -> "src\\main\\resources\\static\\image\\troops\\reverse\\doctor.png";
                case Tank t -> "src\\main\\resources\\static\\image\\troops\\reverse\\tank.png";
                case Sniper s -> "src\\main\\resources\\static\\image\\troops\\reverse\\sniper.png";
                case Infantry i -> "src\\main\\resources\\static\\image\\troops\\reverse\\infantry.png";
                default -> {
                    int random = RandomHelper.getRandomIntBetween(1, 6);
                    yield String.format("src\\main\\resources\\static\\image\\troops\\empty-%d.png", random);
                }
            };
        }
        else {
            return switch (combatUnit) {
                case Commander c -> "src\\main\\resources\\static\\image\\troops\\commander.png";
                case Doctor d -> "src\\main\\resources\\static\\image\\troops\\doctor.png";
                case Tank t -> "src\\main\\resources\\static\\image\\troops\\tank.png";
                case Sniper s -> "src\\main\\resources\\static\\image\\troops\\sniper.png";
                case Infantry i -> "src\\main\\resources\\static\\image\\troops\\infantry.png";
                default -> {
                    int random = RandomHelper.getRandomIntBetween(1, 6);
                    yield String.format("src\\main\\resources\\static\\image\\troops\\empty-%d.png", random);
                }
            };
        }
    }

}
