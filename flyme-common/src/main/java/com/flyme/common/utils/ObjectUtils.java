package com.flyme.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 对象校验工具类
 */
public class ObjectUtils {
    public static final Logger log = LoggerFactory.getLogger(ObjectUtils.class);

    /**
     * 检验对象是否为空
     */
    public static boolean isEmpty(Object obj) {
        if (obj == null || obj.equals("undefined")) {
            return true;
        } else if (obj instanceof String && (obj.equals("") || StringUtils.isBlank(obj.toString()) || StringUtils.isEmpty(obj.toString()))) {
            return true;
        } else if (obj instanceof Collection && ((Collection<?>) obj).isEmpty() && ((Collection<?>) obj).size() == 0) {
            return true;
        } else if (obj instanceof Map && ((Map<?, ?>) obj).isEmpty()) {
            return true;
        } else if (obj instanceof Object[] && ((Object[]) obj).length == 0) {
            return true;
        }
        return false;
    }

    /**
     * 检验对象是字符串
     */
    public static boolean isString(Object obj) {
        if (isNotEmpty(obj) && obj instanceof String) {
            return true;
        }
        return false;
    }

    /**
     * 检验对象是否为空
     */
    public static boolean isNull(Object obj) {
        if (obj == null || obj.equals("undefined")) {
            return true;
        } else if (obj instanceof String && (obj.equals("") || StringUtils.isBlank(obj.toString()) || StringUtils.isEmpty(obj.toString()))) {
            return true;
        } else if (obj instanceof Map && ((Map<?, ?>) obj).isEmpty()) {
            return true;
        }
        return false;
    }

    public static int getSize(Object obj) {
        int size = 0;
        if (obj instanceof Collection) {
            size = ((Collection<?>) obj).size();
        } else if (obj instanceof Map) {
            size = ((Map<?, ?>) obj).size();
        } else if (obj instanceof Object[]) {
            size = ((Object[]) obj).length;
        }
        return size;
    }

    /**
     * 检验对象是否为空
     */
    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    /**
     * 检验对象是否为undefined 或者null
     */
    public static boolean isNullOrUndefined(Object obj) {
        if (obj == null) {
            return true;
        } else if (obj instanceof String && (obj.equals("undefined"))) {
            return true;
        } else {
            return false;
        }
    }

    public static String replaceBlank(String str) {
        String dest = "";
        if (ObjectUtils.isNotEmpty(str)) {
            if (str != null) {
                Pattern p = Pattern.compile("\t|\r|\n");
                Matcher m = p.matcher(str);
                dest = m.replaceAll("");
            }
        }
        return dest;
    }


    public static Boolean isChinese(Object object) {
        Boolean tag = true;
        if (ObjectUtils.isNotEmpty(object)) {
            char[] ch = object.toString().toCharArray();
            for (char c : ch) {
                if (!check(c)) {
                    tag = false;
                }
            }
        } else {
            tag = false;
        }
        return tag;
    }

    public static boolean check(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    public static boolean isPhoneNumber(Object phoneNumber) {

        boolean isValid = false;
        if (ObjectUtils.isNotEmpty(phoneNumber)) {
            String expression = "((^(1)[3-9][0-9]{9}$)|(^0[1,2]{1}\\d{1}-?\\d{8}$)|(^0[3-9] {1}\\d{2}-?\\d{7,8}$)|(^0[1,2]{1}\\d{1}-?\\d{8}-(\\d{1,4})$)|(^0[3-9]{1}\\d{2}-? \\d{7,8}-(\\d{1,4})$))";
            CharSequence inputStr = phoneNumber.toString();

            Pattern pattern = Pattern.compile(expression);

            Matcher matcher = pattern.matcher(inputStr);

            if (matcher.matches()) {
                isValid = true;
            }
        }
        return isValid;
    }

    public static boolean isEmail(String email) {
        Boolean tag = false;
        if (isNotEmpty(email)) {
            String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
            Pattern p = Pattern.compile(str);
            Matcher m = p.matcher(email);

            tag = m.matches();
        }
        return tag;
    }

    /**
     * 利用正则表达式判断字符串是否是数字
     */
    public static boolean isNumeric(Object str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str.toString());
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }

    public static boolean isLetter(Object s) {
        Boolean tag = false;
        if (ObjectUtils.isNotEmpty(s)) {
            String matcher = "^[a-zA-Z]*";
            Pattern p = Pattern.compile(matcher);
            Matcher m = p.matcher(s.toString());
            tag = m.matches();
        }
        return tag;

    }

