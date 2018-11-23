package com.wind.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.io.File;

/**
 * TencentAiOCRUtil Tester.
 *
 * @author <Authors name>
 * @since
 *
 *        <pre>
 * 十一月 23, 2018
 *        </pre>
 *
 * @version 1.0
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({ TencentAiOCRUtil.class })
@PowerMockIgnore({ "javax.management.*", "javax.security.*", "javax.net.ssl.*" })
public class TencentAiOCRUtilTest {


    private String appKey = "5QzVU7A77dLodX1h";

    private String appId = "2108942989";
    @Before
    public void before() throws Exception {
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: ocrCommon(String appId, String appkey, File file)
     */
    @Test
    public void testOcrCommon() throws Exception {
        File file = new File("/Users/qianchun/easyAuditReport.jpg");
        PowerMockito.mockStatic(TencentAiOCRUtil.class);
        PowerMockito.when(TencentAiOCRUtil.ocrCommon(appId, appKey, file)).thenReturn("通用图片测试");
        String result = TencentAiOCRUtil.ocrCommon(appId, appKey, file);
        System.out.println(result);

    }
    /**
     * Method: ocrBusinessLicence(String appId, String appkey, File file)
     */
    @Test
    public void testOcrBusinessLicence() throws Exception {
        File file = new File("/Users/qianchun/yyzz.jpeg");
        PowerMockito.mockStatic(TencentAiOCRUtil.class);
        PowerMockito.when(TencentAiOCRUtil.ocrBusinessLicence(appId, appKey, file)).thenReturn("营业执照测试");
        String result = TencentAiOCRUtil.ocrBusinessLicence(appId, appKey, file);
        System.out.println(result);

    }

    /**
     * Method: ocrIdCard(String appId, String appkey, int cardType, File file)
     */
    @Test
    public void testOcrIdCard() throws Exception {
        int type = 0;
        File file = new File("/Users/qianchun/idCardFront.jpg");
        PowerMockito.mockStatic(TencentAiOCRUtil.class);
        PowerMockito.when(TencentAiOCRUtil.ocrIdCard(appId, appKey, type, file)).thenReturn("身份证正面测试");
        String result = TencentAiOCRUtil.ocrIdCard(appId, appKey, type, file);
        System.out.println(result);
    }

    /**
     * Method: request(String appkey, String url, TreeMap<String, String> params)
     */
    @Test
    public void testRequest() throws Exception {
        String name = "王南";
        String format = "Hi,%s";
        PowerMockito.mockStatic(String.class);
        PowerMockito.when(String.format(format, name)).thenReturn("测试");
        String str = String.format(format, name);
        System.out.println(str);
    }
}
