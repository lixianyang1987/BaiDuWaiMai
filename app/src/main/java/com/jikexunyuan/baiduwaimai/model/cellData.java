package com.jikexunyuan.baiduwaimai.model;

/**
 * Created by Administrator on 2015/11/16.
 */
public class cellData {

   public cellData(String contetnt, int imgId){
       this.tvContent=contetnt;
       this.imgId =imgId;
   }
    public String tvContent;
    public int imgId;

    public double lv;
    public String ctName;
    public String ctContent;
    public int ctXl;
    public int ctImg;

    public cellData(double lv, String ctName, String ctContent, int ctXl, int ctImg) {
        this.lv = lv;
        this.ctName = ctName;
        this.ctContent = ctContent;
        this.ctXl = ctXl;
        this.ctImg = ctImg;
    }

}
