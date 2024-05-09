package com.ripper.budding.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ripper [RipperF@hotmail.com]
 * @depiction
 */
public abstract class StringUtils {

    public static final String RANDOM_STR = "abcdefghijklmnopqrstuvwxyz0123456789";

    public static boolean isEmpty(Object str) {
        return (str == null || "".equals(str));
    }

    public static boolean hasLength(CharSequence str) {
        return (str != null && str.length() > 0);
    }

    public static boolean hasLength(String str) {
        return hasLength((CharSequence) str);
    }

    /**
     * 获取字符串中的英文字母（过滤掉中文和数字）
     *
     * @return
     * @author ripper [RipperF@hotmail.com]
     */
    public static final String getEnglishStr(String str) {
        StringBuffer sbf = new StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            // Java判断一个字符串是否有中文是利用Unicode编码来判断，因为中文的编码区间为：65--122
            if ((charArray[i] >= 65) && (charArray[i] <= 122)) {
                sbf.append(charArray[i]);
            }
        }
        return sbf.toString();
    }

    /**
     * <pre>
     * 将字符串的首字母变为大写, 其他字符不变.
     * 如果字符串为null 或 长度==0, 则直接返回该字符串.
     * </pre>
     *
     * @param str 给出的字符串, 可以为null.
     * @return String 变换后的字符串.
     * @author ripper [RipperF@hotmail.com]
     */
    public static String getUpperStr(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }
        StringBuffer sb = new StringBuffer(str.length());
        sb.append(Character.toUpperCase(str.charAt(0)));
        sb.append(str.substring(1));
        return sb.toString();
    }

    /**
     * <pre>
     * 将字符串的首字母变为小写, 其他字符不变.
     * 如果字符串为null 或 长度==0, 则直接返回该字符串.
     * </pre>
     *
     * @param str 给出的字符串, 可以为null.
     * @return String 变换后的字符串.
     */
    public static String getLowerStr(String str) {
        if (null == str || str.length() == 0) {
            return str;
        }
        StringBuffer sb = new StringBuffer(str.length());
        sb.append(Character.toLowerCase(str.charAt(0)));
        sb.append(str.substring(1));
        return sb.toString();
    }

    /**
     * <pre>
     * 检查给出的两个字符串是否内容（忽略大小写）相同,
     * 任意一个字符串为Null时, 返回false.
     *
     * 如：
     * StringUtil.equalsWith("", "")       = true
     * StringUtil.equalsWith(" ", " ")     = true
     * StringUtil.equalsWith("", " ")      = false
     * StringUtil.equalsWith("abc", "abc") = true
     * StringUtil.equalsWith("aBc", "AbC") = true
     * StringUtil.equalsWith("aBc", null)  = false
     * </pre>
     *
     * @param str1 给出第一个的字符串. 如果为null, 则返回false.
     * @param str2 给出第二个的字符串. 如果为null, 则返回false.
     * @return boolean 是否内容相同.
     */
    public static boolean equals(String str1, String str2) {
        return equals(str1, str2, true);
    }

    /**
     * <pre>
     * 检查给出的两个字符串是否内容相同,  验证时指定是否区分大小写,
     * 当任意一个字符串为Null时, 返回false.
     *
     * 如：
     * StringUtil.equalsWith("aBc", "AbC", fasle) = fasle
     * StringUtil.equalsWith("aBc", null, true)   = false
     * </pre>
     *
     * @param str1       给出的第一个字符串. 如果为null, 则返回false.
     * @param str2       给出的第二个字符串. 如果为null, 则返回false.
     * @param ignoreCase 是否忽略字符大小写进行匹配, true:区分大小写；false:忽略大小写.
     * @return boolean 是否内容相同.
     */
    public static boolean equals(String str1, String str2, boolean ignoreCase) {
        if (null == str1 || null == str2) {
            return false;
        }

        // 判断是否需要忽略大小写进行比较
        if (ignoreCase) {
            str1 = str1.toLowerCase(Locale.ENGLISH);
            str2 = str2.toLowerCase(Locale.ENGLISH);
        }
        return str1.equals(str2);
    }

    /**
     * <pre>
     * 将给出的字符串用特定的分隔符拆分成字符串数组.
     *
     * 如果给出的字符串为null, 则返回String[0];
     * 如果分隔符为null, 则返回以源字符串为唯一元素的字符串数组;
     * 如果分隔符为"", 则将源字符串按照每个字符拆分成字符串数组;
     * 否则, 用分隔符拆分源字符串.
     * </pre>
     *
     * @param str       给出的字符串, 可以为null.
     * @param separator 分隔符可以为null和"".
     * @return 拆分后的字符串数组.
     */
    public static String[] delimitedToArray(String str, String separator) {
        if (null == str) {
            return new String[0];
        }
        if (null == separator) {
            return new String[]{str};
        }

        List<String> result = new ArrayList<String>();
        if ("".equals(separator)) {
            for (int i = 0; i < str.length(); i++) {
                result.add(str.substring(i, i + 1));
            }
        } else {
            int index = 0;
            int delIndex = 0;
            while ((delIndex = str.indexOf(separator, index)) != -1) {
                result.add(str.substring(index, delIndex));
                index = delIndex + separator.length();
            }
            if (str.length() > 0 && index <= str.length()) {
                // Add rest of String, but not in case of empty input.
                result.add(str.substring(index));
            }
        }
        return toArray(result);
    }

    /**
     * <pre>
     * 将一个字符串集合对象变换为字符串数组对象.
     *
     * 如果提供的集合为null, 则直接返回null.
     * </pre>
     *
     * @param collection 字符串集合对象, 可以为null.
     * @return String[] 字符串数组对象, 有可能为null.
     */
    public static String[] toArray(Collection<String> collection) {
        if (null == collection) {
            return null;
        }

        String[] array = new String[collection.size()];
        return (String[]) collection.toArray(array);
    }

    /**
     * 校验字符串是否是空字符串
     *
     * @param strs
     * @return
     */
    public static boolean isBlank(String... strs) {
        if (strs == null) {
            return true;
        }
        for (String str : strs) {
            if (str == null || "".equals(str.trim()) || "null".equals(str.trim()) || "".equals(str.trim())
                    || "undefined".equals(str.trim()) || "(null)".equals(str.trim())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 字符串是否数字
     *
     * @param str 需比对的字符串
     * @return true 是数字 false 非数字
     */
    public static boolean isNumeric(String str) {
        if (isBlank(str))
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * 计算是否含有汉字 @param str @return @throws
     */
    public static boolean isChineseChar(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }

    /**
     * 获取字符串中的链接 (可以优化) 可截取http|https|ftp开头的链接
     *
     * @param str
     * @return
     * @author ripper[RipperF@hotmail.com]
     */
    public static List<String> screenUrls(String str) {
        List<String> result = new ArrayList<String>();
        String pattern = "((http|https|ftp)\\://[A-Za-z0-9\\\\#\\\\.\\\\/=\\\\?%\\\\_\\\\&~`':+!(^\\\\<)-]+)";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        while (m.find()) {
            result.add(m.group());
        }
        return result;
    }

    /**
     * 获取一个随机的字符串
     *
     * @return 随机生成的字符串
     */
    public static String getRandomStr(int length) {
        String base = RANDOM_STR;
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 过滤字符串中的emoji表情
     *
     * @param str 需要过滤的字符串
     * @return 剔除表情后的字符串
     */
    public static String replaceEmoji(String str) {
        Pattern emoji = Pattern.compile("[\ud83c\udc00-\ud83c\udfff]|[\ud83d\udc00-\ud83d\udfff]|[\u2600-\u27ff]",
                Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
        StringBuffer sbr = new StringBuffer();
        Matcher m = emoji.matcher(str);
        while (m.find()) {
            m.appendReplacement(sbr, "");
        }
        m.appendTail(sbr);
        return sbr.toString();
    }

    /**
     * @param str
     * @return
     * @Description:获取艾特人
     */
    public static List<String> findAitList(String str) {
        // Pattern p =Pattern.compile("@[\\u4e00-\\u9fa5A-Za-z0-9_\\*-]{2,12}");
        Pattern p = Pattern.compile("@[\\u4e00-\\u9fa5A-Za-z0-9_-]{2,12}");
        Matcher matcher = p.matcher(str);
        List<String> list = new ArrayList<String>();
        while (matcher.find()) {
            list.add(matcher.group().substring(1));
        }
        return list;
    }

    /**
     * 校验昵称(支持英文 数字)
     *
     * @return
     */
    public static boolean checkNickname(String nickename) {
        Pattern p = Pattern.compile("^[\\u4e00-\\u9fa5a-zA-Z0-9_-]{2,12}$");
        Matcher m = p.matcher(nickename);
        if (m.find()) {
            return true;
        }
        return false;

    }

}
