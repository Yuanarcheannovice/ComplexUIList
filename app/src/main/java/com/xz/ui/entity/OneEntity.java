package com.xz.ui.entity;

/**
 * Created by DEV on 2018/3/15.
 */

public class OneEntity {
    /**
     * item的标识，
     */
    private int itemTag;

    private OneHeadEntity oneHead;

    private OneTitleEntity oneTitle;

    private OneGrid1Entity oneGrid1;

    private OneGrid2Entity oneGrid2;

    private OneGrid3Entity oneGrid3;



    public OneHeadEntity getOneHead() {
        return oneHead;
    }

    public void setOneHead(OneHeadEntity oneHead) {
        this.oneHead = oneHead;
    }

    public OneTitleEntity getOneTitle() {
        return oneTitle;
    }

    public void setOneTitle(OneTitleEntity oneTitle) {
        this.oneTitle = oneTitle;
    }

    public OneGrid1Entity getOneGrid1() {
        return oneGrid1;
    }

    public void setOneGrid1(OneGrid1Entity oneGrid1) {
        this.oneGrid1 = oneGrid1;
    }

    public OneGrid2Entity getOneGrid2() {
        return oneGrid2;
    }

    public void setOneGrid2(OneGrid2Entity oneGrid2) {
        this.oneGrid2 = oneGrid2;
    }

    public OneGrid3Entity getOneGrid3() {
        return oneGrid3;
    }

    public void setOneGrid3(OneGrid3Entity oneGrid3) {
        this.oneGrid3 = oneGrid3;
    }

    public int getItemTag() {
        return itemTag;
    }

    public void setItemTag(int itemTag) {
        this.itemTag = itemTag;
    }




}
