package com.xz.ui.fragment.flowlayout;

import java.util.List;

public class FlowLayoutJsonDto {

    /**
     * data : [{"id":1,"name":"年代","tags":["先秦","汉朝","魏晋","南北朝","隋朝","唐朝","宋朝","金朝","辽朝","元朝","明朝","清朝","近当代","五代"]},{"id":2,"name":"教材同步","tags":["小学一年级","小学二年级","小学三年级","小学四年级","小学五年级","小学六年级","初中一年级","初中二年级","初中三年级"]},{"id":3,"name":"语种","tags":["中文诗","外文诗"]}]
     * code : 0
     */

    private int code;
    private List<CategoriesDTO> data;


    public FlowLayoutJsonDto(int code, List<CategoriesDTO> data) {
        this.code = code;
        this.data = data;
    }

    public FlowLayoutJsonDto() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<CategoriesDTO> getData() {
        return data;
    }

    public void setData(List<CategoriesDTO> data) {
        this.data = data;
    }
}
