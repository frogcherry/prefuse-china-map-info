package com.ooobgy.mapinfo;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

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
    
    private static final String MAP_DATA_FILE = "data/china_map_data.csv";

    public static void main(String[] args) {
        // Create a frame
        JFrame frame = new JFrame("China Map Info Demo    Powered by Prefuse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create the map dispaly
        MapInfoDisplay display = new MapInfoDisplay();
        // init the display with the data file
        try {
            display.init(MAP_DATA_FILE);
        } catch (DataIOException e) { // if the display can't be inited. exit.
            JOptionPane.showMessageDialog(frame, "Can't open the file: " + MAP_DATA_FILE, "Init Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            frame.dispose();
            System.exit(1);
        }
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }
}
