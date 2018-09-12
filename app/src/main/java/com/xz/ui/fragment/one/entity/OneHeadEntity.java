package com.xz.ui.fragment.one.entity;

/**
 * Created by DEV on 2018/3/15.
 */

public class OneHeadEntity {
    private String tv1Txt;

    private String tv2Txt;

    private String tv3Txt;

    private String tv4Txt;

    public OneHeadEntity() {
    }

    public OneHeadEntity(String tv1Txt, String tv2Txt, String tv3Txt, String tv4Txt) {
        this.tv1Txt = tv1Txt;
        this.tv2Txt = tv2Txt;
        this.tv3Txt = tv3Txt;
        this.tv4Txt = tv4Txt;
    }

    public String getTv1Txt() {
        return tv1Txt;
    }

    public void setTv1Txt(String tv1Txt) {
        this.tv1Txt = tv1Txt;
    }

    public String getTv2Txt() {
        return tv2Txt;
    }

    public void setTv2Txt(String tv2Txt) {
        this.tv2Txt = tv2Txt;
    }

    public String getTv3Txt() {
        return tv3Txt;
    }

    public void setTv3Txt(String tv3Txt) {
        this.tv3Txt = tv3Txt;
    }

    public String getTv4Txt() {
        return tv4Txt;
    }

    public void setTv4Txt(String tv4Txt) {
        this.tv4Txt = tv4Txt;
    }
}
