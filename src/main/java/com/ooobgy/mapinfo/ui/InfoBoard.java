package com.ooobgy.mapinfo.ui;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import prefuse.util.FontLib;

import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;
import com.ooobgy.mapinfo.control.InfoBoardFader;
import com.ooobgy.mapinfo.pojo.Province;

/**
 * 绘制省份详细信息的Jpanel <br>
 * <b>created:</b> 2012-3-8
 * 
 * @author 周晓龙 frogcherry@gmail.com
 */
public class InfoBoard extends JPanel {

    private static final long serialVersionUID = -2443455689602790088L;

    private AlphaComposite composite;
    private Image bkImg = null;

    private JLabel name = new JLabel();
    private JLabel areaTitle = new JLabel();
    private JLabel area = new JLabel();
    private JLabel populationTitle = new JLabel();
    private JLabel population = new JLabel();
    private JLabel populationRateTitle = new JLabel();
    private JLabel populationRate = new JLabel();

    private InfoBoardFader fader;
    private float alpha = 1.0f;

    public InfoBoard() {
        init();
    }

    public void cancelFade(){
        if (fader != null) {
            fader.cancel(true);
            fader = null;
        }
        if (!isVisible()) {
            this.setVisible(true);
        }
        if (this.alpha < 1.0f) {
            this.setAlpha(1.0f);
            this.alpha = 1.0f;
        }
    }
    
    public void fadeOut(){
        if (this.fader == null) {
            this.fader = new InfoBoardFader(this);
            fader.execute();
        }
    }
    
    public void showProvince(Province province) {
        if (province != null)  {
            name.setText(province.getName());
            area.setText(String.valueOf(province.getArea()));
            population.setText(String.valueOf(province.getPopulation()));
            populationRate.setText(String.valueOf(province.getPopulationRate()));

            this.setVisible(true);
            this.setAlpha(1.0f);
        }
    }

    private void init() {
        setSize(Config.getInt(ConfConsts.INFOBOARD_WIDTH), Config.getInt(ConfConsts.INFOBOARD_HEIGHT));
        setOpaque(false);
        composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f);

        name.setFont(FontLib.getFont("宋体", Font.BOLD, 20));
        this.add(name, BorderLayout.NORTH);
        name.setText("        ");// test
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
        areaTitle.setText(Config.get(ConfConsts.INFOBOARD_AREA_TITLE));
        dataPenel.add(area);
        area.setText("");
        titlePenel.add(populationTitle);
        populationTitle.setText(Config.get(ConfConsts.INFOBOARD_POP_TITLE));
        dataPenel.add(population);
        population.setText("           ");
        titlePenel.add(populationRateTitle);
        populationRateTitle.setText(Config.get(ConfConsts.INFOBOARD_POPRATE_TITLE));
        dataPenel.add(populationRate);
        populationRate.setText("");

    }

    public void setAlpha(float alpha) {
        this.composite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                alpha);
        this.alpha = alpha;
        repaint();
    }

    /**
     * 调试用的main函数，可能导致错误，请勿运行
     * 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame();
        InfoBoard board = new InfoBoard();
        board.setLocation(0, 600 - 280);// test
        board.setBackImage(ImageIO.read(new File("images/info_board.png")));
        board.setAlpha(0.3f);
        frame.getContentPane().add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setMinimumSize(new Dimension(Config
                .getInt(ConfConsts.FRAME_WIDTH), Config
                .getInt(ConfConsts.FRAME_HEIGHT)));
        frame.pack();
        frame.setVisible(true);
    }

    public void setBackImage(Image image) {
        this.bkImg = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (bkImg != null) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setComposite(composite);
            g2.drawImage(bkImg, 0, 0, null);
        }
    }
}
