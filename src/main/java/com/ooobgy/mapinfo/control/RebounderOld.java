package com.ooobgy.mapinfo.control;

import java.awt.Component;
import java.awt.Point;

/**
 * 反弹效果线程 <b>created:</b> 2012-3-8
 * 
 * @author 周晓龙 frogcherry@gmail.com
 */
public class RebounderOld implements Runnable {
    private static final int ANIM_TIME = 500;// animation (ms)
    public static final int ANIM_FRM = 10;// 动画帧数
    private volatile boolean isRunning = false;
    private Component actor;
    private Point destination;

    public RebounderOld(Component c, Point destination) {
        this.actor = c;
        this.destination = destination;
    }

    public void shutdown() {
        isRunning = false;
    }

    @Override
    public void run() {
        isRunning = true;
        Point originLoc = (Point) actor.getLocation().clone();
        int dx = (originLoc.x - destination.x) / ANIM_FRM;
        int dy = (originLoc.y - destination.y) / ANIM_FRM;
//        System.out.println(dx + "#" + dy);
        final int sleepTime = ANIM_TIME / ANIM_FRM;
        int presentX = originLoc.x;
        int presentY = originLoc.y;
        try {
            for (int i = 0; i < ANIM_FRM; i++) {
                if (!isRunning) {
                    return;
                }
                Thread.sleep(sleepTime);
                presentX -= dx;
                presentY -= dy;
                actor.setLocation(presentX, presentY);
                System.out.println(actor.getLocation());
            }
        } catch (InterruptedException e) {
            shutdown();
            e.printStackTrace();
        }

        actor.setLocation(destination);
    }

}
