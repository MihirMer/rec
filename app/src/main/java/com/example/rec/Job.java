package com.example.rec;

public class Job {
    private int logo;
    private String title;
    private String desc;

    public Job() {
    }

    public Job(int logo, String title, String desc) {
        this.logo = logo;
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
