package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.HFrame;
import model.NodeModel;

public class EditorPanel extends JPanel{
    EditorPanel() {
        setLayout(null);
        setBackground(Color.WHITE);
        fileNameLabel = new JLabel("File Name");
        fileNameLabel.setFont(new Font("Ariel", Font.PLAIN,28));
        fileNameLabel.setBounds(5, 5,500,30);
        add(fileNameLabel);
        
        
    }
//    private class MyMouseListener extends MouseAdapter {
//        @Override
//        public void mouseMoved(MouseEvent e) {
//            if(item != null){
//                item.setLocation(e.getX()+1,e.getY()+1);
//                panel.add(item);
//                
//            }
//        }
//        @Override
//        public void mouseExited(MouseEvent e) {
//            if(item != null){
//                    panel.remove(item);
//                    panel.repaint();
//            }
//        }
////        public void mouseClicked(MouseEvent e) {
////            System.out.println(e.getX() + " " + e.getY());
////        }
//        
//    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(0, 40, this.getWidth(), 40);
    }
    public void setFrame(HFrame frame) {
        if(backgroundPanel!=null)
            remove(backgroundPanel);
        if(this.frame!=null){
            remove(this.frame);
        }
        this.frame = frame;
        backgroundPanel = new JPanel();
        backgroundPanel.setBounds(frame.getX()-2, frame.getY()-2, frame.getWidth()+4, frame.getHeight()+4);
        backgroundPanel.setBackground(Color.CYAN);
        add(frame);
        add(backgroundPanel);
        repaint();
        backgroundPanel.repaint();
        frame.setEditorPanel(this);
    }
    public HFrame getFrame() {
        return frame;        
    }
    public void setFileNameLabel(String text) {
        fileNameLabel.setText(text);
    }
    public String getFileNameLabel() {
        return fileNameLabel.getText();
    }
    public void setFile(File file) {
        this.file=file;
    }
    public File getFile() {
        return file;
    }

    public void makeItem(JLabel type) {
        if(type == null){
            item = null;
            type = null;
            frame.setFlag(false);
            return;
        }
        this.type=type;
        if(type.getText().equals("JLabel")) {
            frame.countName.plusLabelCnt();
            item = new JLabel("JLabel"+frame.countName.getLabelCnt());
        }
        else if(type.getText().equals("JButton")) {
            frame.countName.plusButtonCnt();
            item = new JButton("JButton"+frame.countName.getButtonCnt());
        }
        frame.setFlag(true);
    }
    public void addItem(Rectangle info) {
        item.setBounds(info);
        frame.add(item);
        type.setBackground(backGroundColor);
    }
    private Color backGroundColor = new Color(240,240,240);
    private JLabel fileNameLabel;
    private JPanel backgroundPanel;
    private HFrame frame;
    private File file;
    private JComponent item;
    private JLabel type;
}