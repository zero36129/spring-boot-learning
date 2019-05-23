package com.zero.springbootlearning.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("rawtypes")
public class ModelUtils {

    /**
     * 单个对象的所有键值
     * 
     * @param object 单个对象
     * 
     * @return Map<String, Object> map 所有 String键 Object值 ex：{pjzyfy=0.00, xh=01, zzyl=0.00, mc=住院患者压疮发生率, pjypfy=0.00,
     *         rs=0, pjzyts=0.00, czydm=0037, lx=921, zssl=0.00}
     */
    public static Map<String, Object> getKeyAndValue(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            Object val = new Object();
            try {
                val = f.get(obj);
                // 得到此属性的值
                map.put(f.getName(), val);// 设置键值
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

            /*
             * String type = f.getType().toString();//得到此属性的类型 if (type.endsWith("String")) {
             * System.out.println(f.getType()+"\t是String"); f.set(obj,"12") ; //给属性设值 }else if(type.endsWith("int") ||
             * type.endsWith("Integer")){ System.out.println(f.getType()+"\t是int"); f.set(obj,12) ; //给属性设值 }else{
             * System.out.println(f.getType()+"\t"); }
             */

        }
        System.out.println("单个对象的所有键值==反射==" + map.toString());
        return map;
    }

    /**
     * 单个对象的某个键的值
     * 
     * @param object 对象
     * 
     * @param key    键
     * 
     * @return Object 键在对象中所对应得值 没有查到时返回空字符串
     */
    public static Object getValueByKey(Object obj, String key) {
        // 得到类对象
        Class userCla = (Class) obj.getClass();
        /* 得到类中的所有属性集合 */
        Field[] fs = userCla.getDeclaredFields();
        for (int i = 0; i < fs.length; i++) {
            Field f = fs[i];
            f.setAccessible(true); // 设置些属性是可以访问的
            try {

                if (f.getName().endsWith(key)) {
                    System.out.println("单个对象的某个键的值==反射==" + f.get(obj));
                    return f.get(obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        // 没有查到时返回空字符串
        return "";
    }

    /**
     * 多个（列表）对象的所有键值
     * 
     * @param object
     * @return List<Map<String,Object>> 列表中所有对象的所有键值 ex:[{pjzyfy=0.00, xh=01, zzyl=0.00, mc=住院患者压疮发生率, pjypfy=0.00, rs=0,
     *         pjzyts=0.00, czydm=0037, lx=921, zssl=0.00}, {pjzyfy=0.00, xh=02, zzyl=0.00, mc=新生儿产伤发生率, pjypfy=0.00, rs=0,
     *         pjzyts=0.00, czydm=0037, lx=13, zssl=0.00}, {pjzyfy=0.00, xh=03, zzyl=0.00, mc=阴道分娩产妇产伤发生率, pjypfy=0.00,
     *         rs=0, pjzyts=0.00, czydm=0037, lx=0, zssl=0.00}, {pjzyfy=0.00, xh=04, zzyl=0.75, mc=输血反应发生率, pjypfy=0.00,
     *         rs=0, pjzyts=0.00, czydm=0037, lx=0, zssl=0.00}, {pjzyfy=5186.12, xh=05, zzyl=0.00, mc=剖宫产率, pjypfy=1611.05,
     *         rs=13, pjzyts=7.15, czydm=0037, lx=13, zssl=0.00}]
     */
    public static List<Map<String, Object>> getKeysAndValues(List<Object> object) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (Object obj : object) {
            Class userCla;
            // 得到类对象
            userCla = (Class) obj.getClass();
            /* 得到类中的所有属性集合 */
            Field[] fs = userCla.getDeclaredFields();
            Map<String, Object> listChild = new HashMap<String, Object>();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                f.setAccessible(true); // 设置些属性是可以访问的
                Object val = new Object();
                try {
                    val = f.get(obj);
                    // 得到此属性的值
                    listChild.put(f.getName(), val);// 设置键值
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            list.add(listChild);// 将map加入到list集合中
        }
        System.out.println("多个（列表）对象的所有键值====" + list.toString());
        return list;
    }

    /**
     * 多个（列表）对象的某个键的值
     * 
     * @param object
     * @param key
     * @return List<Object> 键在列表中对应的所有值 ex:key为上面方法中的mc字段 那么返回的数据就是： [住院患者压疮发生率, 新生儿产伤发生率, 阴道分娩产妇产伤发生率, 输血反应发生率, 剖宫产率]
     */
    public static List<Object> getValuesByKey(List<Object> object, String key) {
        List<Object> list = new ArrayList<Object>();
        for (Object obj : object) {
            // 得到类对象
            Class userCla = (Class) obj.getClass();
            /* 得到类中的所有属性集合 */
            Field[] fs = userCla.getDeclaredFields();
            for (int i = 0; i < fs.length; i++) {
                Field f = fs[i];
                f.setAccessible(true); // 设置些属性是可以访问的
                try {
                    if (f.getName().endsWith(key)) {
                        list.add(f.get(obj));
                    }
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("多个（列表）对象的某个键的值列表====" + list.toString());
        return list;
    }

    /**
     * java读取文件中的属性类型
     * 
     * @param model
     * @return
     * @throws Exception
     */
    public static Map<String, String> getModelAttriButeType(Object model) throws Exception {
        Field[] field = model.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
        Map<String, String> map = new HashMap<String, String>();
        for (int j = 0; j < field.length; j++) { // 遍历所有属性
            String name = field[j].getName(); // 获取属性的名字

            // System.out.print("attribute name:"+name);
            name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
            String type = field[j].getGenericType().toString(); // 获取属性的类型
            /*
             * if(type.equals("class java.lang.String")){ //如果type是类类型，则前面包含"class "，后面跟类名 Method m =
             * model.getClass().getMethod("get"+name); String value = (String) m.invoke(model); //调用getter方法获取属性值 if(value != null){
             * 
             * System.out.println("attribute value:"+value); } }
             */
            type = type.replace("class ", "");
            // System.out.println("=>:"+type);
            map.put(name, type);

        }
        return map;
    }

}
