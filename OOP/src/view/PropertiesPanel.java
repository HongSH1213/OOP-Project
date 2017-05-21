package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PropertiesPanel extends JPanel{
    public PropertiesPanel() {
        Font defaultFont = new Font("Nirmala UI Semilight",Font.PLAIN,30);
        setLayout(new GridLayout(7,2,0,5));
        typeLabel = new JLabel("type :");
        typeLabel.setFont(defaultFont);
        typeBox = new JComboBox();
        nameLabel = new JLabel("name :");
        nameLabel.setFont(defaultFont);
        nameTextField = new JTextField();
        nameTextField.setEnabled(false);
        textLabel = new JLabel("text :");
        textLabel.setFont(defaultFont);
        textTextField = new JTextField();
        textTextField.setEnabled(false);
        xLabel = new JLabel("x :");
        xLabel.setFont(defaultFont);
        xTextField = new JTextField();
        xTextField.setEnabled(false);
        yLabel = new JLabel("y :");
        yLabel.setFont(defaultFont);
        yTextField = new JTextField();
        yTextField.setEnabled(false);
        widthLabel = new JLabel("width :");
        widthLabel.setFont(defaultFont);
        widthTextField = new JTextField();
        widthTextField.setEnabled(false);
        heightLabel = new JLabel("height :");
        heightLabel.setFont(defaultFont);
        heightTextField = new JTextField();
        heightTextField.setEnabled(false);
        
        add(typeLabel);
        add(typeBox);
        add(nameLabel);
        add(nameTextField);
        add(textLabel);
        add(textTextField);
        add(xLabel);
        add(xTextField);
        add(yLabel);
        add(yTextField);
        add(widthLabel);
        add(widthTextField);
        add(heightLabel);
        add(heightTextField);
        
    }
    
    
    JLabel typeLabel;
    JComboBox typeBox;
    JLabel nameLabel;
    JTextField nameTextField;
    JLabel textLabel;
    JTextField textTextField;
    JLabel xLabel;
    JTextField xTextField;
    JLabel yLabel;
    JTextField yTextField;
    JLabel widthLabel;
    JTextField widthTextField;
    JLabel heightLabel;
    JTextField heightTextField;
    
    
    
    
}
