package com.kxyu.docMaker;


import com.kxyu.docMaker.docDatas.ChemotherapyData;
import com.kxyu.docMaker.docDatas.QcDatas;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordGenerate {
    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration();
        cfg.setDirectoryForTemplateLoading(new File("C:/Users/ykx/codes/docrender/src/main/resources/templates"));
        Template template = cfg.getTemplate("testRS.ftl");
        cfg.setDefaultEncoding("UTF-8");
        Map root =  new HashMap();
        root.put("Patientname","");
        root.put("PatientAge","21");
        root.put("PatientSex","男");

        List<ChemotherapyData> userList = new ArrayList<ChemotherapyData>();
        // userList.add(new ChemotherapyData());
        File file = new File("C:/Users/ykx/codes/demo/src/main/resources/chemotherapeutics.txt");

        ArrayList<ChemotherapyData> arrayList = new ArrayList<>();
        root.put("userList",ReaderLocalFiles.txt2String1(arrayList, file));

        Writer out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:/DATA/c.doc"),"UTF-8"));

        File cancerFile = new File("C:/Users/ykx/codes/demo/src/main/resources/cancerQC.txt");
        File controlFile = new File("C:/Users/ykx/codes/demo/src/main/resources/controlQC.txt");

        QcDatas qcDatas = new QcDatas();
        QcDatas ac1 = ReaderLocalFiles.readQcDatas(qcDatas, cancerFile, controlFile);
        System.out.println(ac1.getmCancerAverageSequenceDepths()+" "+ac1.getmControlAverageSequenceDepths());
        root.put("QC", ac1);

        template.process(root, out1);
        System.out.println("ok");
    }




}