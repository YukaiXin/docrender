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

package com.kxyu.docrender.utils;

import java.net.URL;

/**
 * 资源加载类
 * @ClassName: Loader
 * @Description: 资源加载类
 * @author kxyu
 */

public class ResourceLoader  { 
	public static String CLASS_PATH_PREFIX ="classpath:";

  /**
   * classpath 获取资源
   * @Title: getResource
   * @Description: classpath中 获取资源
   * @param resource
   * @return
   * @author kxyu

   */
   public static URL getResource(String resource) {
    ClassLoader classLoader = null;
    classLoader = Thread.currentThread().getContextClassLoader();
    return classLoader.getResource(resource);
  } 
  
  /**
   *  classpath 搜索路径
   * @Title: getPath
   * @Description: 
   * @param resource
   * @return
   * @author kxyu �޸����ݣ��½�
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
   */
  public static String getPath(String resource,Class clazz){
	  URL url = getResource(resource, clazz);
	  if(url==null)
		  return null;
	  return url.getPath().replaceAll("%20", " ");
  }
  
  /**
   * ָ指定class中获取资源
   * @Title: getResource
   * @Description: ָ指定class中获取资源
   * @param resource
   * @param clazz
   * @return
   * @author kxyu
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
