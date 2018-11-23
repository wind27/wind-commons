package com.wind.utils;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLEncoder;
import java.util.*;

/**
 * TencentAiOCRUtil 腾讯 AI OCR识别工具类
 *
 * @author qianchun 2018/10/10
 **/
public class TencentAiOCRUtil {

    private static final Logger logger = LoggerFactory.getLogger(TencentAiOCRUtil.class);

    /*
     * 营业执照解析结果 { "ret":0, "msg":"ok", "data":{ "item_list":[ { "item":"注册号", "itemstring":"440126000093592",
     * "itemcoord":[ { "x":406, "y":216, "width":75, "height":12 } ], "itemconf":0.999824 }, { "item":"法定代表人",
     * "itemstring":"吉水文", "itemcoord":[ { "x":314, "y":295, "width":40, "height":15 } ], "itemconf":0.65681 }, {
     * "item":"公司名称", "itemstring":"广州志雅工业川微波设备有限公司", "itemcoord":[ { "x":317, "y":240, "width":145, "height":14 } ],
     * "itemconf":0.948406 }, { "item":"地址", "itemstring":"广州市番禺区洛浦街西三村开发东路3号", "itemcoord":[ { "x":320, "y":276,
     * "width":169, "height":14 } ], "itemconf":0.986457 }, { "item":"营业期限", "itemstring":"2010年05月25日至长期",
     * "itemcoord":[ { "x":313, "y":346, "width":113, "height":14 } ], "itemconf":0.977358 } ] }
     */

    /*
     * 身份证解析结果 { "ret":0, "msg":"ok", "data":{ "name":"冯娥", "sex":"女", "nation":"汉", "birth":"1982/12/19",
     * "address":"湖北省兴山县高桥乡贺家坪村二组中华人民共和国居民身份证签发机关长春市公安局朝阳分局", "id":"420526198212190420", "frontimage":"",
     * "authority":"", "valid_date":"", "backimage":"" } }
     */

    /**
     * 营业执照识别服务URL
     */
    private static final String BUSINESS_LICENSE_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_bizlicenseocr";

    /**
     * 身份证识别服务URL
     */
    private static final String IDCARD_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_idcardocr";

    /**
     * 常用图片识别服务URL
     */
    private static final String COMMONS_PIC_URL = "https://api.ai.qq.com/fcgi-bin/ocr/ocr_generalocr";


    /**
     * 通用图片识别
     * @param appId OCR 应用id
     * @param appkey OCR 应用key
     * @param file 图片文件
     * @return 返回结果
     */
    public static String ocrCommon(String appId, String appkey, File file) {
        try {
            TreeMap<String, String> params = getBaseParam(appId);
            String img64 = getImgStr(file);
            if (img64 == null) {
                logger.error("OCR通用图片识别, 获取图片数据流失败");
                return null;
            }
            params.put("image", img64);
            return request(appkey, BUSINESS_LICENSE_URL, params);
        } catch (Exception e) {
            logger.error("OCR通用图片识别, 获取图片数据流异常", e);
            return null;
        }
    }


    /*
     * { "ret": 0, "msg": "ok", "data": { "name": "冯娥", "sex": "女", "nation": "汉", "birth": "1982\/12\/19", "address":
     * "湖北省兴山县高桥乡贺家坪村二组中华人民共和国居民身份证签发机关长春市公安局朝阳分局", "id": "420526198212190420", "frontimage": "", "authority": "",
     * "valid_date": "", "backimage": "" } }
     */
    /**
     * 识别营业执照
     *
     * @param appId OCR 应用id
     * @param appkey OCR 应用key
     * @param file 图片文件
     * @return 返回结果
     */
    public static String ocrBusinessLicence(String appId, String appkey, File file) {
        try {
            TreeMap<String, String> params = getBaseParam(appId);
            String img64 = getImgStr(file);
            if (img64 == null) {
                logger.error("OCR营业执照识别, 获取图片数据流失败");
                return null;
            }
            params.put("image", img64);
            return request(appkey, BUSINESS_LICENSE_URL, params);
        } catch (Exception e) {
            logger.error("OCR营业执照识别, 获取图片数据流异常", e);
            return null;
        }
    }

    /**
     * 识别身份证
     *
     * @param appId OCR 应用id
     * @param appkey OCR 应用key
     * @param cardType 身份证图片类别 0 正面 1 反面
     * @param file 图片文件
     * @return 返回结果
     */
    public static String ocrIdCard(String appId, String appkey, int cardType, File file) {
        try {
            TreeMap<String, String> params = getBaseParam(appId);
            String img64 = getImgStr(file);
            if (img64 == null) {
                logger.error("OCR身份证识别, 获取图片数据流失败");
                return null;
            }
            if (cardType != 1 && cardType != 0) {
                logger.error("OCR身份证识别, 身份证 cardType={} 不正确", cardType);
                return null;
            }
            params.put("image", img64);
            params.put("card_type", cardType + "");
            return request(appkey, IDCARD_URL, params);
        } catch (Exception e) {
            logger.error("OCR身份证识别, 获取图片数据流异常", e);
            return null;
        }
    }

