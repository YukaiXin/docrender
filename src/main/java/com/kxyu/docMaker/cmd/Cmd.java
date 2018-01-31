package com.kxyu.docMaker.cmd;

import org.kohsuke.args4j.CmdLineParser;

import static com.kxyu.docMaker.common.Constant.CMD_OPTIONS_NULL;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 14:20 2018/1/31
 */
public class Cmd {

    public static void showHelp(CmdLineParser parser){
        System.out.println(CMD_OPTIONS_NULL);
        parser.printUsage(System.out);
    }
}
