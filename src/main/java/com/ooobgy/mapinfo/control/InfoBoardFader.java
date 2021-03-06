package com.ooobgy.mapinfo.control;

import java.util.List;

import javax.swing.SwingWorker;

import com.ooobgy.mapinfo.conf.Config;
import com.ooobgy.mapinfo.consts.ConfConsts;
import com.ooobgy.mapinfo.ui.InfoBoard;

/**
 * 省份信息板的透明隐藏动画效果<br>
 * <b>created:</b> 2012-3-9
 * @see InfoBoard
 * @author 周晓龙 frogcherry@gmail.com
 */
public class InfoBoardFader extends SwingWorker<Float, Float> {
    private InfoBoard infoBoard;
    private static final int ANIM_TIME = Config.getInt(ConfConsts.FADE_TIME);// animation (ms)
    public static final int ANIM_FRM = Config.getInt(ConfConsts.FADE_FRAMES);// 动画帧数

    public InfoBoardFader(InfoBoard infoBoard) {
        super();
        this.infoBoard = infoBoard;
    }

    @Override
    protected Float doInBackground() throws Exception {
        final int sleepTime = ANIM_TIME / ANIM_FRM;
        float da = 1.0f / ANIM_FRM;
        float alpha = 1.0f;
        for (int i = 0; i < ANIM_FRM; i++) {
            Thread.sleep(sleepTime);
            alpha -= da;
            if (alpha > 1.0f || alpha < 0.0f) {
                break;
            }
            publish(alpha);
        }

        return 0.0f;
    }

    @Override
    protected void process(List<Float> chunks) {
        for (Float alpha : chunks) {
            if (!isCancelled()) {
                this.infoBoard.setAlpha(alpha);
            }
        }

    }

    @Override
    protected void done() {
        //this.infoBoard.setVisible(false);
    }
    
    
}
