/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.kxyu.docMaker.utils;

import java.net.URL;

/**
 * ��Դ������
 * @ClassName: Loader
 * @Description: ��Դ������
 * @author kxyu
 * �޸�ʱ�䣺 2013��11��11�� ����5:17:33
 * �޸����ݣ��½�
 */

public class ResourceLoader  { 
	public static String CLASS_PATH_PREFIX ="classpath:";

  /**
   * classpath�л�ȡ��Դ
   * @Title: getResource
   * @Description: classpath�л�ȡ��Դ
   * @param resource
   * @return
   * @author kxyu
   * �޸�ʱ�䣺 2013��11��11�� ����5:18:00
   * �޸����ݣ��½�
   */
   public static URL getResource(String resource) {
    ClassLoader classLoader = null;
    classLoader = Thread.currentThread().getContextClassLoader();
    return classLoader.getResource(resource);
  } 
  
  /**
   *  classpath ������·��
   * @Title: getPath
   * @Description: 
   * @param resource
   * @return
   * @author kxyu
   * �޸�ʱ�䣺 2013��11��11�� ����5:00:15
   * �޸����ݣ��½�
   */
  public static String getPath(String resource){
	  if(resource!=null){
		  if(resource.startsWith(CLASS_PATH_PREFIX)){
			  resource = getPath("")+resource.replaceAll(CLASS_PATH_PREFIX, "");
		  }
	  }
	  
	  URL url = getResource(resource);
	  if(url==null)
		  return null;
	  return url.getPath().replaceAll("%20", " ");
  }
  /**
   * 
   * @Title: getPath
   * @Description: 
   * @param resource
   * @param clazz
   * @return
   * @author kxyu
   * �޸�ʱ�䣺 2013��11��11�� ����5:12:33
   * �޸����ݣ��½�
   */
  public static String getPath(String resource,Class clazz){
	  URL url = getResource(resource, clazz);
	  if(url==null)
		  return null;
	  return url.getPath().replaceAll("%20", " ");
  }
  
  /**
   * ָ��class�л�ȡ��Դ
   * @Title: getResource
   * @Description: ָ��class�л�ȡ��Դ
   * @param resource
   * @param clazz
   * @return
   * @author kxyu
   * �޸�ʱ�䣺 2013��11��11�� ����5:10:40
   * �޸����ݣ��½�
   */
  public static URL getResource(String resource,Class clazz){
	  return clazz.getResource(resource);
  }
  
	/**
	 * If running under JDK 1.2 load the specified class using the
	 * <code>Thread</code> <code>contextClassLoader</code> if that fails try
	 * Class.forname. Under JDK 1.1 only Class.forName is used.
	 * 
	 */
	public static Class loadClass(String clazz) throws ClassNotFoundException {
		return Class.forName(clazz);
	}
}
