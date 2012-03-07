package com.ooobgy.mapinfo;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

import com.ooobgy.mapinfo.ui.MapInfoDisplay;

public class TestLay extends JFrame {
    private class DisplayMouseListenner implements MouseInputListener {
            private Point prePt = new Point();
    
            @Override
            public void mousePressed(MouseEvent e) {
                refreshPrePt(e);
    //            System.out.println(e.getX());
                System.out.println(e.getX());
            }
    
            private void refreshPrePt(MouseEvent e) {
                prePt.x = e.getX();
                prePt.y = e.getY();
            }
    
            @Override
            public synchronized void mouseDragged(MouseEvent e) {
                System.out.println(e.getX());
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int dx = e.getX() - prePt.x;
                    int dy = e.getY() - prePt.x;
                    // System.out.println(dx + "#" + dy);
                    // Point dispLoc = MapInfoDisplay.this.getLocat ion();
                    TestLay.this.jButton.setLocation(60+dx, 25+dx);
                }
            }
    
            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
    
            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
    
            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
    
            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub
                
            }
    
            @Override
            public void mouseMoved(MouseEvent e) {
                // TODO Auto-generated method stub
                System.out.println("M");
            }
    
        }

    private JPanel jContentPane = null;
    private JButton jButton = null;
    /**
     * This is the default constructor
     */
    public TestLay() {
     super();
     initialize();
    }
    /**
     * This method initializes this
     *
     * @return void
     */
    private void initialize() {
     jButton = new JButton();
     //设置button的位置为(100,100) 长宽分别为 60，25
     jButton.setBounds(new Rectangle(100, 100, 60, 25));
     jButton.setText("help");
     
     jContentPane = new JPanel();
     jContentPane.setLayout(null);
     jContentPane.add(jButton, null);
     
     this.add(jContentPane);
    }
    public void showMe() {
     this.setSize(300, 200);
     this.setTitle("JFrame");
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.addMouseListener(new DisplayMouseListenner());
     this.setVisible(true);
    }
    
    public static void main(String[] args) {
     new TestLay().showMe();
    }
   }
