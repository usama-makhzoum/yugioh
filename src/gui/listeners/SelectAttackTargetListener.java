package gui.listeners;

import gui.GUI;
import gui.MonsterButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class SelectAttackTargetListener extends MouseAdapter{
    private MonsterButton monsterButton;
    private GUI gui;

    public SelectAttackTargetListener(MonsterButton addedMonsterButton, GUI addedGUI){
        monsterButton = addedMonsterButton;
        gui = addedGUI;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        ArrayList<MonsterButton> monstersOnField = gui.getOpponentPlayer().getFieldPanel().getMonsterCardsOnField();
        if(!monsterButton.isHighlighted()){
            for (int i = 0; i < monstersOnField.size(); i++) {
                monstersOnField.get(i).setBorder(BorderFactory.createEmptyBorder());
                monstersOnField.get(i).setHighlighted(false);
            }
            monsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
            monsterButton.setHighlighted(true);
            gui.setMonsterTarget(monsterButton);
        }
        else {
            monsterButton.setBorder(BorderFactory.createEmptyBorder());
            monsterButton.setHighlighted(false);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(!monsterButton.isHighlighted()) {
            monsterButton.setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.RED));
        }
    }

    @Override
    public void mouseExited(MouseEvent e){
        if(!monsterButton.isHighlighted()) {
            monsterButton.setBorder(BorderFactory.createEmptyBorder());
        }
    }
}
