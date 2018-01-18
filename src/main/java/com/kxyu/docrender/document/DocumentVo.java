package com.kxyu.docrender.document;

import java.util.Map;

/**
 * @Author: kxyuyuyu
 * @Date: Created in 9:52 2018/1/18
 */
public interface DocumentVo {

    public String findPrimaryKey();

    public Map<String, Object> fillDataMap();
}
