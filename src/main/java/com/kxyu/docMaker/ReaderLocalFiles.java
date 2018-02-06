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

    public static int mBrca1NoSi = 0;
    public static int mBrca2NoSi = 0;

    public static int mBrca1Begin = 0;
    public static int mBrca2Begin = 0;

    public static int mBrca1Pathogenic = 0;
    public static int mBrca2Pathogenic = 0;


  /* *
   * @author kxyuyuyu
   * @date 2018/2/6 9:56
   * @param
   * @return
   * 6.基因  7.突变名称  8.基因型  9.dbsnp  10.临床意义
   */
    public static void readBrcaData(BrcaTableList brcaTableList, File file){

        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            while((s = br.readLine())!=null){
                String[] tmp = s.trim().split("\t");

                if (tmp.length < 29){
                    continue;
                }

                String tmpString = tmp[10].toLowerCase();

                if(tmp[7].equals(Constant.BRCA_JUDGE_POINT) && !tmpString.contains(Constant.BRCA_JUDGE_PATHOGENIC) ){
                    continue;
                }

                /**待确认
                 *
                 ***/
                if(tmpString.contains(Constant.BRCA_JUDGE_BENGIN) && tmpString.contains(Constant.BRCA_JUDGE_UNCERTAIN_SIGNIFICANCE)){
                    brcaTableList.mBrcaBenignTable.add((tmp[6]+";"+tmp[7]+";"+tmp[8]+";"+tmp[9]+";"+ tmp[10] + "\n" + Constant.BRCA_NO_CONFIRM));
                    continue;
                }

                /**
                 *  无意义
                 * **/
                if((!tmpString.contains(Constant.BRCA_JUDGE_BENGIN)) && tmpString.contains(Constant.BRCA_JUDGE_UNCERTAIN_SIGNIFICANCE)){
                    brcaTableList.mBrcaUnKnownTable.add((tmp[6]+";"+tmp[7]+";"+tmp[8]+";"+tmp[9]+";"+ tmp[10] + "\n" + Constant.BRCA_NO_SIGNIFICANCE));

                    switch (tmp[6]){
                        case Constant.BRCA_ONE_GENE:
                            mBrca1NoSi += 1;
                            break;
                        case Constant.BRCA_TWO_GENE:
                            mBrca2NoSi += 1;
                            break;
                    }
                    continue;
                }

                /***
                 * 良性
                 * */
                if((tmpString.contains(Constant.BRCA_JUDGE_BENGIN)) && (!tmpString.contains(Constant.BRCA_JUDGE_UNCERTAIN_SIGNIFICANCE))){
                    brcaTableList.mBrcaBenignTable.add((tmp[6]+";"+tmp[7]+";"+tmp[8]+";"+tmp[9]+";"+ tmp[10] + "\n" + Constant.BRCA_BENGIN));

                    switch (tmp[6]){
                        case Constant.BRCA_ONE_GENE:
                            mBrca1Begin += 1;
                            break;
                        case Constant.BRCA_TWO_GENE:
                            mBrca2Begin += 1;
                            break;
                    }
                    continue;
                }

                if(tmpString.contains(Constant.BRCA_JUDGE_PATHOGENIC)){
                    brcaTableList.mBrcaPathogenicTable.add((tmp[6]+";"+tmp[7]+";"+tmp[8]+";"+tmp[9]+";"+ tmp[10] + "\n" + Constant.BRCA_STR_PATHOGENIC));

                    switch (tmp[6]){
                        case Constant.BRCA_ONE_GENE:
                            mBrca1Pathogenic += 1;
                            break;
                        case Constant.BRCA_TWO_GENE:
                            mBrca2Pathogenic += 1;
                            break;
                    }
                    continue;
                }

                brcaTableList.mBrcaBenignTable.add((tmp[6]+";"+tmp[7]+";"+tmp[8]+";"+tmp[9]+";"+ tmp[10]));
            }

            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
