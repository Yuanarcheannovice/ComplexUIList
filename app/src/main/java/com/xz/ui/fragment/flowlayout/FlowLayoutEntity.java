package com.xz.ui.fragment.flowlayout;

public class FlowLayoutEntity
{
    public boolean isBigType;
    public String name;

    public FlowLayoutEntity() {
    }

    public boolean isBigType() {
        return isBigType;
    }

    public void setBigType(boolean bigType) {
        isBigType = bigType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FlowLayoutEntity(boolean isBigType, String name) {
        this.isBigType = isBigType;
        this.name = name;
    }
}
