package com.ooobgy.mapinfo.ui;

import java.awt.Component;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;
import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;
import com.ooobgy.mapinfo.control.Rebounder;
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
            iterator.nextInt();
            
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
        private Point prePt;
        private Point originLoc;
        private Rebounder rebounder;

        @Override
        public void mousePressed(MouseEvent e) {
            prePt = (Point) e.getLocationOnScreen().clone();
            originLoc = (Point) e.getComponent().getLocation().clone();
            if (rebounder != null) {
                rebounder.cancel(true);
            }
            //SwingUtilities.convertPointToScreen(prePt, e.getComponent());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            
            if (SwingUtilities.isLeftMouseButton(e)) {
                Component c = e.getComponent();
                Point pt = (Point) e.getLocationOnScreen().clone();
//                SwingUtilities.convertPointToScreen(pt, c);
                int dx = pt.x - prePt.x;
                int dy = pt.y - prePt.y;
//                System.out.println(dx);
                // System.out.println(dx + "#" + dy);
                // Point dispLoc = MapInfoDisplay.this.getLocat ion();
                c.setLocation(originLoc.x + dx, originLoc.y + dy);
//                c.repaint();
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
//            RebounderOld rebounder = new RebounderOld(e.getComponent(), new Point(0, 0));
//            rebounder.run();
            rebounder = new Rebounder(e.getComponent(), new Point(0, 0));
            rebounder.execute();
        }

    }

}
