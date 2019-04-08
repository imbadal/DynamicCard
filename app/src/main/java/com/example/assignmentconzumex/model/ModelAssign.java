package com.example.assignmentconzumex.model;

import java.util.List;

public class ModelAssign {

    Background background;
    String cardId;
    String cardType;
    ExpandedData expandedData;
    List<Sections> sections;

    public ModelAssign() {
    }

    public ModelAssign(Background background, String cardId, String cardType, ExpandedData expandedData, List<Sections> sections) {
        this.background = background;
        this.cardId = cardId;
        this.cardType = cardType;
        this.expandedData = expandedData;
        this.sections = sections;
    }

    public Background getBackground() {
        return background;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public ExpandedData getExpandedData() {
        return expandedData;
    }

    public void setExpandedData(ExpandedData expandedData) {
        this.expandedData = expandedData;
    }

    public List<Sections> getSections() {
        return sections;
    }

    @Override
    public String toString() {
        return "ModelAssign{" +
                "background=" + background +
                ", cardId='" + cardId + '\'' +
                ", cardType='" + cardType + '\'' +
                ", expandedData=" + expandedData +
                ", sections=" + sections +
                '}';
    }

    public void setSections(List<Sections> sections) {
        this.sections = sections;
    }
}

