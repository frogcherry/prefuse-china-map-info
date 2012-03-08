package com.ooobgy.mapinfo.pojo;

import com.ooobgy.mapinfo.color.ColorType;
import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;
import com.ooobgy.mapinfo.exception.IllDataException;

import prefuse.data.util.TableIterator;

/**
 * 储存每个省份基本信息的实体类
 * <b>created:</b> 2012-3-7
 * @author 周晓龙  frogcherry@gmail.com
 */
public class Province {
    private int id;
    private String name;
    private double area;
    private int population;
    private float populationRate;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private String image;
    private ColorType color;
    

    private static ColorType matchColor(int colorId){
        switch (colorId) {
            case 1: return ColorType.PINK;
            case 2: return ColorType.BLUE;
            case 3: return ColorType.YELLOW;
            case 4: return ColorType.GREEN;
            case 5: return ColorType.RED;
            default: throw new IllDataException("error when read data: error color id.");
        }
    }
    
    public static Province buildProvince(TableIterator dataSource){      
        try {
            Province province = new Province();      
            province.setId(dataSource.getInt(Config.get(ConfConsts.DATA_ID)));
            province.setName(dataSource.getString(Config.get(ConfConsts.DATA_NAME)));
            province.setImage(dataSource.getString(Config.get(ConfConsts.DATA_IMAGE)));
            province.setPopulation(dataSource.getInt(Config.get(ConfConsts.DATA_POPULATION)));
            province.setMinX(dataSource.getInt(Config.get(ConfConsts.DATA_MINX)));
            province.setMaxX(dataSource.getInt(Config.get(ConfConsts.DATA_MAXX)));
            province.setMinY(dataSource.getInt(Config.get(ConfConsts.DATA_MINY)));
            province.setMaxY(dataSource.getInt(Config.get(ConfConsts.DATA_MAXY)));
            province.setArea(dataSource.getDouble(Config.get(ConfConsts.DATA_AREA)));
            province.setPopulationRate(dataSource.getFloat(Config.get(ConfConsts.DATA_POPULATIONRATE)));
            int colorId = dataSource.getInt(Config.get(ConfConsts.DATA_COLORID));
            province.setColor(matchColor(colorId));
            return province;
        } catch (Exception e) {
            throw new IllDataException("error when read data", e);
        }
    }
    
    public ColorType getColor() {
        return color;
    }

    public void setColor(ColorType color) {
        this.color = color;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getArea() {
        return area;
    }
    public void setArea(double area) {
        this.area = area;
    }
    public int getPopulation() {
        return population;
    }
    public void setPopulation(int population) {
        this.population = population;
    }
    public float getPopulationRate() {
        return populationRate;
    }
    public void setPopulationRate(float populationRate) {
        this.populationRate = populationRate;
    }
    public int getMinX() {
        return minX;
    }
    public void setMinX(int minX) {
        this.minX = minX;
    }
    public int getMinY() {
        return minY;
    }
    public void setMinY(int minY) {
        this.minY = minY;
    }
    public int getMaxX() {
        return maxX;
    }
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }
    public int getMaxY() {
        return maxY;
    }
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
}
