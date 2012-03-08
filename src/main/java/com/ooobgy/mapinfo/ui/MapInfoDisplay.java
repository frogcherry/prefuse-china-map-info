package com.ooobgy.mapinfo.ui;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.swing.SwingUtilities;

import com.ooobgy.mapinfo.color.ColorType;
import com.ooobgy.mapinfo.color.ColorUtil;
import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;
import com.ooobgy.mapinfo.control.Rebounder;
import com.ooobgy.mapinfo.pojo.Province;

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

    private Robot robot;
    private Map<ColorType, Set<Province>> provincesMap;
    
    /**
     * Random Serial Version UID
     */
    private static final long serialVersionUID = -4912140410703394902L;

    public void init(String mapDataFile) throws DataIOException, AWTException {
        this.data = (new CSVTableReader()).readTable(mapDataFile);
        setBackgroundImage(Config.get(ConfConsts.BK_IMG_FILE), false, false);
        
        initProvinceMap();
        for (TableIterator iterator = this.data.iterator(); iterator.hasNext();) {
            iterator.nextInt();
            pushProvinceMap(Province.buildProvince(iterator));
        }
        // TODO Auto-generated method stub
        this.setSize(Config.getInt(ConfConsts.FRAME_WIDTH),
                Config.getInt(ConfConsts.FRAME_HEIGHT));

        bindEventListener();
        robot = new Robot();
        //System.out.println(provincesMap);
    }

    private void pushProvinceMap(Province province){
        provincesMap.get(province.getColor()).add(province);
    }
    
    private void initProvinceMap() {
        provincesMap = new HashMap<ColorType, Set<Province>>();
        provincesMap.put(ColorType.PINK, new LinkedHashSet<Province>());
        provincesMap.put(ColorType.BLUE, new LinkedHashSet<Province>());
        provincesMap.put(ColorType.GREEN, new LinkedHashSet<Province>());
        provincesMap.put(ColorType.YELLOW, new LinkedHashSet<Province>());
        provincesMap.put(ColorType.RED, new LinkedHashSet<Province>());
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

        Set<ColorType> colors = new HashSet<ColorType>();
        
        @Override
        public void mouseMoved(MouseEvent e) {
            Point pt = (Point) e.getLocationOnScreen().clone();
            Color color = MapInfoDisplay.this.robot.getPixelColor(pt.x, pt.y);
            ColorType normColor = ColorUtil.matchColor(color);
            if (normColor!=null && !colors.contains(normColor)) {
                colors.add(normColor);
                System.out.println(colors);
            }
//            System.out.println(color);
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
