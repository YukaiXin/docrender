package com.kxyu.docMaker.cmd;


import com.kxyu.docMaker.Brca.Constant;
import org.kohsuke.args4j.Option;

import static com.kxyu.docMaker.Brca.Constant.BRCA_CMD_PATIENT_NAME;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 14:06 2018/1/31
 */
public class BrcaCmdOption {

    @Option(name = Constant.BRCA_CMD_DOC_TEMPLATE_PATH, usage = "报告模板文件   ※文件格式：docx", required = true)
    public String mDocTemplatePath;

    @Option(name = Constant.BRCA_CMD_OUTPUT_PATH, usage = "生成报告文件路径  ※文件格式：docx", required = true)
    public String mOutput;

    @Option(name = Constant.BRCA_CMD_DATA_PATH, usage = "突变数据文件 ", required = true)
    public String mBrcaData;
      @Option(name = BRCA_CMD_PATIENT_NAME, usage = "受检者姓名 ")
      public String mPatientName;


}
