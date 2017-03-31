package com.example.mobility.materialme;

/**
 * Created by Mobility on 30/03/17.
 */

public class Sports {
    private final String sportTitle;
   private final  String sportInfo;
    private final int imageResource;
    public Sports(String sportTitle, String sportInfo, int imageResource) {
        this.sportTitle = sportTitle;
        this.sportInfo = sportInfo;
        this.imageResource = imageResource;
    }
    public String getSportTitle() {
        return sportTitle;
    }

    public String getSportInfo() {
        return sportInfo;
    }

    public int getImageResource() {
        return imageResource;
    }
}