package com.ITegg.generator;

import com.ITegg.model.MaintemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class MainGenerator {

    /**
     * 生成文件方法(静态 + 动态)
     *
     * @param model 数据模型
     */
    public static void doGenerate(Object model) throws IOException, TemplateException {
        // 获取整个项目的根目录
        String projectPath = System.getProperty("user.dir");
        // 获取路径父文件
        File parentFile = new File(projectPath).getParentFile();
        String input = new File(parentFile, "samples/acm-template").getAbsolutePath();
        String output = projectPath;

        // 生成静态文件
        StaticGenerator.copyFileByHutool(input, output);
        // 生成动态文件
        String inputDynamic = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String outputDynamic = projectPath + File.separator + "acm-template/src/com/ITegg/acm/MainTemplate.java";
        DynamicGenerator.doGenerate(inputDynamic, outputDynamic, model);
    }

    public static void main(String[] args) throws TemplateException, IOException {
        // 数据体
        MaintemplateConfig maintemplateConfig = new MaintemplateConfig();
        maintemplateConfig.setAuthor("IT蛋");
        maintemplateConfig.setLoop(false);
        maintemplateConfig.setOutputText("求和计算结果");

        doGenerate(maintemplateConfig);
    }

}
