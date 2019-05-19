package com.wind.utils;

import org.apache.commons.lang3.StringUtils;

/**
 * @author qianchun 2019/04/16
 */
public class IdCardUtil {
    public static Integer getSex(String cardId) {
        if (StringUtils.isNotBlank(cardId) && cardId.length() == 18
                && StringUtils.isNumeric(cardId.substring(16, 17))) {
            return Integer.parseInt(cardId.substring(16, 17)) % 2;
        }

        if (StringUtils.isNotBlank(cardId) && cardId.length() == 15
                && StringUtils.isNumeric(cardId.substring(14, 15))) {
            return Integer.parseInt(cardId.substring(14, 15)) % 2;
        }
        return null;
    }

    public static String getBirthDate(String cardId) {
        if (StringUtils.isNotBlank(cardId) && cardId.length() == 18 && StringUtils.isNumeric(cardId.substring(6, 14))) {
            return cardId.substring(6, 14);
        }
        return null;
    }
}
