package com.example.assignmentconzumex.model;

import java.util.List;

public class Sections {

    List<Elements> elements;
    String sectionId;

    @Override
    public String toString() {
        return "Sections{" +
                "elements=" + elements +
                ", sectionId='" + sectionId + '\'' +
                '}';
    }

    public Sections() {
    }

    public Sections(List<Elements> elements, String sectionId) {
        this.elements = elements;
        this.sectionId = sectionId;
    }

    public List<Elements> getElements() {
        return elements;
    }

    public void setElements(List<Elements> elements) {
        this.elements = elements;
    }

    public String getSectionId() {
        return sectionId;
    }

    public void setSectionId(String sectionId) {
        this.sectionId = sectionId;
    }
}
