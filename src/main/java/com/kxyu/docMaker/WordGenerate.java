package com.kxyu.docMaker;


import com.kxyu.docMaker.docDatas.ChemotherapyData;
import com.kxyu.docMaker.docDatas.QcDatas;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import sun.rmi.runtime.NewThreadAction;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordGenerate {
    public static void main(String[] args) throws IOException, TemplateException, CmdLineException {

            doMain(args);

    }


    public static void doMain(String[] args) throws IOException, TemplateException, CmdLineException {

        CmdOption cmdOption = new CmdOption();
        CmdLineParser parser = new CmdLineParser(cmdOption);


        if (args.length == 0){
            showHelp(parser);
            return;
        }

        parser.parseArgument(args);

        //开始初步参数校验并调用程序开始运行,这里就会获得参数
        System.out.println(cmdOption.cancerQCFilePath);
        System.out.println(cmdOption.chemotherapyFilePath);
        System.out.println(cmdOption.controlQCFilePath);
        System.out.println(cmdOption.templateDirFile);
        System.out.println(cmdOption.out);
        System.out.println(cmdOption.temlateFile);


        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File(cmdOption.templateDirFile));
        Template template = cfg.getTemplate(cmdOption.temlateFile);
        cfg.setDefaultEncoding("UTF-8");
        Map root =  new HashMap();
        root.put("Patientname","");
        root.put("PatientAge","");
        root.put("PatientSex","");

        List<ChemotherapyData> userList = new ArrayList<ChemotherapyData>();
        // userList.add(new ChemotherapyData());
            File file = new File(cmdOption.chemotherapyFilePath);

        ArrayList<ChemotherapyData> arrayList = new ArrayList<>();
        root.put("userList",ReaderLocalFiles.txt2String1(arrayList, file));

        Writer out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cmdOption.out),"UTF-8"));

        File cancerFile = new File(cmdOption.cancerQCFilePath);
        File controlFile = new File(cmdOption.controlQCFilePath);

        QcDatas qcDatas = new QcDatas();
        QcDatas ac1 = ReaderLocalFiles.readQcDatas(qcDatas, cancerFile, controlFile);
        System.out.println(ac1.getmCancerAverageSequenceDepths()+" "+ac1.getmControlAverageSequenceDepths());
        root.put("QC", ac1);

        template.process(root, out1);
        System.out.println("ok");
    }

    public static void showHelp(CmdLineParser parser){
        System.out.println("LDA [options ...] [arguments...]");
        parser.printUsage(System.out);
    }


}
