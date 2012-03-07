package com.ooobgy.mapinfo;

import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestLay extends JFrame {
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
     this.setVisible(true);
    }
    
    public static void main(String[] args) {
     new TestLay().showMe();
    }
   }
