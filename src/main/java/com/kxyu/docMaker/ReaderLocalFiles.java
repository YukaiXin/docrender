package com.kxyu.docMaker;

import com.kxyu.docMaker.docDatas.ChemotherapyData;
import com.kxyu.docMaker.docDatas.QcDatas;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReaderLocalFiles {

    /**
     * 读取txt文件的内容
     * @param file 想要读取的文件对象
     * @return 返回文件内容
     */
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

    public static ArrayList<ChemotherapyData> txt2String1( ArrayList<ChemotherapyData> arrayList, File file){

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

    public static QcDatas readQcDatas(QcDatas qcDatas, File cancerFile, File controlFile) throws IOException {

        //read cancer QC datas

        BufferedReader cancerbr = new BufferedReader(new FileReader(cancerFile));
        BufferedReader controlbr = new BufferedReader(new FileReader(controlFile));
        String s= null;
        while((s = cancerbr.readLine())!=null){//使用readLine方法，一次读一行
            String[] tmp = s.trim().split("\t");

            if (s.contains("Total reads")){
                qcDatas.setmCancerDatasSize(tmp[1]);
            }else if(s.contains("Properly mapped")){
                qcDatas.setmCancerMapped(tmp[1]);
            }else if(s.contains("Target region")) {
                qcDatas.setmCancerTargetRegion(tmp[1]);
            }else if(s.contains("Total effective yield")){
                qcDatas.setmCancerTotalEffectiveYield(tmp[1]);
            }else if(s.contains("Effective yield on target")){
                qcDatas.setmCancerEffectiveYieldOnTarget(tmp[1]);
            }else if(s.contains("Average sequence")){
                qcDatas.setmCancerAverageSequenceDepths(tmp[1]);
            }else if(s.contains("coverage")){
                qcDatas.setmCancerCoverage(tmp[1]);
            }
        }

        s = null;
        while((s = controlbr.readLine())!=null){//使用readLine方法，一次读一行
            String[] tmp = s.trim().split("\t");

            if (s.contains("Total reads")){
                qcDatas.setmControlDataSize(tmp[1]);
            }else if(s.contains("Properly mapped")){
                qcDatas.setmControlMapped(tmp[1]);
            }else if(s.contains("Target region")) {
                qcDatas.setmControlTargetRegion(tmp[1]);
            }else if(s.contains("Total effective yield")){
                qcDatas.setmControlTotalEffectiveYield(tmp[1]);
            }else if(s.contains("Effective yield on target")){
                qcDatas.setmControlEffectiveYieldOnTarget(tmp[1]);
            }else if(s.contains("Average sequence")){
                qcDatas.setmControlAverageSequenceDepths(tmp[1]);
            }else if(s.contains("coverage")){
                qcDatas.setmControlCoverage(tmp[1]);
            }
        }
        return qcDatas;
    }


}