package com.ooobgy.mapinfo.ui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputListener;

import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;

import prefuse.Display;
import prefuse.Visualization;
import prefuse.controls.ControlAdapter;
import prefuse.data.Table;
import prefuse.data.io.CSVTableReader;
import prefuse.data.io.DataIOException;
import prefuse.data.util.TableIterator;

/**
 * The main display (view) of the map demo.</br> Before to use, it should be
 * {@link #init(String)} with data file first. <b>created:</b> 2012-3-5
 * 
 * @author 周晓龙 frogcherry@gmail.com
 */
public class MapInfoDisplay extends Display {
    public MapInfoDisplay() {
        super(new Visualization());
    }

    private Table data;

    /**
     * Random Serial Version UID
     */
    private static final long serialVersionUID = -4912140410703394902L;

    public void init(String mapDataFile) throws DataIOException {
        this.data = (new CSVTableReader()).readTable(mapDataFile);

        setBackgroundImage(Config.get(ConfConsts.BK_IMG_FILE), false, false);

        for (TableIterator iterator = this.data.iterator(); iterator.hasNext();) {
            // System.out.println(Config.get(ConfConsts.DATA_NAME));
            iterator.nextInt();
//            System.out.println(iterator.get(Config.get(ConfConsts.DATA_NAME)));
            // System.out.println(iterator.get("error"));
        }
        // TODO Auto-generated method stub
        this.setSize(Config.getInt(ConfConsts.FRAME_WIDTH),
                Config.getInt(ConfConsts.FRAME_HEIGHT));

        bindEventListener();

    }

    private void bindEventListener() {
        
//         addMouseListener(new DisplayMouseListenner());
        this.addControlListener(new MapInfoControl());
    }

    private class MapInfoControl extends ControlAdapter {
        private Point prePt = new Point();

        @Override
        public void mousePressed(MouseEvent e) {
            refreshPrePt(e);
//            System.out.println(e.getX());
        }

        private void refreshPrePt(MouseEvent e) {
            prePt.x = e.getX();
            prePt.y = e.getY();
        }

        @Override
        public synchronized void mouseDragged(MouseEvent e) {
            
            if (SwingUtilities.isLeftMouseButton(e)) {
                Component c = e.getComponent();
                int dx = e.getX() - prePt.x;
                int dy = e.getY() - prePt.x;
                System.out.println(dx);
                // System.out.println(dx + "#" + dy);
                // Point dispLoc = MapInfoDisplay.this.getLocat ion();
                c.setLocation(dx, dy);
                c.repaint();
            }
        }

    }

    private class DisplayMouseListenner implements MouseInputListener {
        private Point prePt = new Point();

        @Override
        public void mousePressed(MouseEvent e) {
            refreshPrePt(e);
//            System.out.println(e.getX());
        }

        private void refreshPrePt(MouseEvent e) {
            prePt.x = e.getX();
            prePt.y = e.getY();
        }

        @Override
        public synchronized void mouseDragged(MouseEvent e) {
            System.out.println(e.getX());
            if (SwingUtilities.isLeftMouseButton(e) &&(e.getX() >= prePt.x)) {
                int dx = e.getX() - prePt.x;
                int dy = e.getY() - prePt.x;
                // System.out.println(dx + "#" + dy);
                refreshPrePt(e);
                 Point dispLoc = MapInfoDisplay.this.getLocation();
                MapInfoDisplay.this.setLocation(dispLoc.x + dx, dispLoc.y + dy);
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
            
        }

    }

}
