package com.example.assignmentconzumex;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailsListPojo {

    @SerializedName("Details")
    @Expose
    private List<Detail> detailList = null;

    public List<Detail> getDetailList() {
        return detailList;
    }

    public void setdetailList(List<Detail> detailList) {
        this.detailList = detailList;
    }

}
