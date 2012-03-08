package com.ooobgy.mapinfo.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import prefuse.util.FontLib;

import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;
import com.ooobgy.mapinfo.pojo.Province;

/**
 * 绘制省份详细信息的Jpanel
 * <b>created:</b> 2012-3-8
 * @author 周晓龙  frogcherry@gmail.com
 */
public class InfoBoard extends JPanel {
    
    private static final long serialVersionUID = -2443455689602790088L;
    
    private JLabel name = new JLabel();
    private JLabel areaTitle = new JLabel();
    private JLabel area = new JLabel();
    private JLabel populationTitle = new JLabel();
    private JLabel population = new JLabel();
    private JLabel populationRateTitle = new JLabel();
    private JLabel populationRate = new JLabel();
    
    public InfoBoard() {
        init();
    }

    public void showProvince(Province province){
        if (province == null) {
            this.setVisible(false);
            return;
        }
        
        name.setText(province.getName());
        area.setText(String.valueOf(province.getArea()));
        population.setText(String.valueOf(province.getPopulation()));
        populationRate.setText(String.valueOf(province.getPopulationRate()));
        
        this.setVisible(true);
    }
    
    private void init() {
        setSize(200, 100);
        setLocation(0, 600 - 280);//test
        setOpaque(false);

        name.setFont(FontLib.getFont("宋体", Font.BOLD, 20));
        this.add(name, BorderLayout.NORTH);
        name.setText("        ");//test
        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        this.add(infoPanel, BorderLayout.SOUTH);
        
        JPanel titlePenel = new JPanel(new GridLayout(3, 1));
        titlePenel.setOpaque(false);
        infoPanel.add(titlePenel, BorderLayout.EAST);
        JPanel dataPenel = new JPanel(new GridLayout(3, 1));
        dataPenel.setOpaque(false);
        infoPanel.add(dataPenel, BorderLayout.EAST);
        
        titlePenel.add(areaTitle);
        areaTitle.setText("面积(万平方千米):");
        dataPenel.add(area);
        area.setText("");
        titlePenel.add(populationTitle);
        populationTitle.setText("人口:");
        dataPenel.add(population);
        population.setText("           ");
        titlePenel.add(populationRateTitle);
        populationRateTitle.setText("占全国人口比例(%):");
        dataPenel.add(populationRate);
        populationRate.setText("");
    }
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        InfoBoard board = new InfoBoard();
        frame.getContentPane().add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setMinimumSize(new Dimension(Config.getInt(ConfConsts.FRAME_WIDTH), Config.getInt(ConfConsts.FRAME_HEIGHT)));
        frame.pack();
        frame.setVisible(true);
    }
}
