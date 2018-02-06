package com.kxyu.docMaker.common;

import static com.kxyu.docMaker.ReaderLocalFiles.mBrca1NoSi;
import static com.kxyu.docMaker.ReaderLocalFiles.mBrca2NoSi;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 13:35 2018/1/25
 */
public class Constant {

    public  static final String OK                            =  "ok!!!";

    //Charset
    public  static final String CHARSET_NAME_UTF_8                               =  "UTF-8";

    //QC
    public  static final boolean QC_IS_CANCER                                    =  true;
    public  static final boolean QC_IS_CONTROL                                   =  false;

    public  static final String  QC_COVERAGE                                     =  "coverage";
    public  static final String  QC_TOTAL_READS                                  =  "Total reads";
    public  static final String  QC_TARGET_REGION                                =  "Target region";
    public  static final String  QC_PROPERLY_MAPPED                              =  "Properly mapped";
    public  static final String  QC_AVERAGE_SEQUENCE                             =  "Average sequence";
    public  static final String  QC_TOTAL_EFFECTIVE_YIELD                        =  "Total effective yield";
    public  static final String  QC_EFFECTIVE_YIELD_ON_TARGET                    =  "Effective yield on target";

    //Chemotherapy
    public  static final Integer CHEMOTHERAPY_JUDGE_INT                          =  6;
    public  static final String  CHEMOTHERAPY_JUDGE_STR                          =  "Evidence_level";

    //cmd Option
    public  static final String  CMD_TEMLATE_DIR_FILE_NAME                       =  "-templateDirFile";
    public  static final String  CMD_TEMLATE_DIR_FILE_USAGE                      =  "FreeMark文件夹路径";

    public  static final String  CMD_TEMLATE_FILE_NAME                           =  "-temlateFile";
    public  static final String  CMD_TEMLATE_FILE_USAGE                          =  "FreeMark模板路径";

    public  static final String  CMD_CANCER_QC_FILE_NAME                         =  "-cancerQCFile" ;
    public  static final String  CMD_CANCER_QC_FILE_USAGE                        =  "肿瘤组织质控信息文件路径" ;

    public  static final String  CMD_CONTROL_QC_FILE_NAME                        =  "-controlQCFile" ;
    public  static final String  CMD_CONTROL_QC_FILE_USAGE                       =  "对照组质控信息文件路径" ;

    public  static final String  CMD_CHEMOTHERAPY_NAME                           =  "-chemotherapyData" ;
    public  static final String  CMD_CHEMOTHERAPY_USAGE                          =  "化疗药物数据库路径" ;

    public  static final String  CMD_OUTPUT_NAME                                 =  "-output" ;
    public  static final String  CMD_OUTPUT_MATEVAR                              =  "metaVar" ;
    public  static final String  CMD_OUTPUT_USAGE                                =  "输出word文件路径" ;

    public  static final String  CMD_OPTIONS_NULL                                =  "LDA   [options ...] [arguments...]";

    //Freemark Key
             /******** QC Info ********/
    public  static final String  FREEMARK_QC_DATAS                               =  "QcDatas";

             /******** Patient Info ********/
    public  static final String  PATIENT_AGE_KEY                                 =  "PatientAge";
    public  static final String  PATIENT_SEX_KEY                                 =  "PatientSex";
    public  static final String  PATIENT_NAME_KEY                                =  "PatientName";

             /******** Chemotherapy Info ********/
    public  static final String  FREEMARK_CHEMOTHERAPY_LIST                      =  "ChemotherapyList";


/************************
 ************************
 **********POI***********
 ************************
 ************************/

    //poi color
    public static  final String  POI_CHEMOTHERAPY_TABLE_COLOR                    =  "FFD39B";

    //poi  Chemotherapy table head
    public static  final String  POI_CHEMOTHERAPY_TABLE_KEY                      =  "chemotherapy_table";
    public static  final String  POI_CHEMOTHERAPY_TABLE_GENE                     =  "基因";
    public static  final String  POI_CHEMOTHERAPY_TABLE_DRUG                     =  "药物";
    public static  final String  POI_CHEMOTHERAPY_TABLE_DISEASE                  =  "疾病";
    public static  final String  POI_CHEMOTHERAPY_TABLE_RS                       =  "RS";
    public static  final String  POI_CHEMOTHERAPY_TABLE_EVIDENCE_LEVEL           =  "证据等级";
    public static  final String  POI_CHEMOTHERAPY_TABLE_GENOTYPE                 =  "基因型";
    public static  final String  POI_CHEMOTHERAPY_TABLE_CLINIC                   =  "临床指导";


