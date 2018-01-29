package com.kxyu.docMaker;


import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.RenderData;
import com.deepoove.poi.data.TableRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.render.RenderAPI;
import com.kxyu.docMaker.utils.DateUtil;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Wordrender {

    public static void main(String[] args) throws IOException {

        ArrayList<Object> ch_info = new ArrayList<>();
        File file = new File("C:\\Users\\ykx\\codes\\demo\\src\\main\\resources\\chemotherapeutics.txt");


        Map<String, Object> datas = new HashMap<String, Object>(){{
            put("name", "老王");
            put("age", "80");
            put("sex","男");
            put("table", new TableRenderData(new ArrayList<RenderData>(){{
                add(new TextRenderData("FFD39B", "疾病"));
                add(new TextRenderData("FFD39B", "药物"));
                add(new TextRenderData("FFD39B", "基因"));
                add(new TextRenderData("FFD39B", "rs"));
                add(new TextRenderData("FFD39B", "证据等级"));
                add(new TextRenderData("FFD39B", "基因型"));
                add(new TextRenderData("FFD39B", "临床指导"));
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
