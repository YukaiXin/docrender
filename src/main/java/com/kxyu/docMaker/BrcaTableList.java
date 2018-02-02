package com.kxyu.docMaker;

import java.util.ArrayList;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 13:34 2018/2/1
 */
public class BrcaTableList {

    public ArrayList<Object> mBrcaPathogenicTable;

    public ArrayList<Object> mBrcaUnKnownTable;

    public ArrayList<Object> mBrcaBenignTable;

    public ArrayList<Object> getmBrcaPathogenicTable() {
        return mBrcaPathogenicTable;
    }

    public void setmBrcaPathogenicTable(ArrayList<Object> mBrcaPathogenicTable) {
        this.mBrcaPathogenicTable = mBrcaPathogenicTable;
    }

    public ArrayList<Object> getmBrcaUnKnownTable() {
        return mBrcaUnKnownTable;
    }

    public void setmBrcaUnKnownTable(ArrayList<Object> mBrcaUnKnownTable) {
        this.mBrcaUnKnownTable = mBrcaUnKnownTable;
    }

    public ArrayList<Object> getmBrcaBenignTable() {
        return mBrcaBenignTable;
    }

    public void setmBrcaBenignTable(ArrayList<Object> mBrcaBenignTable) {
        this.mBrcaBenignTable = mBrcaBenignTable;
    }

    public BrcaTableList() {
        mBrcaBenignTable = new ArrayList<Object>();
        mBrcaUnKnownTable = new ArrayList<Object>();
        mBrcaPathogenicTable = new ArrayList<Object>();
    }
}
