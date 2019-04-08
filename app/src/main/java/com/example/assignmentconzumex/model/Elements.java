package com.example.assignmentconzumex.model;

import java.util.List;

public class Elements {

    String align;
    List<Data> data;
    String direction;
    String elementId;

    @Override
    public String toString() {
        return "Elements{" +
                "align='" + align + '\'' +
                ", data=" + data +
                ", direction='" + direction + '\'' +
                ", elementId='" + elementId + '\'' +
                '}';
    }

    public Elements() {
    }

    public Elements(String align, List<Data> data, String direction, String elementId) {
        this.align = align;
        this.data = data;
        this.direction = direction;
        this.elementId = elementId;
    }

    public String getAlign() {
        return align;
    }

    public void setAlign(String align) {
        this.align = align;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }
}
