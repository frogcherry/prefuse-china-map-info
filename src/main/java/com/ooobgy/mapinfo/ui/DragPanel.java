package com.ooobgy.mapinfo.ui;

import java.awt.Component;
import java.util.HashSet;
import java.util.Set;

import javax.swing.JPanel;

public class DragPanel extends JPanel{
    
    private static final long serialVersionUID = 6403913590888427808L;
    private Set<Component> dragableItems = new HashSet<Component>();
    
    public DragPanel() {
        // TODO Auto-generated constructor stub
    }
    
    public void addDragableItem(Component component){
        this.dragableItems.add(component);
    }
}
