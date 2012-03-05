package com.ooobgy.mapinfo.color;

import prefuse.util.ColorLib;

/**
 * Five color type in map data file. <b>created:</b> 2012-3-5
 * 
 * @author 周晓龙 frogcherry@gmail.com
 */
public enum ColorType {
    PINK(ColorLib.rgb(0, 0, 0)),
    BLUE(ColorLib.rgb(0, 0, 0)), 
    YELLOW(ColorLib.rgb(0, 0, 0)), 
    GREEN(ColorLib.rgb(0, 0, 0)), 
    RED(ColorLib.rgb(0, 0, 0));

    private ColorType(int color) {
        this.color = color;
    };

    public int getColor() {
        return color;
    }

    private int color;
}