    // /**
    // * 识别身份证
    // *
    // * @param appId OCR 应用id
    // * @param appkey OCR 应用key
    // * @param cardType 身份证图片类别 0 正面 1 反面
    // * @param imgURL 图片url地址
    // * @return 返回结果
    // */
    // public static String ocrIdCard(String appId, String appkey, int cardType, String imgURL) {
    // try {
    // TreeMap<String, String> params = getBaseParam(appId);
    // String img64 = getImgStr(imgURL);
    // if (img64 == null) {
    // logger.error("OCR身份证识别, 获取图片数据流失败, imgURL={}", imgURL);
    // return null;
    // }
    // if (cardType != 0 && cardType != 1) {
    // logger.error("OCR身份证识别, 身份证 cardType={} 不正确", cardType);
    // return null;
    // }
    // params.put("image", img64);
    // params.put("card_type", cardType + "");
    // return request(appkey, IDCARD_URL, params);
    // } catch (Exception e) {
    // logger.error("OCR身份证识别, 获取图片数据流异常", e);
    // return null;
    // }
    // }

    // /**
    // * 识别营业执照
    // *
    // * @param appId OCR 应用id
    // * @param appkey OCR 应用key
    // * @param imgURL 图片url地址
    // * @return 返回识别结果
    // */
    // public static String ocrBusinessLicence(String appId, String appkey, String imgURL) {
    // try {
    // TreeMap<String, String> params = getBaseParam(appId);
    // String img64 = getImgStr(imgURL);
    // if (img64 == null) {
    // logger.error("OCR营业执照识别, 获取图片数据流失败, imgURL={}, params={}", imgURL, JSONObject.toJSONString(params));
    // return null;
    // }
    // params.put("image", img64);
    // return request(appkey, BUSINESS_LICENSE_URL, params);
    // } catch (Exception e) {
    // logger.error("OCR营业执照识别, 获取图片数据流异常", e);
    // return null;
    // }
    // }

    // ------------------------------------------------------------------------------------------------------------------
    /**
     * 生成 nonce str 随机值
     *
     * @param length 生成随机值长度
     * @return 返回结果
     */
    private static String getNonceStr(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 初始化基础参数
     *
     * @param appId OCR 应用id
     * @return 返回结果
     */
    private static TreeMap<String, String> getBaseParam(String appId) {
        TreeMap<String, String> params = new TreeMap<>();
        // 时间戳
        String time_stamp = System.currentTimeMillis() / 1000 + "";
        // 随机字符串
        String nonce_str = getNonceStr(20);
        // appId
        // 将通用参数设置进map中
        params.put("app_id", appId);
        params.put("nonce_str", nonce_str);
        params.put("time_stamp", time_stamp);
        return params;
    }

    /**
     * TreeMap生成鉴权信息
     *
     * @param appkey OCR 应用key
     * @param params 参数
     * @return 返回结果
     * @throws Exception
     */
    private static String generateAppSign(String appkey, TreeMap<String, String> params) throws Exception {
        Set<String> keySet = params.keySet();
        StringBuilder sb = new StringBuilder();
        for (String key : keySet) {
            String value = params.get(key);
            sb.append("&").append(key).append("=").append(URLEncoder.encode(value, "UTF-8"));
        }
        sb.deleteCharAt(0);
        sb.append("&app_key=").append(appkey);
        return MD5Util.MD5(sb.toString());
    }

    /**
     * 发送ocr请求
     *
     * @param url 请求解析对应类型图片的URL
     * @param params 参数
     * @return 返回结果
     */
    private static String request(String appkey, String url, TreeMap<String, String> params) {
        try {
            // 生成签名加入到参数列表中
            String sign = generateAppSign(appkey, params);
            params.put("sign", sign);

            Map<String, Object> paramsMap = new HashMap<>();
            for (String key : params.keySet()) {
                String value = params.get(key);
                paramsMap.put(key, value);
            }
            return RestTemplateUtil.post(url, null, paramsMap);
        } catch (Exception e) {
            logger.error("OCR图片识别, 发送识别请求异常, url={}, params={}", url, JSONObject.toJSONString(params), e);
            return null;
        }
    }

    /**
     * 获取图片数据流
     *
     * @param imgURL 图片地址
     * @return 返回结果
     */
    private static String getImgStr(String imgURL) {
        if (StringUtils.isEmpty(imgURL)) {
            return null;
        }
        ByteArrayOutputStream baos = null;
        try {
            URL url = new URL(imgURL);
            BufferedImage image = ImageIO.read(url);
            baos = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", baos);
            baos.flush();
            return new String(Base64.encodeBase64(baos.toByteArray()));
        } catch (Exception e) {
            logger.error("OCR图片识别 根据URL获取图片内容异常, imgURL={}", imgURL, e);
            return null;
        } finally {
            try {
                if (baos != null) {
                    baos.close();
                }
            } catch (Exception e) {
                logger.error("OCR图片识别, 根据URL获取图片内容, 关闭图片数据流异常, imgURL={}", imgURL, e);
            }
        }
    }

    // 获取图片

    /**
     * 获取图片数据流
     *
     * @param file 文件
     * @return 返回结果
     */
    private static String getImgStr(File file) {
        if (file == null) {
            return null;
        }
        InputStream in = null;
        try {
            byte[] data;
            in = new FileInputStream(file);
            data = new byte[in.available()];
            boolean flag = in.read(data) > 0;
            in.close();
            if (flag) {
                return new String(Base64.encodeBase64(data));
            }
            return null;
        } catch (Exception e) {
            logger.error("OCR图片识别, 根据文件获取图片内容异常", e);
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                logger.error("OCR图片识别, 根据文件获取图片内容, 关闭图片数据流异常", e);
            }
        }
    }
}
