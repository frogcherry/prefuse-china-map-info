package com.ooobgy.mapinfo.color;

import java.awt.Color;

import com.ooobgy.comm.util.ValidationUtility;

/**
 * color处理工具
 * <b>created:</b> 2012-3-8
 * @author 周晓龙  frogcherry@gmail.com
 */
public class ColorUtil {
    private static final int RANGE = 15;//RGB各要素+/- 15都可以接受
    
    /**
     * 返回匹配的颜色类型，若匹配失败返回null
     * @param color
     * @return
     */
    public static ColorType matchColor(Color color){
        if (matchColor(ColorType.PINK, color)) {
            return ColorType.PINK;
        }
        if (matchColor(ColorType.BLUE, color)) {
            return ColorType.BLUE;
        }
        if (matchColor(ColorType.YELLOW, color)) {
            return ColorType.YELLOW;
        }
        if (matchColor(ColorType.GREEN, color)) {
            return ColorType.GREEN;
        }
        if (matchColor(ColorType.RED, color)) {
            return ColorType.RED;
        }
        
        return null;
    }
    
    public static boolean matchColor(ColorType dest, Color color){
        return ValidationUtility.isInRange(color.getRed(), dest.getColor().getRed(), RANGE, true)
                && ValidationUtility.isInRange(color.getBlue(), dest.getColor().getBlue(), RANGE, true)
                && ValidationUtility.isInRange(color.getGreen(), dest.getColor().getGreen(), RANGE, true);

    }
}
