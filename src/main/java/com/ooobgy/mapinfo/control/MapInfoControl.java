package com.ooobgy.mapinfo.control;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.SwingUtilities;

import prefuse.controls.ControlAdapter;

import com.ooobgy.mapinfo.color.ColorType;
import com.ooobgy.mapinfo.color.ColorUtil;

public class MapInfoControl extends ControlAdapter {
    private Point prePt;
    private Point originLoc;
    private Rebounder rebounder;
    private Robot robot;

    public MapInfoControl() throws AWTException {
        super();
        robot = new Robot();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        prePt = (Point) e.getLocationOnScreen().clone();
        originLoc = (Point) e.getComponent().getLocation().clone();
        if (rebounder != null) {
            rebounder.cancel(true);
        }
        //SwingUtilities.convertPointToScreen(prePt, e.getComponent());
    }

    Set<ColorType> colors = new HashSet<ColorType>();
    
    @Override
    public void mouseMoved(MouseEvent e) {
        Point pt = (Point) e.getLocationOnScreen().clone();
        Color color = robot.getPixelColor(pt.x, pt.y);
        ColorType normColor = ColorUtil.matchColor(color);
        if (normColor!=null && !colors.contains(normColor)) {
            colors.add(normColor);
            System.out.println(colors);
        }
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        
        if (SwingUtilities.isLeftMouseButton(e)) {
            Component c = e.getComponent();
            Point pt = (Point) e.getLocationOnScreen().clone();
//            SwingUtilities.convertPointToScreen(pt, c);
            int dx = pt.x - prePt.x;
            int dy = pt.y - prePt.y;
//            System.out.println(dx);
            // System.out.println(dx + "#" + dy);
            // Point dispLoc = MapInfoDisplay.this.getLocat ion();
            c.setLocation(originLoc.x + dx, originLoc.y + dy);
//            c.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        RebounderOld rebounder = new RebounderOld(e.getComponent(), new Point(0, 0));
//        rebounder.run();
        rebounder = new Rebounder(e.getComponent(), new Point(0, 0));
        rebounder.execute();
    }

}

