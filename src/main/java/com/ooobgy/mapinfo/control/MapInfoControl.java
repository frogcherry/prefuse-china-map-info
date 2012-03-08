package com.ooobgy.mapinfo.control;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;

import prefuse.controls.ControlAdapter;

import com.ooobgy.comm.util.ValidationUtility;
import com.ooobgy.mapinfo.color.ColorType;
import com.ooobgy.mapinfo.color.ColorUtil;
import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;
import com.ooobgy.mapinfo.exception.IllDataException;
import com.ooobgy.mapinfo.pojo.Province;
import com.ooobgy.mapinfo.ui.ImagePanel;
import com.ooobgy.mapinfo.ui.InfoBoard;

/**
 * 操作控制器 <b>created:</b> 2012-3-8
 * 
 * @author 周晓龙 frogcherry@gmail.com
 */
public class MapInfoControl extends ControlAdapter {
    private Point prePt;
    private Point originLoc;
    private Rebounder rebounder;
    private Robot robot;
    private Map<ColorType, Set<Province>> provincesMap;
    private int preTouchedProvId;
    private ImagePanel glassPan;
    private InfoBoard infoBoard;

    public MapInfoControl(Map<ColorType, Set<Province>> provincesMap,
            ImagePanel glassPan, InfoBoard infoBoard) throws AWTException {
        super();
        this.robot = new Robot();
        this.provincesMap = provincesMap;
        this.glassPan = glassPan;
        this.preTouchedProvId = -1;
        this.infoBoard = infoBoard;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        prePt = (Point) e.getLocationOnScreen().clone();
        originLoc = (Point) e.getComponent().getLocation().clone();
        if (rebounder != null) {
            rebounder.cancel(true);
        }
        // SwingUtilities.convertPointToScreen(prePt, e.getComponent());
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Point pt = (Point) e.getLocationOnScreen().clone();
        Color color = robot.getPixelColor(pt.x, pt.y);
        ColorType normColor = ColorUtil.matchColor(color);
        Point touchPt = (Point) e.getPoint().clone();
        Province province = matchProvince(normColor, touchPt);
        if (province != null) {
            if (preTouchedProvId != province.getId()) {
                // System.out.println(province.getName());
                preTouchedProvId = province.getId();
                String imgFile = Config.get(ConfConsts.IMG_FOLDER)
                        + province.getImage();
                infoBoard.showProvince(province);
                try {
                    Image img = ImageIO.read(new File(imgFile));
                    glassPan.setImage(img);
                    glassPan.repaint();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    throw new IllDataException("error data: \"" + imgFile
                            + "\" does not exist. ", e1);
                }
                // TODO: print the info.
            }
        } else {
            glassPan.setImage(null);
            glassPan.repaint();
            preTouchedProvId = -1;
            infoBoard.showProvince(province);
        }
        
        
    }

    private Province matchProvince(ColorType normColor, Point touchPt) {
        Set<Province> provinces = provincesMap.get(normColor);
        if (provinces == null) {
            return null;
        }

        for (Province province : provinces) {
            if (ValidationUtility.isInRange(touchPt.x, province.getMinX(),
                    province.getMaxX(), true, true)
                    && ValidationUtility.isInRange(touchPt.y,
                            province.getMinY(), province.getMaxY(), true, true)) {
                return province;
            }
        }

        return null;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        if (SwingUtilities.isLeftMouseButton(e)) {
            Component c = e.getComponent();
            Point pt = (Point) e.getLocationOnScreen().clone();
            // SwingUtilities.convertPointToScreen(pt, c);
            int dx = pt.x - prePt.x;
            int dy = pt.y - prePt.y;
            // System.out.println(dx);
            // System.out.println(dx + "#" + dy);
            // Point dispLoc = MapInfoDisplay.this.getLocat ion();
            c.setLocation(originLoc.x + dx, originLoc.y + dy);
            // c.repaint();
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // RebounderOld rebounder = new RebounderOld(e.getComponent(), new
        // Point(0, 0));
        // rebounder.run();
        rebounder = new Rebounder(e.getComponent(), new Point(0, 0));
        rebounder.execute();
    }

}
