package com.wind.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * 打码工具类
 * 
 * @author qianchun 2018/10/24
 */
public class CodeAsteriskUtil {
    /**
     * String字符串打码 身份证号码，手机号等
     *
     * @param startIdx 前缀的最后一个下标的下一个下标
     * @param endIdx 后缀的第一个下标
     * @param xingCount *的数量
     */
    public static String mask(String s, int startIdx, int endIdx, int xingCount) {
        if (StringUtils.isBlank(s)) {
            return "";
        }
        String prefix = s.substring(0, startIdx);
        String suffix = "";
        if (s.length() > (endIdx + 1)) {
            suffix = s.substring(endIdx);
        }

        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < xingCount; i++) {
            sb.append("*");
        }
        sb.append(suffix);
        return sb.toString();
    }

    /**
     * 手机号码打码 (183 ***** 124)
     *
     * @param mobile 手机号
     * @return 返回结果
     */
    public static String markMobile(String mobile) {
        if (StringUtils.isBlank(mobile) || mobile.length() < 6) {
            return mobile;
        }
        return mobile.substring(0, 3) + asterisk(mobile.length() - 6)
                + mobile.substring(mobile.length() - 3, mobile.length());
    }

    /**
     * 身份证打码 (610 *********** 3810)
     *
     * @param idCard 身份证
     * @return 返回结果
     */
    public static String markCardId(String idCard) {
        if (StringUtils.isBlank(idCard) || idCard.length() < 6) {
            return idCard;
        }
        return idCard.substring(0, 3) + asterisk(idCard.length() - 6)
                + idCard.substring(idCard.length() - 3, idCard.length());
    }

    /**
     * 银行卡号打码 (6224 *** *** 3123)
     *
     * @param bankCard 银行卡号
     * @return 返回结果
     */
    public static String markBankCard(String bankCard) {
        if (StringUtils.isBlank(bankCard) || bankCard.length() < 8) {
            return bankCard;
        }
        return bankCard.substring(0, 4) + " **** **** " + bankCard.substring(bankCard.length() - 4, bankCard.length());
    }

    /**
     * 姓名打码 (张**)
     *
     * @param name 姓名
     * @return 打码后结果
     */
    public static String markName(String name) {
        if (StringUtils.isBlank(name)) {
            return "";
        }
        return name.substring(0, 1) + asterisk(name.length() - 1);
    }

    /**
     * 公司名称打码 (北京******公司)
     *
     * @param companyName 公司名称
     * @return 打码后结果
     */
    public static String markCompanyName(String companyName) {
        if (StringUtils.isBlank(companyName) || companyName.length() <= 4) {
            return companyName;
        }else {
            String stars;
            if (companyName.length() - 4 > 5) {
                stars = asterisk(5);
            } else {
                stars = asterisk(companyName.length() - 4);
            }
            return companyName.substring(0, 2) + stars
                    + companyName.substring(companyName.length() - 2);
        }
    }

    /**
     * 公司证件号打码
     *
     * @param companyCertNo 公司证件号
     * @return 打码后结果
     */
    public static String markCompanyCertNo(String companyCertNo) {
        if (StringUtils.isBlank(companyCertNo)) {
            return "";
        }
        String prefix = companyCertNo.substring(0, 4);
        StringBuilder sb = new StringBuilder(prefix);
        for (int i = 0; i < companyCertNo.length() - 8; i++) {
            sb.append("*");
        }
        String suffix = companyCertNo.substring(companyCertNo.length() - 4);
        sb.append(suffix);
        return sb.toString();
    }

    /**
     * 返回指定数量星号
     * @param num 星号数量
     * @return 返回结果
     */
    private static String asterisk(int num) {
        if (num <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}