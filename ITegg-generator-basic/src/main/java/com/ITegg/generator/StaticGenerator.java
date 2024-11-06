package com.ITegg.generator;

import cn.hutool.core.io.FileUtil;

import java.io.File;

public class StaticGenerator {

    public static void copyFileByHutool(String inputPath, String outputPath) {
        FileUtil.copy(inputPath, outputPath, false);
    }

    public static void main(String[] args) {
        // 获取整个项目的根目录
        String projectPath = System.getProperty("user.dir");
        File parentFile = new File(projectPath).getParentFile();

        String inputPath = new File(parentFile, "samples/acm-template").getAbsolutePath();
        String outputPath = projectPath;
        copyFileByHutool(inputPath, outputPath);

        System.out.println(projectPath);
    }

}
