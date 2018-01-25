package com.kxyu.docMaker;

import org.kohsuke.args4j.Option;

import java.io.File;

public class CmdOption {

    @Option(name = "-templateDirFile", usage = "FreeMark文件夹路径", required = true)
    public String templateDirFile;

    @Option(name = "-temlateFile", usage = "FreeMark模板路径", required = true)
    public String temlateFile;

    @Option(name = "-cancerQCFile", usage = "肿瘤组织质控信息文件路径", required = true)
    public String cancerQCFilePath;

    @Option(name = "-controlQCFile", usage = "对照组质控信息文件路径", required = true)
    public String controlQCFilePath;

    @Option(name = "-chemotherapyData", usage = "化疗药物数据库路径", required = true)
    public String chemotherapyFilePath;


    @Option(name = "-output", usage = "输出word文件路径", required = true, metaVar = "OUTPUT")
    public File out = new File(".");
}
