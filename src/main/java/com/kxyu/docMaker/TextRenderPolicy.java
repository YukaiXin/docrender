package com.kxyu.docMaker.utils;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 13:37 2018/2/11
 */

import com.deepoove.poi.policy.RenderPolicy;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.TextRenderData;
import com.deepoove.poi.template.ElementTemplate;
import com.deepoove.poi.template.run.RunTemplate;
import com.deepoove.poi.util.StyleUtils;

public class TextRenderPolicy implements RenderPolicy {

    static final String REGEX_LINE_CHARACTOR = "\\n";

    @Override
    public void render(ElementTemplate eleTemplate, Object renderData, XWPFTemplate template) {
        RunTemplate runTemplate = (RunTemplate) eleTemplate;
        XWPFRun run = runTemplate.getRun();
        if (null == renderData) {
            // support String to set blank
            run.setText("", 0);
            return;
        }

        TextRenderData textRenderData = null;
        if (renderData instanceof TextRenderData) {
            textRenderData = (TextRenderData) renderData;
        } else {
            textRenderData = new TextRenderData(renderData.toString());
        }
        String data = textRenderData.getText();
        StyleUtils.styleRun(run, textRenderData.getStyle());
        if (null == data) data = "";

        String[] split = data.split(REGEX_LINE_CHARACTOR);
        if (null != split){
            run.setText(split[0], 0);
            for (int i = 1; i < split.length; i++) {
                run.addBreak();
                run.setText(split[i]);
            }
        }
    }


}