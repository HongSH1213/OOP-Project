package view;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

import model.HFrame;

public class ItemKeyListener extends KeyAdapter {

    public void setPanel(EditorPanel editor, PropertiesPanel properties) {
        editorPanel = editor;
        propertiesPanel = properties;
    }
 
    public void keyReleased(KeyEvent e) {
        JComponent temp = (JComponent) e.getSource();
        HFrame frame = (HFrame) editorPanel.getFrame();
        if (e.getKeyCode() == KeyEvent.VK_DELETE) {
            frame.remove(temp);
            frame.repaint();
            // properties창 초기화
            propertiesPanel.setProperties(null);
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            temp.setBorder(null);
            if (temp.getClass().getSimpleName().equals("JButton"))
                temp.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            frame.repaint();
            editorPanel.setSelectedItem(null);
            // properties창 초기화
            propertiesPanel.setProperties(null);
        }

    }
    
    private PropertiesPanel propertiesPanel;
    private EditorPanel editorPanel;
}
