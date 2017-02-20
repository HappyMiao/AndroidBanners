package com.view.cycleview;

/**
 * @className: CycleModel
 * @classDescription: 广告图模型
 * @author: miao
 * @createTime: 2017年2月20日
 */
public class CycleModel {

    //图片地址
    private String picURL;
    //标题
    private String title;

    public CycleModel(String picURL){
        this.picURL = picURL;
    }

    public CycleModel(){}

    public String getPicURL() {
        return picURL;
    }

    public void setPicURL(String picURL) {
        this.picURL = picURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