    /************************
     ************************
     **********BRCA***********
     ************************
     ************************/

    public static   final String  BRCA_REPORT_DATE                               =  "date";
    public static   final String  BRCA_REPORT_RISK                               =  "mRisk";
    public static   final String  BRCA_REPORT_DRUG                               =  "mIsUseDrug";
    public static   final String  BRCA_REPORT_TABLE                              =  "mBrcaTable";
    public static   final String  BRCA_REPORT_TABLE_ONE                          =  "mBrcaTable1";
    public static   final String  BRCA_REPORT_TABLE_TWO                          =  "mBrcaTable2";
    public static   final String  BRCA_REPORT_TWO_UNKNOWN_COUNT                  =  "mBrca2Unknown";
    public static   final String  BRCA_REPORT_ONE_UNKNOWN_COUNT                  =  "mBrca1Unknown";
    public static   final String  BRCA_REPORT_DETECTION_RESULT                   =  "mDetectionResult";
    public static   final String  BRCA_REPORT_ONE_BENIGN_COUNT                   =  "mBrca1BenignCount";
    public static   final String  BRCA_REPORT_TWO_BENIGN_COUNT                   =  "mBrca2BenignCount";

    public static   final String  BRCA_REPORT_STR_YIN_DETECTION_RESULT           =  "本次检测，在受检者中未检出BRCA1/BRCA2基因的任何致病或疑似致病突变。";
    public static   final String  BRCA_REPORT_STR_YANG_DETECTION_RESULT          =  "编码区XX位置的XX氨基酸突变为XX氨基酸，为致病性/疑似致病突变";
    public static   final String  BRCA_REPORT_STR_YANG_DETECTION_RESULT_ONE      =  "啊啊";

    public static   final String  BRCA_REPORT_STR_RISK_LEVEL_LOW                 =  "低";
    public static   final String  BRCA_REPORT_STR_RISK_LEVEL_HIGHT               =  "高";
    public static   final String  BRCA_REPORT_STR_DURG_USE                       =  "适用";
    public static   final String  BRCA_REPORT_STR_DURG_NO_USE                    =  "不适用";

    public static   final String  BRCA_TABLE_GENE                                =  "基因 "+ "\t";
    public static   final String  BRCA_TABLE_DBSNP                               =  "dbsnp"+ "\t";
    public static   final String  BRCA_TABLE_HEAD_COLOR                          =  "FFD39B" + "\t";
    public static   final String  BRCA_TABLE_MUTION                              =  "突变名称" + "\t";
    public static   final String  BRCA_TABLE_CLINSIG                             =  "临床意义" + "\t" ;
    public static   final String  BRCA_TABLE_GENOTYPE                            =  "基因型" + "\t";

    public static   final String  BRCA_JUDGE_POINT                               =  ".";
    public static   final String  BRCA_BENGIN                                    =  "良性";
    public static   final String  BRCA_NO_CONFIRM                                =  "待确认";
    public static   final String  BRCA_STR_PATHOGENIC                            =  "致病突变";
    public static   final String  BRCA_NO_SIGNIFICANCE                           =  "意义未明";
    public static   final String  BRCA_JUDGE_BENGIN                              =  "benign";
    public static   final String  BRCA_JUDGE_UNCERTAIN_SIGNIFICANCE              =  "uncertain significance";
    public static   final String  BRCA_JUDGE_PATHOGENIC                          =  "pathogenic";

    public static   final String  BRCA_ONE_GENE                                  =  "BRCA1";
    public static   final String  BRCA_TWO_GENE                                  =  "BRCA2";

    //BRCA CMD Option
    public static   final String  BRCA_CMD_OUTPUT_PATH                           =  "-output";
    public static   final String  BRCA_CMD_DOC_TEMPLATE_PATH                     =  "-doctemplate";
    public static   final String  BRCA_CMD_DATA_PATH                             =  "-data";

    public static   String  BRCA_NO_SIGNIFICANCE_STR_BRCA_2                      =  ",在受检者中发现BRCA2基因的"+ String.valueOf(mBrca2NoSi)+"个意义未明突变";
    public static   String  BRCA_NO_SIGNIFICANCE_STR_BRCA_1                      =  ",在受检者中发现BRCA1基因的"+ String.valueOf(mBrca1NoSi)+"个意义未明突变";
    public static   String  BRCA_NO_SIGNFICANCE_NOT_FIND                         =  "，未发现意义未名突变";

}
