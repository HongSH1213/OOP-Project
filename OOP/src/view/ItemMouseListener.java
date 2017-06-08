package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class ItemMouseListener extends MouseAdapter {

    public void setPanel(EditorPanel editor, PropertiesPanel properties) {
        editorPanel = editor;
        propertiesPanel = properties;
    }
 
    @Override
    public void mouseMoved(MouseEvent e) {
        if (editorPanel.getSelectedItem() != (JComponent) e.getSource()) {
            ((JComponent) e.getSource()).setCursor(defaultCursor);
            return;
        }

        src = (JComponent) e.getSource();
        width = src.getWidth();
        height = src.getHeight();
        x = e.getX();
        y = e.getY();
        if ((x >= 0 && x <= 3) && (y >= 0 && y <= 3)) {
            src.setCursor(NW);
        } else if ((x <= width && x >= width - 3) && (y >= 0 && y <= 3)) {
            src.setCursor(NE);
        } else if ((x <= width && x >= width - 3) && (y <= height && y >= height - 3)) {
            src.setCursor(SE);
        } else if ((x >= 0 && x <= 3) && (y <= height && y >= height - 3)) {
            src.setCursor(SW);
        } else if ((x >= 0 && x <= 3) && (y > 3 && y < height - 3)) {
            src.setCursor(W);
        } else if ((x <= width && x >= width - 3) && (y > 3 && y < height - 3)) {
            src.setCursor(E);
        } else if ((x > 3 && x < width - 3) && (y >= 0 && y <= 3)) {
            src.setCursor(N);
        } else if ((x > 3 && x < width - 3) && (y <= height && y >= height - 3)) {
            src.setCursor(S);
        } else {
            src.setCursor(moveCursor);
        }

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (editorPanel.getSelectedItem() != (JComponent) e.getSource())
            return;
        int tempX;
        int tempY;
        src = (JComponent) e.getSource();
        width = src.getWidth();
        height = src.getHeight();
        x = (int) start.getX();
        y = (int) start.getY();
        if (state == 1) {
            // 왼쪽 위
            tempX = e.getX() - x;
            if (tempX + width < 0)
                tempX = -width;
            tempY = e.getY() - y;
            if (tempY + height < 0)
                tempY = -height;
            src.setBounds(src.getX() + tempX, src.getY() + tempY, width - tempX, height - tempY);
        } else if (state == 2) {
            // 오른쪽 위
            tempX = e.getX() - x;
            tempY = e.getY() - y;
            if (tempX + (int) info.getWidth() < 0)
                tempX = -(int) info.getWidth();
            if (tempY + height < 0)
                tempY = -height;
            src.setBounds(src.getX(), src.getY() + tempY, (int) info.getWidth() + tempX, height - tempY);
        } else if (state == 3) {
            // 오른쪽 아래
            tempX = e.getX() - x;
            tempY = e.getY() - y;
            if (tempX + (int) info.getWidth() < 0)
                tempX = -(int) info.getWidth();
            if (tempY + (int) info.getHeight() < 0)
                tempY = -(int) info.getHeight();
            src.setSize((int) info.getWidth() + tempX, (int) info.getHeight() + tempY);
        } else if (state == 4) {
            // 왼쪽 아래
            tempX = e.getX() - x;
            tempY = e.getY() - y;
            if (tempX + width < 0)
                tempX = -width;
            if (tempY + (int) info.getHeight() < 0)
                tempY = -(int) info.getHeight();
            src.setBounds(src.getX() + tempX, src.getY(), width - tempX, (int) info.getHeight() + tempY);
        } else if (state == 5) {
            // 왼쪽
            tempX = e.getX() - x;
            if (tempX + width < 0)
                tempX = -width;
            src.setBounds(src.getX() + tempX, src.getY(), width - tempX, height);
        } else if (state == 6) {
            // 오른쪽
            tempX = e.getX() - x;
            if (tempX + (int) info.getWidth() < 0)
                tempX = -(int) info.getWidth();
            src.setSize((int) info.getWidth() + tempX, height);
        } else if (state == 7) {
            // 위
            tempY = e.getY() - y;
            if (tempY + height < 0)
                tempY = -height;
            src.setBounds(src.getX(), src.getY() + tempY, width, height - tempY);
        } else if (state == 8) {
            // 아래
            tempY = e.getY() - y;
            if (tempY + (int) info.getHeight() < 0)
                tempY = -(int) info.getHeight();
            src.setSize(width, (int) info.getHeight() + tempY);
        } else {
            // 가운데
            tempX = e.getX() - x;
            tempY = e.getY() - y;
            src.setLocation(src.getX() + tempX, src.getY() + tempY);
        }
        propertiesPanel.setProperties(src);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (editorPanel.getSelectedItem() != (JComponent) e.getSource())
            return;
        src = (JComponent) e.getSource();
        width = src.getWidth();
        height = src.getHeight();
        info.setBounds(src.getBounds());
        start.setLocation((double) e.getX(), (double) e.getY());
        x = (int) start.getX();
        y = (int) start.getY();
        if ((x >= 0 && x <= 3) && (y >= 0 && y <= 3)) {
            // 왼쪽 위
            state = 1;
        } else if ((x <= width && x >= width - 3) && (y >= 0 && y <= 3)) {
            // 오른쪽 위
            state = 2;
        } else if ((x <= width && x >= width - 3) && (y <= height && y >= height - 3)) {
            // 오른쪽 아래
            state = 3;
        } else if ((x >= 0 && x <= 3) && (y <= height && y >= height - 3)) {
            // 왼쪽 아래
            state = 4;
        } else if ((x >= 0 && x <= 3) && (y > 3 && y < height - 3)) {
            // 왼쪽
            state = 5;
        } else if ((x <= width && x >= width - 3) && (y > 3 && y < height - 3)) {
            // 오른쪽
            state = 6;
        } else if ((x > 3 && x < width - 3) && (y >= 0 && y <= 3)) {
            // 위
            state = 7;
        } else if ((x > 3 && x < width - 3) && (y <= height && y >= height - 3)) {
            // 아래
            state = 8;
        } else {
            // 가운데
            state = 9;
        }
    }

    public void mouseClicked(MouseEvent e) {
        // 속성창에 정보 넘겨주기
        JComponent temp = (JComponent) e.getSource();
        JComponent old = editorPanel.getSelectedItem();
        if (old != null && old != temp) {
            old.setBorder(null);
            if (old.getClass().getSimpleName().equals("JButton"))
                old.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            propertiesPanel.setProperties(null);
        }
        editorPanel.setSelectedItem(temp);
        temp.requestFocus();
        temp.setBorder(BorderFactory.createLineBorder(Color.RED));
        propertiesPanel.setProperties(temp);

    }

    private PropertiesPanel propertiesPanel;
    private EditorPanel editorPanel;
    private final Cursor NW = new Cursor(Cursor.NW_RESIZE_CURSOR);
    private final Cursor NE = new Cursor(Cursor.NE_RESIZE_CURSOR);
    private final Cursor N = new Cursor(Cursor.N_RESIZE_CURSOR);
    private final Cursor SW = new Cursor(Cursor.SW_RESIZE_CURSOR);
    private final Cursor SE = new Cursor(Cursor.SE_RESIZE_CURSOR);
    private final Cursor S = new Cursor(Cursor.S_RESIZE_CURSOR);
    private final Cursor E = new Cursor(Cursor.E_RESIZE_CURSOR);
    private final Cursor W = new Cursor(Cursor.W_RESIZE_CURSOR);
    private final Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
    private final Cursor moveCursor = new Cursor(Cursor.MOVE_CURSOR);
    private JComponent src;
    private int width;
    private int height;
    private int x;
    private int y;
    private int state;
    private Point start = new Point();
    private Rectangle info = new Rectangle();

}
