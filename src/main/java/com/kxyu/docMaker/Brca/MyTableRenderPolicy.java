package com.kxyu.docMaker.Brca;

import com.deepoove.poi.NiceXWPFDocument;
import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.RenderData;
import com.deepoove.poi.data.TableRenderData;
import com.deepoove.poi.policy.RenderPolicy;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import com.kxyu.docMaker.XWPFTableHelper;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 10:45 2018/2/11
 */
public class MyTableRenderPolicy implements RenderPolicy {
    @Override
    public void render(ElementTemplate eleTemplate, Object data, XWPFTemplate template) {
        // TODO Auto-generated method stub
        NiceXWPFDocument doc = template.getXWPFDocument();
        RunTemplate runTemplate = (RunTemplate) eleTemplate;
        XWPFRun run = runTemplate.getRun();
        if (null == data) {
            runTemplate.getRun().setText("", 0);
            return;
        }
        TableRenderData tableData = (TableRenderData) data;
        List<RenderData> headers = tableData.getHeaders();
        List<Object> datas = tableData.getDatas();
        if (datas == null || datas.isEmpty()) {
            if (headers == null || headers.isEmpty()) {
                runTemplate.getRun().setText("", 0);
                return;
            }
            // XWPFTable table = doc.createTable(2, headers.size());
            XWPFTable table = doc.insertNewTable(run, 2, headers.size());
            if (null == table) {
                logger.warn("cannot insert table.");
                return;
            }
            CTTblWidth width = table.getCTTbl().addNewTblPr().addNewTblW();
            width.setW(BigInteger.valueOf(tableData.getWidth()));
            // width.setType(STTblWidth.);
            // createHeader(table, headers);
            doc.mergeCellsHorizonal(table, 1, 0, headers.size() - 1);
            XWPFTableCell cell = table.getRow(1).getCell(0);
            cell.setText(tableData.getNoDatadesc());

        } else {
            Map<String,Object> map= XWPFTableHelper.getTable(eleTemplate.getTagName(), doc.getTables());
            int startRow = 1;//getStartRow
            int startCell= 2;
            if(startRow==0) {
                startRow++;
                startCell=0;
            }
            XWPFTable table = (XWPFTable) map.get("table");//doc.getTableArray(0);
            XWPFTableCell cell = null;
            XWPFRun r = null;
            if(null!=table) {
                if (datas.size() > 0) {
                    for (Object obj : datas) {
                        if (null == obj)
                            continue;
                        String str = obj.toString();
                        String[] split = str.split(".");
                        int length = split.length;
                        if (null == table.getRow(startRow+1)) {
                            // 复制样式
                            XWPFTableHelper.copytTableRow(table.createRow(), table.getRow(startRow));
                        }
                        for (int m = startCell; m < length+startCell; m++) {
                            cell=table.getRow(startRow).getCell(m);
                            if(null!=cell) {
                                r=XWPFTableHelper.getRun(cell, run);
                                r.setText(split[m-startCell]);
                            }
                            //                      table.getRow(startRow).getCell(m).setText(split[m]);
                        }
                        startRow++;
                    }
                }
            }
        }
        runTemplate.getRun().setText("", 0);
    }
}
