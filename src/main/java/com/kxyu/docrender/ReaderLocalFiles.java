package com.kxyu.docrender;

import com.kxyu.docrender.docDatas.ChemotherapyData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 9:54 2018/1/18
 */
public class ReaderLocalFiles {

    public static String txt2String(File file){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行

                result.append(System.lineSeparator()+s);
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }

    public static ArrayList<ChemotherapyData> txt2String1(ArrayList<ChemotherapyData> arrayList, File file){

        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                String[] tmp = s.trim().split("\t");

                    if (tmp.length <6 || s.contains("Evidence_level")){
                        continue;
                    }

                arrayList.add(new ChemotherapyData(tmp[0], tmp[1], tmp[2], tmp[3], tmp[4], tmp[5], tmp[6]));
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }
}
