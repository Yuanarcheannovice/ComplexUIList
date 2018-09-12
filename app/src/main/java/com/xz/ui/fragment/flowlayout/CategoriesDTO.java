package com.xz.ui.fragment.flowlayout;

import java.util.List;

public class CategoriesDTO {
    private long id;
    /**
     * 大分类的名称
     */
    private String name;
    /**
     * 小分类
     */
    private List<String> tags;

    public CategoriesDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public CategoriesDTO(long id, String name, List<String> tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }
}
