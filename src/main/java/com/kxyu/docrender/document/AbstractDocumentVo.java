package com.kxyu.docrender.document;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 9:46 2018/1/18
 */
import com.kxyu.docrender.utils.JacksonBinder;

import java.util.HashMap;
import java.util.Map;
public abstract class AbstractDocumentVo implements DocumentVo{

    public Map<String, Object> fillDataMap(){
        Map<String, Object> map = new HashMap<String, Object>();

        DocumentVo vo = this.getDocumentVo();
        map = JacksonBinder.buildNonDefaultBinder().convertValue(vo, HashMap.class);

        return map;
    }

    private DocumentVo getDocumentVo() {
        return this;
    }
}
