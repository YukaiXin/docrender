package com.kxyu.docrender;

/**
 * @Author: 于开新
 * @Date: Created in 9:32 2018/1/18
 */



import com.kxyu.docrender.docDatas.ChemotherapyData;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordGenertar {
        public static void main(String[] args) throws Exception

        {
            Configuration cfg = new Configuration();
            cfg.setDirectoryForTemplateLoading(new File("C:/Users/yuki_cool/MyCodes/doc-render/src/main/resources/templates"));
            Template template = cfg.getTemplate("testRS.ftl");
            cfg.setDefaultEncoding("UTF-8");
            Map root =  new HashMap();
            root.put("Patientname","小明");
            root.put("PatientAge","65");
            root.put("PatientSex","男");

            List<ChemotherapyData> userList = new ArrayList<ChemotherapyData>();
            // userList.add(new ChemotherapyData());
            File file = new File("C:/Users/yuki_cool/MyCodes/doc-render/src/main/resources/chemotherapeutics.txt");

            ArrayList<ChemotherapyData> arrayList = new ArrayList<>();
            root.put("userList",ReaderLocalFiles.txt2String1(arrayList, file));


            Writer out1 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/Users/yuki_cool/MyCodes/doc-render/src/main/resources/c.doc"),"UTF-8"));
            template.process(root, out1);


            System.out.println(template.toString());
        }



}