    public static boolean isMobile(String s) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[0-9])|(17[0-9])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(s);
        return m.matches();
    }


    /**
     * 解码
     */
    public static String URLDecoder(String str) {
        try {
            if (ObjectUtils.isNotEmpty(str)) {
                str = URLDecoder.decode(str, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * 编码
     */
    public static String URLEncode(String str) {
        try {
            if (ObjectUtils.isNotEmpty(str)) {
                str = URLEncoder.encode(str, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static BigDecimal toFixed(BigDecimal v, int scale) {
        BigDecimal bigDecimal = new BigDecimal("0.0");
        if (ObjectUtils.isNotEmpty(v)) {
            bigDecimal = v.setScale(scale, BigDecimal.ROUND_HALF_UP);
        }
        return bigDecimal;
    }

    /**
     * 一直入
     */
    public static BigDecimal roundUp(BigDecimal v, int scale) {
        return v.setScale(scale, BigDecimal.ROUND_UP);
    }

    /**
     * b1/b2
     */
    public static BigDecimal divide(BigDecimal b1, BigDecimal b2, int scale) {
        MathContext mc = new MathContext(20, RoundingMode.HALF_DOWN);
        return b1.divide(b2, mc).setScale(scale, BigDecimal.ROUND_UP);
    }

    /**
     * 取余
     */
    public static BigDecimal getBalance(BigDecimal v) {
        return roundUp(v, 0).subtract(toFixed(v, 2));
    }

    /**
     * 取余
     */
    public static BigDecimal getBalance(BigDecimal v, int scale) {
        return roundUp(toFixed(v, scale), 0).subtract(toFixed(v, scale));
    }


    /**
     * 返回字符串如为空返回默认值
     */
    public static String getString(Object s, String defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return (s.toString().trim());
    }

    /**
     * 分割字符串
     */
    public static String[] split(String s, String regex) {
        if (isEmpty(s)) {
            return null;
        } else {
            return s.split(regex);
        }

    }


    public static boolean isInherit(Class<?> cls, Class<?> parentClass) {
        return parentClass.isAssignableFrom(cls);
    }

    /**
     * 返回字符串如为空返回默认值
     */
    public static String getString(int n, String defval) {
        Integer integer = new Integer(n);
        return integer.toString();
    }

    /**
     * 返回Integer如为空返回默认值
     */
    public static Integer getInteger(Integer s, Integer defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return (s);
    }

    /**
     * 返回Integer如为空返回默认值
     */
    public static Integer getInteger(String s) {
        if (!isEmpty(s)) {
            return Integer.parseInt(s);
        }
        return 0;
    }

    /**
     * 返回Integer如为空返回默认值
     */
    public static Integer getInteger(Object s) {
        int i = 0;
        if (!isEmpty(s)) {
            i = Integer.parseInt(s.toString());
        }
        return i;
    }

    /**
     * 返回Integer如为空返回默认值
     */
    public static Integer getInteger(String s, Integer defval) {
        if (isEmpty(s)) {
            return (defval);
        } else {
            return Integer.parseInt(s);
        }

    }

    /**
     * v1>v2
     */
    public static Boolean gt(BigDecimal v1, BigDecimal v2) {
        Boolean tag = false;
        if (v1.compareTo(v2) == 1) {
            tag = true;
        }
        return tag;
    }

    /**
     * v1>=v2
     */
    public static Boolean ge(BigDecimal v1, BigDecimal v2) {
        Boolean tag = false;
        if (v1.compareTo(v2) == 1) {
            tag = true;
        }
        if (v1.compareTo(v2) == 0) {
            tag = true;
        }
        return tag;
    }

    /**
     * v1<v2
     */
    public static Boolean lt(BigDecimal v1, BigDecimal v2) {
        Boolean tag = false;
        if (v1.compareTo(v2) == -1) {
            tag = true;
        }
        return tag;
    }

    /**
     * v1=v2
     */
    public static Boolean eq(BigDecimal v1, BigDecimal v2) {
        Boolean tag = false;
        if (v1.compareTo(v2) == 0) {
            tag = true;
        }
        return tag;
    }

    /**
     * 返回Short如为空返回默认值
     */
    public static Short getShout(Short s, Short defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return (s);
    }

    /**
     * 判断BigDecimal是否大于0
     */
    public static Boolean gtzero(BigDecimal v) {
        Boolean tag = false;
        if (ObjectUtils.isNotEmpty(v)) {
            if (v.doubleValue() > 0) {
                tag = true;
            }
        }
        return tag;
    }

    /**
     * 判断BigDecimal是否大于等于0
     */
    public static Boolean gezero(BigDecimal v) {
        Boolean tag = false;
        if (ObjectUtils.isNotEmpty(v)) {
            if (v.compareTo(new BigDecimal("0.0")) == 0 || v.compareTo(new BigDecimal("0.0")) == 1) {
                tag = true;
            }
        }
        return tag;
    }

    /**
     * 判断BigDecimal是等于0
     */
    public static Boolean eqzero(BigDecimal v) {
        Boolean tag = false;
        if (ObjectUtils.isNotEmpty(v)) {
            if (v.compareTo(new BigDecimal("0.0")) == -1) {
                tag = true;
            }
        }
        return tag;
    }

    /**
     * 判断BigDecimal不等于0
     */
    public static Boolean nezero(BigDecimal v) {
        Boolean tag = true;
        if (ObjectUtils.isNotEmpty(v)) {
            if (v.compareTo(new BigDecimal("0.0")) == 0) {
                tag = false;
            }
        }
        return tag;
    }

    /**
     * 判断BigDecimal是否xiao于0
     */
    public static Boolean ltzero(BigDecimal v) {
        Boolean tag = false;
        if (ObjectUtils.isNotEmpty(v)) {
            if (v.doubleValue() < 0) {
                tag = true;
            }
        }
        return tag;
    }

    /**
     * 判断BigDecimal是否小于等于0
     */
    public static Boolean lezero(BigDecimal v) {
        Boolean tag = false;
        if (ObjectUtils.isNotEmpty(v)) {
            if (v.compareTo(new BigDecimal("0.0")) == 0) {
                tag = true;
            }
            if (v.compareTo(new BigDecimal("0.0")) == -1) {
                tag = true;
            }
        }
        return tag;
    }

    /**
     * 返回Double如为空返回默认值
     */
    public static Double getDouble(Double s, Double defval) {
        if (isEmpty(s)) {
            return (defval);
        }
        return (s);
    }

    /**
     * 返回Double如为空返回默认值
     */
    public static Double getDouble(Double s, String defval) {
        if (isEmpty(s)) {
            return new Double(defval);
        }
        return s;
    }

    /**
     * 返回Double如为空返回默认值
     */
    public static BigDecimal getBigDecimal(BigDecimal s, Double defval) {
        if (isEmpty(s)) {
            return new BigDecimal(defval);
        }
        return (s);
    }

    /**
     * 返回String如为空返回默认值
     */
    public static Double getDouble(String s, String defval) {
        Double d = new Double(s);
        if (isNotEmpty(s)) {
            d = new Double(s);
        }
        return d;
    }

    /**
     * Objcet转BigDecimal
     */
    public static BigDecimal getBigDecimal(Object s, String defval) {
        BigDecimal bigDecimal = new BigDecimal(defval);
        if (isNotEmpty(s)) {
            bigDecimal = new BigDecimal(s.toString());
        }
        return bigDecimal;
    }

    /**
     * 返回BigDecimal如为空返回默认值
     */
    public static BigDecimal getBigDecimal(BigDecimal s, String defval) {
        if (isEmpty(s)) {
            return new BigDecimal(defval);
        }
        return (s);
    }

    /**
     * 比较两个Integer的大小，返回较大的Integer
     */
    public static Integer getIntegerAbs(Integer s1, Integer s2) {
        if (Math.abs(s1) > Math.abs(s2)) {
            return Math.abs(s1);
        } else {
            return Math.abs(s2);
        }
    }

    /**
     * 返回某Integer的负值
     */
    public static Integer getIntegerNegative(Integer s1) {
        return -s1;
    }

    public static Object getObject(Class<?> cls) {
        Object object = null;
        try {
            object = Class.forName(cls.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }

    /**
     * 检验字符串是否为空
     */
    public static boolean isEmpty(String str) {
        if (str == null || str.length() <= 0 || str == "" || str.equals("null") || str.equals("undefined")) {
            return true;
        }
        return false;
    }

    /**
     * 检验字符串是否为空
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }


    /**
     * 所有对象都不能为空
     */
    public static Boolean allNotEmpty(Object... objs) {
        Boolean tag = true;
        for (Object obj : objs) {
            tag = isNotEmpty(obj);
            if (!tag) {
                break;
            }
        }
        return tag;
    }

    /**
     * 所有对象都为空
     */
    public static Boolean allEmpty(Object... objs) {
        Boolean tag = true;
        for (Object obj : objs) {
            tag = isEmpty(obj);
            if (!tag) {
                break;
            }
        }
        return tag;
    }

    /**
     * 判断某个字符串是否存在于数组中
     */
    public static boolean contains(String[] stringArray, String source) {
        List<String> tempList = Arrays.asList(stringArray);
        if (tempList.contains(source)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断某个字符串是否存在于数组中
     */
    public static boolean contains(List<String> stringArray, String source) {
        if (stringArray.contains(source)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * java风格编程：驼峰式命名<br/>
     */
    public static String javaStyle(String columnName) {
        String patternStr = "(_[a-z])";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher matcher = pattern.matcher(columnName);
        StringBuffer buf = new StringBuffer();
        while (matcher.find()) {
            String replaceStr = matcher.group();
            matcher.appendReplacement(buf, replaceStr.toUpperCase());
        }
        matcher.appendTail(buf);
        return buf.toString().replaceAll("_", "");
    }



    /**
     * 首字母转小写
     */
    public static String toLowerCaseFirstOne(String s) {
        if (Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    public static String upperCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'a' && ch[0] <= 'z') {
            ch[0] = (char) (ch[0] - 32);
        }
        return new String(ch);
    }

    public static String lowerCase(String str) {
        char[] ch = str.toCharArray();
        if (ch[0] >= 'A' && ch[0] <= 'Z') {
            ch[0] = (char) (ch[0] + 32);
        }
        return new String(ch);
    }

    /**
     * 首字母转大写
     */
    public static String toUpperCaseFirstOne(String s) {
        if (Character.isUpperCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

    /**
     * 生成UUID
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "").toUpperCase();

    }

    /**
     * 获取Map
     */
    public static Map<String, Object> getHashMap() {
        return new HashMap<String, Object>();
    }


    /**
     * 获取List
     */
    public static <T> List<T> getArrayList() {
        return new ArrayList<T>();
    }

    public static String getSalt(int length) { // length表示生成字符串的长度
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }




    /**
     * 获取验证吗
     */
    public static String getIdentifyingCode() {
        return new Integer((int) ((Math.random() * 9 + 1) * 1000)).toString();
    }

    public static int getStatus(String t) {
        int result = 0;
        if (t.equals("是")) {
            result = 1;
        }
        return result;
    }

    /**
     * 取出一个指定长度大小的随机正整数.
     *
     * @param length int 设定所取出随机数的长度。length小于11
     * @return int 返回生成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 字符串转换unicode
     */
    public static String string2Unicode(String string) {

        StringBuffer unicode = new StringBuffer();

        for (int i = 0; i < string.length(); i++) {

            // 取出每一个字符
            char c = string.charAt(i);

            // 转换为unicode
            unicode.append("\\u" + Integer.toHexString(c));
        }

        return unicode.toString();
    }

    /**
     * unicode 转字符串
     */
    public static String unicode2String(String unicode) {

        StringBuffer string = new StringBuffer();

        String[] hex = unicode.split("\\\\u");

        for (int i = 1; i < hex.length; i++) {

            // 转换出每一个代码点
            int data = Integer.parseInt(hex[i], 16);

            // 追加成string
            string.append((char) data);
        }

        return string.toString();
    }


    /* 从指定字符串截取 */
    public static String substring(String str, String chat) {
        int index = str.indexOf(chat);
        if (index != -1) {
            str = str.substring(index + 1);
        }
        return str;
    }

    /**
     * 格式化人民币
     */
    public static String formatCurrency(BigDecimal d) {
        if (ObjectUtils.isNotEmpty(d)) {
            return d.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        } else {
            return "";
        }
    }


    public static Integer getRandomNum() {
        int n = 1;
        Random rand = new Random();
        n = rand.nextInt(5) + 1;
        return n;
    }

    /*
     * 删除List元素
     */
    public static List<?> removeList(List<?> list, Object target) {
        final CopyOnWriteArrayList<?> cowList = new CopyOnWriteArrayList<Object>(list);
        for (Object item : cowList) {
            if (item.equals(target)) {
                cowList.remove(item);
            }
        }
        return cowList;
    }

}
