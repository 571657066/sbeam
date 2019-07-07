package com.sbeam.dto;

import java.util.List;

public class ArrayListVo {

    private List<Object> unIds;

    public ArrayListVo() {
    }

    public ArrayListVo(List<Object> unIds) {
        this.unIds = unIds;
    }

    public List<Object> getUnIds() {
        return unIds;
    }

    public void setUnIds(List<Object> unIds) {
        this.unIds = unIds;
    }

    @Override
    public String toString() {
        return "ArrayListVo{" +
                "unIds=" + unIds +
                '}';
    }
}