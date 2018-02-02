package com.kxyu.docMaker;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.RenderData;
import com.deepoove.poi.data.TableRenderData;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.render.RenderAPI;
import com.kxyu.docMaker.cmd.BrcaCmdOption;
import com.kxyu.docMaker.cmd.Cmd;
import com.kxyu.docMaker.common.Constant;
import com.kxyu.docMaker.utils.DateUtil;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.kxyu.docMaker.common.Constant.*;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 10:37 2018/1/31
 */
public class BrcaDocRender {

    public static void main(String[] args) throws IOException, CmdLineException {

        BrcaCmdOption cmdOption = new BrcaCmdOption();
        CmdLineParser parser = new CmdLineParser(cmdOption);

//        if (args.length == 0){
//            Cmd.showHelp(parser);
//            return;
//        }

        parser.parseArgument(args);

        BrcaTableList brcaTableList = new BrcaTableList();
        ArrayList<Object> ch_info = new ArrayList<>();
        File file = new File("C:/Users/yuki_cool/yukaixin/docrender/src/main/resources/brca.txt");
        ReaderLocalFiles.readBrcaData(brcaTableList, file);

        Map<String, Object> datas = new HashMap<String, Object>(){{
            put(PATIENT_NAME_KEY, "");
            put(PATIENT_AGE_KEY, "");
            put(PATIENT_SEX_KEY, "");
            put(BRCA_REPORT_DATE, DateUtil.format(DateUtil.getToday(), DateUtil.FORMATTER_OF_DATE));
            put(BRCA_REPORT_TABLE, new TableRenderData(new ArrayList<RenderData>(){{
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_GENE));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_MUTION));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_GENOTYPE));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_DBSNP));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_CLINSIG));
            }}, brcaTableList.mBrcaBenignTable, "no datas", 1600));
            put(BRCA_REPORT_TABLE_ONE, new TableRenderData(new ArrayList<RenderData>(){{
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_GENE));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_MUTION));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_GENOTYPE));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_DBSNP));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_CLINSIG));
            }}, brcaTableList.mBrcaPathogenicTable, "no datas", 9600));
            put(BRCA_REPORT_TABLE_TWO, new TableRenderData(new ArrayList<RenderData>(){{
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_GENE));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_MUTION));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_GENOTYPE));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_DBSNP));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_CLINSIG));
            }}, brcaTableList.mBrcaUnKnownTable, "no datas", 1600));
        }};

        //读取模板，进行渲染
        XWPFTemplate doc = XWPFTemplate
                .create("C:/Users/yuki_cool/yukaixin/docrender/src/main/resources/brca.docx");
        RenderAPI.render(doc, datas);

        //输出渲染后的文件
        FileOutputStream out = new FileOutputStream("C:/Users/yuki_cool/yukaixin/docrender/src/main/resources/test.docx");
        doc.write(out);
        out.flush();
        out.close();

        System.out.println("\n"+Constant.OK);
    }
}
