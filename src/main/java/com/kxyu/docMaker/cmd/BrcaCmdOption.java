package com.kxyu.docMaker.cmd;


import com.kxyu.docMaker.Brca.Constant;
import org.kohsuke.args4j.Option;

import static com.kxyu.docMaker.Brca.Constant.*;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 14:06 2018/1/31
 */
public class BrcaCmdOption {

    @Option(name = Constant.BRCA_CMD_DOC_TEMPLATE_PATH, usage = BRCA_CMD_CMD_DOC_TEMPLATE_STRING, required = true)
    public String mDocTemplatePath;

    @Option(name = Constant.BRCA_CMD_OUTPUT_PATH, usage = BRCA_CMD_OUTPUT_STRING, required = true)
    public String mOutput;

    @Option(name = Constant.BRCA_CMD_DATA_PATH, usage = BRCA_CMD_DATA_STRING, required = true)
    public String mBrcaData;

    @Option(name = BRCA_CMD_PATIENT_NAME, usage = BRCA_CMD_PATIENT_NAME_STRING)
    public String mPatientName;

}
