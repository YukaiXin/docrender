package com.kxyu.docMaker.cmd;


import org.kohsuke.args4j.Option;

import java.io.File;

import static com.kxyu.docMaker.common.Constant.*;

public class CmdOption {

    @Option(name = CMD_TEMLATE_DIR_FILE_NAME, usage = CMD_TEMLATE_DIR_FILE_USAGE, required = true)
    public String templateDirFile;

    @Option(name = CMD_TEMLATE_FILE_NAME, usage = CMD_TEMLATE_FILE_USAGE, required = true)
    public String temlateFile;

    @Option(name = CMD_CANCER_QC_FILE_NAME, usage = CMD_CANCER_QC_FILE_USAGE, required = true)
    public String cancerQCFilePath;

    @Option(name = CMD_CONTROL_QC_FILE_NAME, usage = CMD_CONTROL_QC_FILE_USAGE, required = true)
    public String controlQCFilePath;

    @Option(name = CMD_CHEMOTHERAPY_NAME, usage = CMD_CHEMOTHERAPY_USAGE, required = true)
    public String chemotherapyFilePath;

    @Option(name = CMD_OUTPUT_NAME, usage = CMD_OUTPUT_USAGE, required = true, metaVar = CMD_OUTPUT_MATEVAR)
    public File out = new File(".");

}
