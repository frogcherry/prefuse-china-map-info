package com.ooobgy.mapinfo.color;

import java.awt.Color;

/**
 * Five color type in map data file. <br>
 * <b>created:</b> 2012-3-5
 * 
 * @author 周晓龙 frogcherry@gmail.com
 */
public enum ColorType {
    PINK(new Color(253, 211, 169)),
    BLUE(new Color(142, 208, 232)), 
    YELLOW(new Color(255, 198, 85)), 
    GREEN(new Color(155, 234, 119)), 
    RED(new Color(248, 22, 38));

    private ColorType(Color color) {
        this.color = color;
    };

    public Color getColor() {
        return color;
    }

    private Color color;
}
