package com.bluesky.classmate.bean;

import java.io.Serializable;

/**
 * @author BlueSky
 * @date 2022/4/11
 * Description:
 */
public class Sence implements Serializable {
    String name;
    String path;

    public Sence(String name, String path) {
        this.name = name;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
