package com.kxyu.docMaker;

import com.kxyu.docMaker.common.Constant;
import com.kxyu.docMaker.common.ConstantMap;
import com.kxyu.docMaker.docDatas.ChemotherapyData;
import com.kxyu.docMaker.docDatas.QcDatas;
import com.kxyu.docMaker.utils.StringUtils;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.poi.util.StringUtil;

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
   *
   **/
    public static String mBrca1Txt = "";

    public static String mBrca2Txt = "";

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

                            mBrca1Txt += HandlePathogenicTxt(tmp[7], true);
                            break;
                        case Constant.BRCA_TWO_GENE:
                            mBrca2Pathogenic += 1;

                            mBrca2Txt += HandlePathogenicTxt(tmp[7], false);
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

    /**
     *
     * TODO: indel  snp  ins
     */
    /* *
     * @author kxyuyuyu
     * @date 2018/2/7 15:27
     * @param    Brca1 is true
     * @return
     */
    public static String HandlePathogenicTxt (String mutectionStr, boolean isBrca1){

       if(mutectionStr.isEmpty() || mutectionStr.equals("")){
           return "";
       }
       String txt = "";
       String pStr  = mutectionStr.replace("\n", "");
       if(mutectionStr.contains("del")){
           //编码区XXXX位置的X个碱基缺失突变，影响蛋白质功能
            String[] tmp  = pStr.split(":");
            String[] tmp1 = tmp[1].split(" ");

           //编码区位置
            tmp1[1].replace("_", "-");
            tmp1[1].replace("del", "");

            //缺失数
            String count   = String.valueOf(tmp1[2].length());

           txt             = "，编码区" + tmp1[1] + "位置的" + count + "个碱基缺失突变，影响蛋白功能";

            return txt;
        } else if(mutectionStr.contains("ins")){
           //编码区XXXX位置的X个碱基插入突变，影响蛋白质功能
           String[] tmp    = pStr.split(":");
           String[] tmp1   = tmp[1].split(" ");

           //编码区位置
           tmp1[1].replace("_", "-");
           tmp1[1].replace("ins", "");

           //缺失数
           String count   = String.valueOf(tmp1[2].length());

           txt            = "，编码区" + tmp1[1] + "位置的" + count + "个碱基插入突变，影响蛋白功能";
           return txt;
        }else {
           //编码区XXXX位置XX氨基酸变为XXX氨基酸，为致病突变
           String[] tmp   = pStr.split(":");

           String[] tmp1  = tmp[1].split(" ");


           //Del AGCT
           String tmpStr = tmp[1];
           tmpStr = tmpStr.replace("T", "");
           tmpStr = tmpStr.replace("A", "");
           tmpStr = tmpStr.replace("C", "");
           tmpStr = tmpStr.replace("G", "");
           tmpStr = tmpStr.replace(">", "");
           tmpStr = tmpStr.replace("c.", "");


           String oldA         = ConstantMap.mAaMap.get(tmp[2].charAt(2));
           String newA         = ConstantMap.mAaMap.get(tmp[2].charAt(tmp[2].length()-1));
           txt                 = "，编码区"+tmpStr+"位置"+ oldA + "变为" + newA +",为致病突变";

       }
       return txt;
    }
}
