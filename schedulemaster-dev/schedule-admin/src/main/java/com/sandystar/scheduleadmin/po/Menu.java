package com.sandystar.scheduleadmin.po;

import java.io.Serializable;

public class Menu implements Serializable {

    private int id;

    private String title;

    private String icon;

    private String url;

    private Menu [] children;

    public Menu[] getChildren() {
        return children;
    }

    public void setChildren(Menu[] children) {
        this.children = children;
    }

    public Menu(int id, String title, String icon, String url, Menu[] children) {
        this.id = id;
        this.title = title;
        this.icon = icon;
        this.url = url;
        this.children = children;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
