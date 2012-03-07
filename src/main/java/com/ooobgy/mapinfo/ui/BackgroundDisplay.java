package com.ooobgy.mapinfo.ui;

import javax.swing.JPanel;

import prefuse.util.display.BackgroundPainter;

public class BackgroundDisplay extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 172162831579455409L;

    public BackgroundDisplay() {
        super();
    }
    
    public void paint(String imgFile, int width, int height){
        setSize(width, height);
        setBackgroundImage(imgFile);
    }

    private void setBackgroundImage(String imgFile) {
        this.getGraphics();//draw something
        
    }
}
