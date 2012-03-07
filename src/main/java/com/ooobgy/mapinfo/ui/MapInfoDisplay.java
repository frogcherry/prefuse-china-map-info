package com.ooobgy.mapinfo.ui;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;

import prefuse.Display;
import prefuse.Visualization;
import prefuse.data.Table;
import prefuse.data.io.CSVTableReader;
import prefuse.data.io.DataIOException;
import prefuse.data.util.TableIterator;

/**
 * The main display (view) of the map demo.</br>
 * Before to use, it should be {@link #init(String)} with data file first.
 * <b>created:</b> 2012-3-5
 * @author 周晓龙  frogcherry@gmail.com
 */
public class MapInfoDisplay extends Display{
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
        
        for( TableIterator iterator = this.data.iterator(); iterator.hasNext();){
            //System.out.println(Config.get(ConfConsts.DATA_NAME));
            iterator.nextInt();
            System.out.println(iterator.get(Config.get(ConfConsts.DATA_NAME)));
            //System.out.println(iterator.get("error"));
        }
        // TODO Auto-generated method stub
        //setSize(Config.getInt(ConfConsts.FRAME_WIDTH), Config.getInt(ConfConsts.FRAME_HEIGHT));
        BackgroundDisplay bk = new BackgroundDisplay();
        this.add(bk);
        bk.paint(Config.get(ConfConsts.BK_IMG_FILE), Config.getInt(ConfConsts.FRAME_WIDTH), Config.getInt(ConfConsts.FRAME_HEIGHT));
        
        bindEventListener();
        this.addMouseListener(new DisplayMouseListenner());
    }
    
    private void bindEventListener() {
        addMouseListener(new DisplayMouseListenner());
    }

    class DisplayMouseListenner implements MouseInputListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println(e.getX());
            System.out.println(MapInfoDisplay.this.getLocation());
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
        public void mouseDragged(MouseEvent e) {
            
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }
    } 

}
