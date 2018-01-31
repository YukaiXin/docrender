package com.kxyu.docMaker;


import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.RenderData;
import com.deepoove.poi.data.TableRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.render.RenderAPI;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.kxyu.docMaker.common.Constant.*;

public class Wordrender {

    public static void main(String[] args) throws IOException {

        ArrayList<Object> ch_info = new ArrayList<>();
        File file = new File("C:/Users/ykx/codes/demo/src/main/resources/chemotherapeutics.txt");

        Map<String, Object> datas = new HashMap<String, Object>(){{
            put(PATIENT_NAME_KEY, "老王");
            put(PATIENT_AGE_KEY, "80");
            put(PATIENT_SEX_KEY, "男");
            put(POI_CHEMOTHERAPY_TABLE_KEY, new TableRenderData(new ArrayList<RenderData>(){{
                add(new TextRenderData(POI_CHEMOTHERAPY_TABLE_COLOR, POI_CHEMOTHERAPY_TABLE_DISEASE));
                add(new TextRenderData(POI_CHEMOTHERAPY_TABLE_COLOR, POI_CHEMOTHERAPY_TABLE_DRUG));
                add(new TextRenderData(POI_CHEMOTHERAPY_TABLE_COLOR, POI_CHEMOTHERAPY_TABLE_GENE));
                add(new TextRenderData(POI_CHEMOTHERAPY_TABLE_COLOR, POI_CHEMOTHERAPY_TABLE_RS));
                add(new TextRenderData(POI_CHEMOTHERAPY_TABLE_COLOR, POI_CHEMOTHERAPY_TABLE_EVIDENCE_LEVEL));
                add(new TextRenderData(POI_CHEMOTHERAPY_TABLE_COLOR, POI_CHEMOTHERAPY_TABLE_GENOTYPE));
                add(new TextRenderData(POI_CHEMOTHERAPY_TABLE_COLOR, POI_CHEMOTHERAPY_TABLE_CLINIC));
            }},ReaderLocalFiles.readChemotherapyData1(ch_info, file), "no datas", 8600));
        }};

        //读取模板，进行渲染
        XWPFTemplate doc = XWPFTemplate
                .create("D:/DATA/test121.docx");
        RenderAPI.render(doc, datas);

        //输出渲染后的文件
        FileOutputStream out = new FileOutputStream("D:/DATA/head1.docx");
        doc.write(out);
        out.flush();
        out.close();
    }
}
