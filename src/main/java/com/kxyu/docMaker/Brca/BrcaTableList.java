package com.kxyu.docMaker.Brca;

import java.util.ArrayList;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 13:34 2018/2/1
 */
public class BrcaTableList {

    private static  BrcaTableList instance = null;

    public  ArrayList<Object> mBrcaPathogenicTable;

    public  ArrayList<Object> mBrcaUnKnownTable;

    public  ArrayList<Object> mBrcaBenignTable;

  public static synchronized BrcaTableList getInstance(){
      if (instance == null){
          instance = new BrcaTableList();
      }
      return instance;
  }

    private BrcaTableList() {
        mBrcaBenignTable = new ArrayList<Object>();
        mBrcaUnKnownTable = new ArrayList<Object>();
        mBrcaPathogenicTable = new ArrayList<Object>();
    }
}
