package com.ooobgy.mapinfo.ui;

import java.awt.AWTException;
import java.awt.Dimension;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import javax.imageio.ImageIO;

import com.ooobgy.mapinfo.color.ColorType;
import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;
import com.ooobgy.mapinfo.control.MapInfoControl;
import com.ooobgy.mapinfo.pojo.Province;

import prefuse.Display;
import prefuse.Visualization;
import prefuse.data.Table;
import prefuse.data.io.CSVTableReader;
import prefuse.data.io.DataIOException;
import prefuse.data.util.TableIterator;

/**
 * The main display (view) of the map demo.</br> 
 * Before to use, it should be
 * {@link #init(String)} with data file first. <br>
 * <b>created:</b> 2012-3-5
 * 
 * @author 周晓龙 frogcherry@gmail.com
 */
public class MapInfoDisplay extends Display {
    public MapInfoDisplay() {
        super(new Visualization());
    }

    private Table data;//prefuse读取的地图数据
    private Map<ColorType, Set<Province>> provincesMap;//地图数据查找表
    private ImagePanel glassPan;//背景图
    private InfoBoard infoBoard;//省份信息板
    
    /**
     * Random Serial Version UID
     */
    private static final long serialVersionUID = -4912140410703394902L;

    /**
     * 初始化地图Display
     * @param mapDataFile
     * @throws DataIOException
     * @throws AWTException
     */
    public void init(String mapDataFile) throws DataIOException, AWTException {
        this.data = (new CSVTableReader()).readTable(mapDataFile);
        setBackgroundImage(Config.get(ConfConsts.BK_IMG_FILE), false, false);
        
        initProvinceMap();
        for (TableIterator iterator = this.data.iterator(); iterator.hasNext();) {
            iterator.nextInt();
            pushProvinceMap(Province.buildProvince(iterator));
        }
        this.setSize(Config.getInt(ConfConsts.FRAME_WIDTH),
                Config.getInt(ConfConsts.FRAME_HEIGHT));

        glassPan = new ImagePanel();
        this.add(glassPan);
        glassPan.setLocation(0, 0);
        this.setLayout(null);
        glassPan.setMinimumSize(new Dimension(Config.getInt(ConfConsts.FRAME_WIDTH), Config.getInt(ConfConsts.FRAME_HEIGHT)));
        glassPan.setSize(Config.getInt(ConfConsts.FRAME_WIDTH), Config.getInt(ConfConsts.FRAME_HEIGHT));
        infoBoard = new InfoBoard();
        this.add(infoBoard);
        infoBoard.setLocation(Config.getInt(ConfConsts.INFOBOARD_LEFT), Config.getInt(ConfConsts.INFOBOARD_TOP));
        infoBoard.setVisible(false);
        try {
            infoBoard.setBackImage(ImageIO.read(new File(Config.get(ConfConsts.INFOBOARD_BKIMG))));
        } catch (IOException e) {
            infoBoard.setBackImage(null);
            System.err.println("Error config: info board back image file path.");
            e.printStackTrace();
        }
        
        this.addControlListener(new MapInfoControl(provincesMap, glassPan, infoBoard));
    }

    /**
     * 存入一个省份pojo
     * @param province
     */
    private void pushProvinceMap(Province province){
        provincesMap.get(province.getColor()).add(province);
    }
    
    /**
     * 初始化存储省份信息的数据结构
     */
    private void initProvinceMap() {
        provincesMap = new HashMap<ColorType, Set<Province>>();
        provincesMap.put(ColorType.PINK, new LinkedHashSet<Province>());
        provincesMap.put(ColorType.BLUE, new LinkedHashSet<Province>());
        provincesMap.put(ColorType.GREEN, new LinkedHashSet<Province>());
        provincesMap.put(ColorType.YELLOW, new LinkedHashSet<Province>());
        provincesMap.put(ColorType.RED, new LinkedHashSet<Province>());
    }
}
