package com.kxyu.docMaker.document;

import com.kxyu.docMaker.utils.JacksonBinder;

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
