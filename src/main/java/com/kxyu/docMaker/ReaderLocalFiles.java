package com.kxyu.docMaker;

import com.kxyu.docMaker.common.Constant;
import com.kxyu.docMaker.docDatas.ChemotherapyData;
import com.kxyu.docMaker.docDatas.QcDatas;

import java.io.*;
import java.util.ArrayList;

public class ReaderLocalFiles {

    /* *
     * @author kxyu
     * @date 2018/1/25 13:28
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

    /* *
     * @author kxyu
     * @date 2018/1/25 13:29
     * @param   ArrayList<ChemotherapyData> 化疗药数据链表 File  化疗药物数据库文件
     * @return
     */
    public static ArrayList<ChemotherapyData> readChemotherapyData( ArrayList<ChemotherapyData> arrayList, File file){

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = br.readLine())!=null){
                String[] tmp = s.trim().split("\t");
                if (tmp.length < Constant.CHEMOTHERAPY_JUDGE_INT || s.contains(Constant.CHEMOTHERAPY_JUDGE_STR)){
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

    public static ArrayList<Object> readChemotherapyData1( ArrayList<Object> arrayList, File file){

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = br.readLine())!=null){
                String[] tmp = s.trim().split("\t");
                if (tmp.length < Constant.CHEMOTHERAPY_JUDGE_INT || s.contains(Constant.CHEMOTHERAPY_JUDGE_STR)){
                    continue;
                }
                arrayList.add((tmp[0]+";"+tmp[1]+";"+tmp[2]+";"+tmp[3]+";"+tmp[4]+";"+tmp[5]+";"+tmp[6]));
            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return arrayList;
    }

    /* *
     * @author kxyu
     * @date 2018/1/25 13:30
     * @param  测序质控数据 肿瘤  对照组
     * @return   质控数据
     */
    public static QcDatas readQcDatas(QcDatas qcDatas, File cancerFile, File controlFile) throws IOException {

        //read cancer QC datas
        readSingleQCFile(qcDatas, cancerFile, Constant.QC_IS_CANCER);
        readSingleQCFile(qcDatas, controlFile, Constant.QC_IS_CONTROL);
        return qcDatas;
    }

    private static void readSingleQCFile(QcDatas qcDatas, File file,Boolean isCancer) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s= null;
        while((s = br.readLine())!=null){//使用readLine方法，一次读一行
            String[] tmp = s.trim().split("\t");
            if(isCancer) {
                    if (s.contains(Constant.QC_TOTAL_READS)) {
                        qcDatas.setmCancerDatasSize(tmp[1]);
                    } else if (s.contains(Constant.QC_PROPERLY_MAPPED)) {
                        qcDatas.setmCancerMapped(tmp[1]);
                    } else if (s.contains(Constant.QC_TARGET_REGION)) {
                        qcDatas.setmCancerTargetRegion(tmp[1]);
                    } else if (s.contains(Constant.QC_TOTAL_EFFECTIVE_YIELD)) {
                        qcDatas.setmCancerTotalEffectiveYield(tmp[1]);
                    } else if (s.contains(Constant.QC_EFFECTIVE_YIELD_ON_TARGET)) {
                        qcDatas.setmCancerEffectiveYieldOnTarget(tmp[1]);
                    } else if (s.contains(Constant.QC_AVERAGE_SEQUENCE)) {
                        qcDatas.setmCancerAverageSequenceDepths(tmp[1]);
                    } else if (s.contains(Constant.QC_COVERAGE)) {
                        qcDatas.setmCancerCoverage(tmp[1]);
                    }
            }else {
                    if (s.contains(Constant.QC_TOTAL_READS)) {
                        qcDatas.setmControlDataSize(tmp[1]);
                    } else if (s.contains(Constant.QC_PROPERLY_MAPPED)) {
                        qcDatas.setmControlMapped(tmp[1]);
                    } else if (s.contains(Constant.QC_TARGET_REGION)) {
                        qcDatas.setmControlTargetRegion(tmp[1]);
                    } else if (s.contains(Constant.QC_TOTAL_EFFECTIVE_YIELD)) {
                        qcDatas.setmControlTotalEffectiveYield(tmp[1]);
                    } else if (s.contains(Constant.QC_EFFECTIVE_YIELD_ON_TARGET)) {
                        qcDatas.setmControlEffectiveYieldOnTarget(tmp[1]);
                    } else if (s.contains(Constant.QC_AVERAGE_SEQUENCE)) {
                        qcDatas.setmControlAverageSequenceDepths(tmp[1]);
                    } else if (s.contains(Constant.QC_COVERAGE)) {
                        qcDatas.setmControlCoverage(tmp[1]);
                    }
            }
        }
    }

}
