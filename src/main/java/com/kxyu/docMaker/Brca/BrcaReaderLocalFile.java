package com.kxyu.docMaker.Brca;

import com.kxyu.docMaker.common.ConstantMap;
import com.kxyu.docMaker.utils.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 9:50 2018/2/8
 */
public class BrcaReaderLocalFile {

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

                if (s.contains("UMD") || s.contains("CLINSIG")){
                    continue;
                }
                String[] tmp = s.trim().split("\t");

                //UMD   11z

                String umdStr = tmp[11];
                if (umdStr.equals(Constant.BRCA_CMD_NONE) || umdStr.contains(Constant.BRCA_CMD_STAR)){

                    //CLinsig
                    if(tmp[7].equals(Constant.BRCA_JUDGE_POINT) && !tmp[10].contains(Constant.BRCA_JUDGE_PATHOGENIC) ){
                        continue;
                    }

                    /**待确认
                     *
                     ***/
                    if(tmp[10].contains(Constant.BRCA_JUDGE_BENGIN) && tmp[10].contains(Constant.BRCA_JUDGE_UNCERTAIN_SIGNIFICANCE)){

                        //Benign  Likely benign  Likely pathogenic
                        int mBenignCount = 0;
                        int mLikelyBenignCount = 0;
                        int mLikelyPathogenicCount = 0;
                        int mPathogenicCount = 0;

                        if (tmp[10].contains(Constant.BRCA_JUDGE_BENGIN)){
                            mBenignCount = StringUtils.getOccur(tmp[10], Constant.BRCA_JUDGE_BENGIN);
                        }
                        if (tmp[10].contains(Constant.BRCA_JUDGE_LIKELY_BENIGN)){
                            mLikelyBenignCount = StringUtils.getOccur(tmp[10], Constant.BRCA_JUDGE_LIKELY_BENIGN);
                        }
                        if (tmp[10].contains(Constant.BRCA_Likely_PATHOGENIC)){
                            mLikelyPathogenicCount = StringUtils.getOccur(tmp[10], Constant.BRCA_Likely_PATHOGENIC);
                        }
                        if (tmp[10].contains(Constant.BRCA_JUDGE_PATHOGENIC)){
                            mPathogenicCount = StringUtils.getOccur(tmp[10], Constant.BRCA_JUDGE_PATHOGENIC);
                        }


                        //良性
                        if (mBenignCount >= mLikelyBenignCount && mBenignCount > mPathogenicCount && mBenignCount > mLikelyPathogenicCount) {
                            BrcaBeginCount(brcaTableList, tmp, Constant.BRCA_BENGIN);
                        }else if (mLikelyBenignCount > mBenignCount && mLikelyBenignCount > mPathogenicCount && mLikelyBenignCount > mLikelyPathogenicCount){
                        //疑似良性
                            BrcaBeginCount(brcaTableList, tmp, Constant.BRCA_Likely_Benign);
                        }else if (mPathogenicCount >= mLikelyPathogenicCount && mPathogenicCount > mBenignCount && mPathogenicCount > mLikelyBenignCount){
                        //致病
                            BrcaPathogenicCount(brcaTableList, tmp, Constant.BRCA_JUDGE_PATHOGENIC);
                        }else if (mLikelyPathogenicCount > mPathogenicCount && mLikelyPathogenicCount > mBenignCount && mLikelyPathogenicCount > mLikelyBenignCount){
                        //疑似致病
                            BrcaPathogenicCount(brcaTableList, tmp, Constant.BRCA_Likely_PATHOGENIC);
                        }else {
                        //待确认
                            brcaTableList.mBrcaUnKnownTable.add((tmp[6]+";"+tmp[7]+";"+tmp[8]+";"+tmp[9]+";" + Constant.BRCA_NO_SIGNIFICANCE));
                        }
                        continue;
                    }

                    /**
                     *  意义未明
                     * **/
                    if(((!tmp[10].contains(Constant.BRCA_JUDGE_BENGIN)) && tmp[10].contains(Constant.BRCA_JUDGE_UNCERTAIN_SIGNIFICANCE)) || tmp[10].equals(".")){

                        BrcaNoSiCount(brcaTableList, tmp, Constant.BRCA_NO_SIGNIFICANCE);

                        continue;
                    }

                    /***
                     * 良性
                     * */
                    if((tmp[10].contains(Constant.BRCA_JUDGE_BENGIN))){
                        if(!tmp[10].contains(Constant.BRCA_JUDGE_UNCERTAIN_SIGNIFICANCE)) {
                            BrcaBeginCount(brcaTableList, tmp, Constant.BRCA_BENGIN);
                            continue;
                        }

                    }

                    if(tmp[10].contains(Constant.BRCA_JUDGE_PATHOGENIC)){

                        BrcaPathogenicCount(brcaTableList, tmp, Constant.BRCA_STR_PATHOGENIC);

                        continue;
                    }

                    brcaTableList.mBrcaBenignTable.add((tmp[6]+";"+tmp[7]+";"+tmp[8]+";"+tmp[9]+";"+ tmp[10]));

                }else {

                    switch (umdStr){
                        case Constant.BRCA_CMD_NEUTRAL:

                            BrcaBeginCount(brcaTableList, tmp,  Constant.BRCA_BENGIN);

                            break;
                        case Constant.BRCA_CMD_LIKELY_NEUTRAL:

                            BrcaBeginCount(brcaTableList, tmp,  Constant.BRCA_Likely_Benign);

                            break;
                        case Constant.BRCA_CMD_UV:

                            BrcaNoSiCount(brcaTableList, tmp, Constant.BRCA_NO_SIGNIFICANCE);

                            break;
                        case Constant.BRCA_CMD_LIKELY_CAUSAL:


                            BrcaPathogenicCount(brcaTableList, tmp, Constant.BRCA_Likely_PATHOGENIC);
                            break;
                        case Constant.BRCA_CMD_CAUSAL:

                            BrcaPathogenicCount(brcaTableList, tmp, Constant.BRCA_STR_PATHOGENIC);

                            break;
                    }

                }

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
    public static String HandlePathogenicTxt (String mutectionStr, String genotype, boolean isBrca1){

        if(mutectionStr.isEmpty() || mutectionStr.equals("")){
            return "";
        }
        String txt = "";
        String pStr  = mutectionStr.replace("\n", "");
        if(mutectionStr.contains("del")){
            //编码区XXXX位置的X个碱基缺失突变，影响蛋白质功能
            String[] tmp  = pStr.split(":");

            String mTmpVar = tmp[1];
            //编码区位置
            mTmpVar = mTmpVar.replace("_", "-");
            mTmpVar = mTmpVar.replace("del", "");
            mTmpVar = mTmpVar.replace("c.", "");

            //缺失数

            String mTmpGenotype  = genotype.replace("/-","");
            String count   = String.valueOf(mTmpGenotype.length());

            txt             = "，编码区" + mTmpVar + "位置的" + count + "个碱基缺失突变，影响蛋白功能";

            return txt;
        } else if(mutectionStr.contains("ins")){
            //编码区XXXX位置的X个碱基插入突变，影响蛋白质功能
            String[] tmp    = pStr.split(":");

            String mTmpVar = tmp[1];
            //编码区位置
            mTmpVar = mTmpVar.replace("_", "-");
            mTmpVar = mTmpVar.replace("ins", "");
            mTmpVar = mTmpVar.replace("c.", "");


            //缺失数

            String mTmpGenotype  = genotype.replace("/-","");
            String count   = String.valueOf(mTmpGenotype.length());

            txt            = "，编码区" + mTmpVar + "位置的" + count + "个碱基插入突变，影响蛋白功能";
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




    public  static void  BrcaBeginCount(BrcaTableList brcaTableList, String[] pDatas, String pStatus) {

        brcaTableList.mBrcaBenignTable.add(pDatas[6] + ";" + pDatas[7] + ";" + pDatas[8] + ";" + pDatas[9] + ";" + pStatus);

        switch (pDatas[6].trim()) {
            case Constant.BRCA_ONE_GENE:
                mBrca1Begin += 1;
                break;
            case Constant.BRCA_TWO_GENE:
                mBrca2Begin += 1;
                break;

        }
    }

    public  static void  BrcaNoSiCount(BrcaTableList brcaTableList, String[] pDatas, String pStatus){

        brcaTableList.mBrcaUnKnownTable.add(pDatas[6]+";"+pDatas[7]+";"+pDatas[8]+";"+pDatas[9]+";" + pStatus);

        switch (pDatas[6].trim()){
            case Constant.BRCA_ONE_GENE:
                mBrca1NoSi += 1;
                break;
            case Constant.BRCA_TWO_GENE:
                mBrca2NoSi += 1;
                break;
        }
    }

    public  static void  BrcaPathogenicCount(BrcaTableList brcaTableList, String[] pDatas, String pStatus) {

        brcaTableList.mBrcaPathogenicTable.add(pDatas[6] + ";" + pDatas[7] + ";" + pDatas[8] + ";" + pDatas[9] + ";" + pStatus);


        switch (pDatas[6].trim()){
            case Constant.BRCA_ONE_GENE:
                mBrca1Pathogenic += 1;
                mBrca1Txt += HandlePathogenicTxt(pDatas[7], pDatas[8], true);
                break;
            case Constant.BRCA_TWO_GENE:
                mBrca2Pathogenic += 1;
                mBrca2Txt += HandlePathogenicTxt(pDatas[7], pDatas[8], false);
                break;
        }

    }
}
