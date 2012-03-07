package com.ooobgy.mapinfo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;
import com.ooobgy.mapinfo.ui.MapInfoDisplay;

import prefuse.data.io.DataIOException;

/**
 * A demo to display the map of China. Powered by prefuse. <br>
 * Just run it. Move your mouse, when your mouse hover, it will show the 
 * information (name, area, population) of the province.<br>
 * Enjoy it! ^_^ <br>
 * <b>created:</b> 2012-3-5
 * @author 周晓龙  frogcherry@gmail.com
 * @see MapInfoDisplay
 */
public class MapInfoDemo {
    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("");
        frame.setTitle(Config.get(ConfConsts.TITLE));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create the map dispaly
        MapInfoDisplay display = new MapInfoDisplay();
        // init the display with the data file
        try {
            display.init(Config.get(ConfConsts.DATAFILE));
        } catch (DataIOException e) { // if the display can't be inited. exit.
            JOptionPane.showMessageDialog(frame, "Can't open the file: " + Config.get(ConfConsts.DATAFILE), "Init Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            frame.dispose();
            System.exit(1);
        }
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }
}
