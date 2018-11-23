package com.wind.utils;

import net.coobird.thumbnailator.Thumbnails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片工具
 * 
 * @author qianchun 2018/10/12
 */
public class ImageUtil {
    private static Logger logger = LoggerFactory.getLogger(ImageUtil.class);

    private static final int FILE_SIZE_1M = 1024 * 1024;

    /**
     * 图片压缩
     * 
     * @param src 原始图片
     * @param dest 压缩后图片
     * @param maxFileSize 压缩图片最大长度
     */
    private static void compressedImageLoop(File src, File dest, int maxFileSize, float outputQuality) {
        String srcPath = null;
        String destPath = null;
        try {
            if (src == null || !src.exists()) {
                logger.error("图片压缩, 源图片不存在");
                return;
            }
            if (dest == null) {
                logger.error("图片压缩, 目标文件图片不存在");
                return;
            }
            srcPath = src.getPath();
            destPath = dest.getPath();
            clearInfoForFile(dest);
            if (src.length() <= maxFileSize) {
                Files.copy(Paths.get(src.getAbsolutePath()), Paths.get(dest.getAbsolutePath()),
                        StandardCopyOption.REPLACE_EXISTING);
                return;
            }
            Thumbnails.of(src).scale(1f).outputQuality(outputQuality).toFile(dest);
            logger.info("图片压缩 src.size={}, dest.size={}", src.length(), dest.length());
            if (src.length() == dest.length()) {
                return;
            }
            if (dest.length() > maxFileSize) {
                Files.copy(Paths.get(dest.getAbsolutePath()), Paths.get(src.getAbsolutePath()),
                        StandardCopyOption.REPLACE_EXISTING);
                compressedImageLoop(src, dest, maxFileSize, outputQuality - 0.1f);
            }
        } catch (IOException e) {
            logger.error("图片压缩失败 srcPath={}, destPath={}", srcPath, destPath, e);
        }
    }

    /**
     * 压缩图片
     * 
     * @param src 待压缩文件
     * @param maxFileSize 压缩后最大尺寸
     */
    public static void compressedImage(File src, int maxFileSize) {
        File dest = null;
        String srcPath = "";
        try {
            if (src == null || !src.exists()) {
                return;
            }
            String destFileName = src.getParent() + "/" + src.getName().substring(0, src.getName().lastIndexOf("."))
                    + "_tmp" + src.getName().substring(src.getName().lastIndexOf("."));
            dest = new File(destFileName);
            if (src.length() <= maxFileSize) {
                Files.copy(Paths.get(src.getAbsolutePath()), Paths.get(dest.getAbsolutePath()),
                        StandardCopyOption.REPLACE_EXISTING);
            }
            float outputQuality;
            if (src.length() > 10 * FILE_SIZE_1M) {
                outputQuality = 0.2f;
            } else if (src.length() > 5 * FILE_SIZE_1M) {
                outputQuality = 0.25f;
            } else {
                outputQuality = 0.3f;
            }
            compressedImageLoop(src, dest, maxFileSize, outputQuality);
            Files.copy(Paths.get(dest.getAbsolutePath()), Paths.get(src.getAbsolutePath()),
                    StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            logger.error("图片压缩失败 srcPath={}", srcPath, e);
        } finally {
            if (dest != null && dest.exists() && dest.delete()) {
                logger.error("图片压缩, 中间过度文档删除成功 srcPath={}", srcPath);
            }
        }
    }

    /**
     * 清空文件内容
     * 
     * @param file 待清空内容文件
     */
    private static void clearInfoForFile(File file) {
        if (file == null) {
            return;
        }
        try (FileWriter fileWriter = new FileWriter(file)) {
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            logger.error("图片压缩, 清空文件内容异常", e);
        }
    }
}