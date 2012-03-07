package com.ooobgy.mapinfo.pojo;

import prefuse.data.util.TableIterator;

/**
 * 储存每个省份基本信息的实体类
 * <b>created:</b> 2012-3-7
 * @author 周晓龙  frogcherry@gmail.com
 */
public class Province {
    private Integer id;
    private String name;
    private double area;
    private int population;
    private float populationRate;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private String pic;
    
    public Province buildProvince(TableIterator dataSource){
        Province province = new Province();
        
        
        
        return province;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
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
    public String getPic() {
        return pic;
    }
    public void setPic(String pic) {
        this.pic = pic;
    }
}
