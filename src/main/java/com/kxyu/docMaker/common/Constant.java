package com.kxyu.docMaker.common;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 13:35 2018/1/25
 */
public class Constant {
    //Charset
    public  static final String CHARSET_NAME_UTF_8                         =  "UTF-8";

    //QC
    public  static final boolean QC_IS_CANCER                 =  true;
    public  static final boolean QC_IS_CONTROL                =  false;
    public  static final String  QC_COVERAGE                  =  "coverage";
    public  static final String  QC_TOTAL_READS               =  "Total reads";
    public  static final String  QC_TARGET_REGION             =  "Target region";
    public  static final String  QC_PROPERLY_MAPPED           =  "Properly mapped";
    public  static final String  QC_AVERAGE_SEQUENCE          =  "Average sequence";
    public  static final String  QC_TOTAL_EFFECTIVE_YIELD     =  "Total effective yield";
    public  static final String  QC_EFFECTIVE_YIELD_ON_TARGET =  "Effective yield on target";

    //Chemotherapy
    public  static final Integer CHEMOTHERAPY_JUDGE_INT       =  6;
    public  static final String  CHEMOTHERAPY_JUDGE_STR       =  "Evidence_level";

    //cmd Option
    public  static final String  CMD_TEMLATE_DIR_FILE_NAME    =  "-templateDirFile";
    public  static final String  CMD_TEMLATE_DIR_FILE_USAGE   =  "FreeMark文件夹路径";

    public  static final String  CMD_TEMLATE_FILE_NAME        =  "-temlateFile";
    public  static final String  CMD_TEMLATE_FILE_USAGE       =  "FreeMark模板路径";

    public  static final String  CMD_CANCER_QC_FILE_NAME      =  "-cancerQCFile" ;
    public  static final String  CMD_CANCER_QC_FILE_USAGE     =  "肿瘤组织质控信息文件路径" ;

    public  static final String  CMD_CONTROL_QC_FILE_NAME     =  "-controlQCFile" ;
    public  static final String  CMD_CONTROL_QC_FILE_USAGE    =  "对照组质控信息文件路径" ;

    public  static final String  CMD_CHEMOTHERAPY_NAME        =  "-chemotherapyData" ;
    public  static final String  CMD_CHEMOTHERAPY_USAGE       =  "化疗药物数据库路径" ;

    public  static final String  CMD_OUTPUT_NAME              =  "-output" ;
    public  static final String  CMD_OUTPUT_MATEVAR           =  "metaVar" ;
    public  static final String  CMD_OUTPUT_USAGE             =  "输出word文件路径" ;

    public  static final String  CMD_OPTIONS_NULL             =  "LDA   [options ...] [arguments...]";

    //Freemark Key
             /******** QC Info ********/
    public  static final String  FREEMARK_QC_DATAS            =  "QcDatas";

             /******** Patient Info ********/
    public  static final String  FREEMARK_PATIENT_AGE         =  "PatientAge";
    public  static final String  FREEMARK_PATIENT_SEX         =  "PatientSex";
    public  static final String  FREEMARK_PATIENT_NAME        =  "Patientname";

             /******** Chemotherapy Info ********/
    public  static final String  FREEMARK_CHEMOTHERAPY_LIST   =  "ChemotherapyList";

}
