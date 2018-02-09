package com.kxyu.docMaker;

import com.kxyu.docMaker.cmd.Cmd;
import com.kxyu.docMaker.cmd.CmdOption;
import com.kxyu.docMaker.docDatas.ChemotherapyData;
import com.kxyu.docMaker.docDatas.QcDatas;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.kxyu.docMaker.common.Constant.*;

public class WordGenerate {
    public static void main(String[] args) throws IOException, TemplateException, CmdLineException {

            doMain(args);
    }


    public static void doMain(String[] args) throws IOException, TemplateException, CmdLineException {

        CmdOption cmdOption = new CmdOption();
        CmdLineParser parser = new CmdLineParser(cmdOption);

        if (args.length == 0){
            Cmd.showHelp(parser);
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
        cfg.setDefaultEncoding(CHARSET_NAME_UTF_8);
        Map root =  new HashMap();
        root.put(PATIENT_NAME_KEY, "");
        root.put(PATIENT_AGE_KEY, "");
        root.put(PATIENT_SEX_KEY, "");

        File file = new File(cmdOption.chemotherapyFilePath);
        ArrayList<ChemotherapyData> arrayList = new ArrayList<>();
        root.put(FREEMARK_CHEMOTHERAPY_LIST, ReaderLocalFiles.readChemotherapyData(arrayList, file));

        Writer out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cmdOption.out), CHARSET_NAME_UTF_8));

        File cancerFile = new File(cmdOption.cancerQCFilePath);
        File controlFile = new File(cmdOption.controlQCFilePath);

        QcDatas qcDatas = new QcDatas();
        QcDatas ac1 = ReaderLocalFiles.readQcDatas(qcDatas, cancerFile, controlFile);
        root.put(FREEMARK_QC_DATAS, ac1);

        template.process(root, out1);
        System.out.println(OK);
    }

}
