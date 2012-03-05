package com.ooobgy.mapinfo;

import javax.swing.JFrame;

public class MapInfoDemo {
    
    private static final String MAP_DATA_FILE = "data/china_map_data.csv";

    public static void main(String[] args) {
        JFrame frame = new JFrame("China Map Info Demo    Powered by Prefuse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MapInfoDisplay display = new MapInfoDisplay();
        display.init(MAP_DATA_FILE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }
}
