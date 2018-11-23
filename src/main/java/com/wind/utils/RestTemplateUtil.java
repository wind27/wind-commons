package com.wind.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Map;

/**
 * RestTemplateConfig
 *
 * @author qianchun 2018/11/2
 **/
public class RestTemplateUtil {
    private static Logger logger = LoggerFactory.getLogger(RestTemplateUtil.class);

    private static RestTemplate restTemplate;
    static {
        restTemplate = getInstance();
    }

    private static synchronized RestTemplate getInstance() {
        if (restTemplate == null) {
            SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
            requestFactory.setConnectTimeout(30000);// 设置超时
            requestFactory.setReadTimeout(30000);
            restTemplate = new RestTemplate(requestFactory);
            restTemplate.getMessageConverters().add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        }
        return restTemplate;
    }

    /**
     * get
     *
     * @param url 请求URL
     * @param params 参数
     * @return 返回结果
     */
    public static String get(String url, Map<String, Object> params) {
        try {
            MultiValueMap<String, Object> paramsMap = parseParam(params);
            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class, paramsMap);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
            return null;
        } catch (Exception e) {
            logger.error("RestTemplate get 异常 url={}, param={}", url, params, e);
            return null;
        }
    }

    /**
     * post
     *
     * @param url 请求URL
     * @param headersMap header
     * @param params 参数
     * @return 返回结果
     */
    public static String post(String url, Map<String, Object> headersMap, Map<String, Object> params) {
        try {
            MultiValueMap<String, Object> paramsMap = parseParam(params);
            HttpHeaders headers = parseHeader(headersMap, MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity httpEntity = new HttpEntity<>(paramsMap, headers);
            ResponseEntity<String> response = restTemplate.postForEntity(url, httpEntity, String.class, paramsMap);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
            return null;
        } catch (Exception e) {
            logger.error("RestTemplate post 异常 url={}, header={}, param={}", url, headersMap, params, e);
            return null;
        }
    }

    /**
     * put
     *
     * @param url 请求URL
     * @param headersMap header
     * @param params 参数
     * @return 返回结果
     */
    public static boolean put(String url, Map<String, Object> headersMap, Map<String, Object> params) {
        try {
            MultiValueMap<String, Object> paramsMap = parseParam(params);
            HttpHeaders headers = parseHeader(headersMap, MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity httpEntity = new HttpEntity<>(paramsMap, headers);
            restTemplate.put(url, httpEntity, paramsMap);
            return true;
        } catch (Exception e) {
            logger.error("RestTemplate put 异常 url={}, headersMap={}, param={}", url, headersMap, params, e);
            return false;
        }
    }

    /**
     * delete
     *
     * @param url 请求URL
     * @param params 参数
     * @return 返回结果
     */
    public static boolean delete(String url, Map<String, Object> params) {
        try {
            restTemplate.delete(url, params);
            return true;
        } catch (Exception e) {
            logger.error("RestTemplate delete 异常 url={}, param={}", url, params, e);
            return false;
        }
    }

    /**
     * 请求, 返回请求body
     *
     * @param url 请求URL
     * @param method 方法类型
     * @param mediaType contentType
     * @param headersMap 请求header
     * @param params 参数
     * @return 返回结果
     */
    public static String request(String url, HttpMethod method, MediaType mediaType, Map<String, Object> headersMap,
                                 Map<String, Object> params) {
        try {
            ResponseEntity<String> response = request(url, method, parseHeader(headersMap, mediaType), params);
            if (response.getStatusCode() == HttpStatus.OK) {
                return response.getBody();
            }
            return null;
        } catch (Exception e) {
            logger.error("RestTemplate 异常 url={}, method={}, mediaType={}, header={}, param={}", url, method, mediaType,
                    headersMap, params, e);
            return null;
        }
    }

    /**
     * 请求返回 response
     *
     * @param url 请求URL
     * @param mediaType mediaType
     * @param params 参数
     * @param headersMap header
     * @return 返回结果
     */
    public static ResponseEntity<String> requestToResponse(String url, HttpMethod method, MediaType mediaType,
            Map<String, Object> headersMap, Map<String, Object> params) {
        try {
            return request(url, method, parseHeader(headersMap, mediaType), params);
        } catch (Exception e) {
            logger.error("RestTemplate 异常 url={}, method={}, mediaType={}, header={}, param={}", url, method, mediaType,
                    headersMap, params, e);
            return null;
        }
    }

    /**
     * 封装header
     *
     * @param headersMap header参数
     * @param mediaType contentType
     * @return 返回结果
     */
    private static HttpHeaders parseHeader(Map<String, Object> headersMap, MediaType mediaType) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setAcceptCharset(Collections.singletonList(Charset.forName("UTF-8")));
        if (mediaType != null) {
            headers.setContentType(mediaType);
        }
        if (headersMap != null && CollectionUtils.isNotEmpty(headersMap.keySet())) {
            headersMap.keySet().forEach(key -> {
                if (StringUtils.isNotEmpty(key)) {
                    headers.add(key, headersMap.get(key).toString());
                }
            });
        }
        return headers;
    }

    /**
     * 封装header
     *
     * @param params 参数
     * @return 返回结果
     */
    private static MultiValueMap<String, Object> parseParam(Map<String, Object> params) {
        MultiValueMap<String, Object> paramsMap = new LinkedMultiValueMap<>();
        if(params != null) {
            params.keySet().forEach(key -> {
                Object value = params.get(key);
                paramsMap.add(key, value);
            });
        }
        return paramsMap;
    }

    /**
     * restTemplate 请求
     *
     * @param url 请求URL
     * @param method 方法类型
     * @param headers 请求header
     * @param params 参数
     * @return 返回结果
     */
    private static ResponseEntity<String> request(String url, HttpMethod method, HttpHeaders headers,
                                                  Map<String, Object> params) {
        if (method == HttpMethod.GET && params != null) {
            return restTemplate.exchange(url, method, new HttpEntity<>(headers), String.class, params);
        } else if (method == HttpMethod.GET && params == null) {
            return restTemplate.exchange(url, method, new HttpEntity<>(headers), String.class);
        } else if (method == HttpMethod.PUT) {
            return restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<>(params, headers), String.class);
        } else if (method == HttpMethod.POST) {
            return restTemplate.exchange(url, method, new HttpEntity<>(params, headers), String.class, params);
        } else {
            return restTemplate.exchange(url, method, new HttpEntity<>(null, headers), String.class);
        }
    }
}
