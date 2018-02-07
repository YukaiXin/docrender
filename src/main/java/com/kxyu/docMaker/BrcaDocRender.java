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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.kxyu.docMaker.ReaderLocalFiles.*;
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
        bindDatas();
        parser.parseArgument(args);



        System.out.println("\n"+Constant.OK);
    }

    public static void bindDatas() throws IOException {

        BrcaTableList brcaTableList = new BrcaTableList();
        ArrayList<Object> ch_info = new ArrayList<>();
        File file = new File("C:/Users/yuki_cool/yukaixin/docrender/src/main/resources/brca.txt");
        ReaderLocalFiles.readBrcaData(brcaTableList, file);

        String mIsPathogenic = BRCA_REPORT_STR_RISK_LEVEL_LOW;
        if(mBrca2Pathogenic != 0 || mBrca1Pathogenic != 0){
            mIsPathogenic = BRCA_REPORT_STR_RISK_LEVEL_HIGHT;
        }

        Map<String, Object> datas = new HashMap<String, Object>(){{
            put(PATIENT_NAME_KEY, "");
            put(PATIENT_AGE_KEY, "");
            put(PATIENT_SEX_KEY, "");
            put(BRCA_REPORT_DATE, DateUtil.format(DateUtil.getToday(), DateUtil.FORMATTER_OF_DATE));
            put(BRCA_REPORT_ONE_BENIGN_COUNT, String.valueOf(mBrca1Begin));
            put(BRCA_REPORT_TWO_BENIGN_COUNT, String.valueOf(mBrca2Begin));
            put(BRCA_REPORT_TABLE, new TableRenderData(new ArrayList<RenderData>(){{
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_GENE));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_MUTION));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_GENOTYPE));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_DBSNP));
                add(new TextRenderData(BRCA_TABLE_HEAD_COLOR, BRCA_TABLE_CLINSIG));
            }}, brcaTableList.mBrcaBenignTable, "no datas", 9600));
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
            }}, brcaTableList.mBrcaUnKnownTable, "no datas", 9600));
        }};

        /**
         * 致病风险
         **/
        datas.put(BRCA_REPORT_RISK, mIsPathogenic);

        /**
         * 意义未明
         **/
        String mNoSig = "";
        if(mBrca1NoSi != 0 && mBrca2NoSi != 0){
            mNoSig = BRCA_NO_SIGNIFICANCE_STR_BRCA_2 + BRCA_NO_SIGNIFICANCE_STR_BRCA_1;
        } else if (mBrca1NoSi != 0){
            mNoSig = BRCA_NO_SIGNIFICANCE_STR_BRCA_1;
        } else if (mBrca2NoSi != 0){
            mNoSig = BRCA_NO_SIGNIFICANCE_STR_BRCA_2;
        } else {
            mNoSig = BRCA_NO_SIGNFICANCE_NOT_FIND;
        }

        datas.put("mBrcaNoSiStr",  mNoSig);


        /**
         * 是否用药
         **/
        if(mBrca2Pathogenic != 0 || mBrca1Pathogenic != 0){
            datas.put(BRCA_REPORT_DRUG, BRCA_REPORT_STR_DURG_USE);
        } else {
            datas.put(BRCA_REPORT_DRUG, BRCA_REPORT_STR_DURG_NO_USE);
        }

        String mPathogenicTxt = "";
        /**
         * 致病头字段
         */
        if (mBrca1Pathogenic > 0 && mBrca2Pathogenic == 0){

            String mBrca1HeadTxt = "在受检者中检出BRCA1基因"+ String.valueOf(mBrca1Pathogenic)+"个致病突变";
            mPathogenicTxt = mBrca1HeadTxt + mBrca1Txt;
        }else if (mBrca1Pathogenic == 0 && mBrca2Pathogenic > 0){

            String mBrca2HeadTxt = "在受检者中检出BRCA2基因"+String.valueOf(mBrca2Pathogenic)+"个致病突变";
            mPathogenicTxt = mBrca2HeadTxt + mBrca2Txt;
        } else if(mBrca2Pathogenic > 0 && mBrca1Pathogenic > 0){

            String mBrca1HeadTxt = "在受检者中检出BRCA1基因"+ String.valueOf(mBrca1Pathogenic)+"个致病突变";
            String mBrca2HeadTxt = ";BRCA2基因"+ String.valueOf(mBrca2Pathogenic)+"个致病突变";
            mPathogenicTxt = mBrca1HeadTxt + mBrca1Txt + mBrca2HeadTxt + mBrca2Txt;
        } else {

            String mNoPathogenicTxt = "在受检者中未检出BRCA1/BRCA2基因的任何致病或疑似致病突变。";
            mPathogenicTxt = mNoPathogenicTxt;
        }

        datas.put(BRCA_REPORT_DETECTION_RESULT, mPathogenicTxt);

        //读取模板，进行渲染
        XWPFTemplate doc = XWPFTemplate
                .create("C:/Users/yuki_cool/yukaixin/docrender/src/main/resources/brca.docx");
        RenderAPI.render(doc, datas);

        //输出渲染后的文件
        FileOutputStream out = new FileOutputStream("C:/Users/yuki_cool/yukaixin/docrender/src/main/resources/test.docx");
        doc.write(out);
        out.flush();
        out.close();
    }

}
