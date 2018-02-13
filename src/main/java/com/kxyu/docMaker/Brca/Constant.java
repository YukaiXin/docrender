package com.kxyu.docMaker.Brca;

import static com.kxyu.docMaker.Brca.BrcaReaderLocalFile.*;
import static com.kxyu.docMaker.Brca.BrcaReaderLocalFile.mBrca2Pathogenic;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 11:00 2018/2/8
 */
public class Constant {

    /************************
     ************************
     **********BRCA***********
     ************************
     ************************/
    public static   final String  BRCA_REPORT_CHINSES_DATE                       =  "ChineseDate";
    public static   final String  BRCA_REPORT_DATE                               =  "date";
    public static   final String  BRCA_REPORT_RISK                               =  "mRisk";
    public static   final String  BRCA_REPORT_DRUG                               =  "mIsUseDrug";
    public static   final String  BRCA_REPORT_TABLE                              =  "mBrcaTable";
    public static   final String  BRCA_REPORT_TABLE_ONE                          =  "mBrcaTable1";
    public static   final String  BRCA_REPORT_TABLE_TWO                          =  "mBrcaTable2";
    public static   final String  BRCA_REPORT_DETECTION_RESULT                   =  "mDetectionResult";
    public static   final String  BRCA_REPORT_ONE_BENIGN_COUNT                   =  "mBrca1BenignCount";
    public static   final String  BRCA_REPORT_TWO_BENIGN_COUNT                   =  "mBrca2BenignCount";
    public static   final String  BRCA_REPORT_NO_SIGNIFICANCE_STR                =  "mBrcaNoSiStr";

    public static   final String  BRCA_TABLE_NO_DATAS_STR                        =  "on datas";
    public static   final int     BRCA_TABLE_WIDTH                               =  9600;
    public static   final String  BRCA_REPORT_STR_YIN_DETECTION_RESULT           =  "在受检者中未检出BRCA1/BRCA2基因的任何致病或疑似致病突变";

    public static   final String  BRCA_REPORT_STR_RISK_LEVEL_LOW                 =  "低";
    public static   final String  BRCA_REPORT_STR_RISK_LEVEL_HIGHT               =  "高";
    public static   final String  BRCA_REPORT_STR_DURG_USE                       =  "适用";
    public static   final String  BRCA_REPORT_STR_DURG_NO_USE                    =  "不适用";

    public static   final String  BRCA_TABLE_GENE                                =  "基因 "+ "\t";
    public static   final String  BRCA_TABLE_DBSNP                               =  "dbsnp"+ "\t";
    public static   final String  BRCA_TABLE_GENOTYPE                            =  "基因型 " + "\t";
    public static   final String  BRCA_TABLE_HEAD_COLOR                          =  "FFD39B" + "\t";
    public static   final String  BRCA_TABLE_HEAD_WHITE_COLOR                    =  "00FFFFFF";
    public static   final String  BRCA_TABLE_MUTION                              =  "突变名称" + "\t";
    public static   final String  BRCA_TABLE_CLINSIG                             =  "临床意义" + "\t";

    public static   final String  BRCA_JUDGE_POINT                               =  ".";
    public static   final String  BRCA_BENGIN                                    =  "良性";
    public static   final String  BRCA_NO_CONFIRM                                =  "待确认";
    public static   final String  BRCA_STR_PATHOGENIC                            =  "致病突变";
    public static   final String  BRCA_NO_SIGNIFICANCE                           =  "意义未明";
    public static   final String  BRCA_Likely_Benign                             =  "疑似良性";
    public static   final String  BRCA_Likely_PATHOGENIC                         =  "疑似致病突变";

    public static   final String  BRCA_JUDGE_BENGIN                              =  "Benign";
    public static   final String  BRCA_JUDGE_UNCERTAIN_SIGNIFICANCE              =  "Uncertain significance";
    public static   final String  BRCA_JUDGE_PATHOGENIC                          =  "Pathogenic";
    public static   final String  BRCA_JUDGE_LIKELY_PATHOGENIC                   =  "Likely athogenic";
    public static   final String  BRCA_JUDGE_LIKELY_BENIGN                       =  "Likely benign";
    public static   final String  BRCA_ONE_GENE                                  =  "BRCA1";
    public static   final String  BRCA_TWO_GENE                                  =  "BRCA2";


    public static   String  BRCA_NO_SIGNIFICANCE_STR_BRCA_2                      =  ",在受检者中发现BRCA2基因的"+ String.valueOf(mBrca2NoSi)+"个意义未明突变";
    public static   String  BRCA_NO_SIGNIFICANCE_STR_BRCA_1                      =  ",在受检者中发现BRCA1基因的"+ String.valueOf(mBrca1NoSi)+"个意义未明突变";
    public static   String  BRCA_NO_SIGNFICANCE_NOT_FIND                         =  ",未发现意义未明突变";
    public static   String  BRCA_ONE_TXT_HEAD                                    =  "在受检者中检出BRCA1基因"+ String.valueOf(mBrca1Pathogenic)+"个致病突变";
    public static   String  BRCA_TWO_TXT_HEAD                                    =  "在受检者中检出BRCA2基因"+ String.valueOf(mBrca2Pathogenic)+"个致病突变";
    public static   String  BRCA_TWO_TXT_HEAD_2                                  =  ";BRCA2基因"+ String.valueOf(mBrca2Pathogenic)+"个致病突变";
    public static   String  BRCA_TABLE_NO_DATAS                                  =  "-;-;-;-;-";



    //BRCA CMD Option
    public static   final String  BRCA_CMD_OUTPUT_PATH                           =  "-output";
    public static   final String  BRCA_CMD_DOC_TEMPLATE_PATH                     =  "-doctemplate";
    public static   final String  BRCA_CMD_DATA_PATH                             =  "-data";
    public static   final String  BRCA_CMD_PATIENT_NAME                          =  "-patientName";


    public static   final String  BRCA_CMD_OUTPUT_STRING                         =  "生成报告文件路径  ※文件格式：docx";
    public static   final String  BRCA_CMD_CMD_DOC_TEMPLATE_STRING               =  "报告模板文件   ※文件格式：docx";
    public static   final String  BRCA_CMD_DATA_STRING                           =  "突变数据文件 ";
    public static   final String  BRCA_CMD_PATIENT_NAME_STRING                   =  "受检者姓名 ";


    public static   final String  BRCA_CMD_UV                                    = "3 - UV";
    public static   final String  BRCA_CMD_STAR                                  = "*";
    public static  final  String  BRCA_CMD_NONE                                  = "None";
    public static   final String  BRCA_CMD_CAUSAL                                = "5 - Causal";
    public static   final String  BRCA_CMD_NEUTRAL                               = "1 - Neutral";
    public static   final String  BRCA_CMD_LIKELY_CAUSAL                         = "4 - Likely causal";
    public static   final String  BRCA_CMD_LIKELY_NEUTRAL                        = "2 - Likely Neutral";





}
