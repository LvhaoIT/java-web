package com.util;


import java.lang.reflect.Field;

/**
 * Created by IntelliJ IDEA.
 * User: LvHaoIT (asus)
 * Date: 2021/5/20
 * Time: 11:21
 */
public class ReflectUitl {

    /**
     *将任意类型对象内容转换为JSON格式字符串返回
     * @param obj
     * @return
     */
    public static String jsonObject(Object obj){
        Class classFile = null;
        Field fieldArray[]=null;
        StringBuffer json = new StringBuffer("{");
        //field用来存放类的属性，功能有获取当前对象的成员变量的类型，
        // 对成员变量重新设值
        //1.获得当前对象的class文件
        classFile = obj.getClass();
        //2.获得class文件的所有属性
        fieldArray=classFile.getDeclaredFields();
        //3.获得当前对象所有属性的值
        for(int i = 0 ;i<fieldArray.length;i++){
            Field field = fieldArray[i];
            /**
             * getName() ： 获取属性的名字
             *
             * get(Object obj) 返回指定对象obj上此 Field 表示的字段的值
             *
             * set(Object obj, Object value) 将指定对象变量上此 Field 对象表示的字段设置为指定的新值
             */
            field.setAccessible(true);//确保私有属性可以访问使用
            String fieldName = field.getName();
            try {
                Object value = field.get(obj);//将其值返回
                //4.将获得的字符串及其值凭借为json格式字符串
                //将属性名和属性值进行字符串拼接
                json.append("\"");
                json.append(fieldName);
                json.append("\":");
                json.append("\"");
                json.append(value);
                json.append("\"");

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if((i+1)<fieldArray.length)
             json.append(",");
        }
        json.append("}");
        return json.toString();
    }

}
