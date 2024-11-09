package com.ITegg.generator;

import com.ITegg.model.MaintemplateConfig;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 生成动态文件
 */
public class DynamicGenerator {
    public static void main(String[] args) throws IOException, TemplateException {

        String projectPath = System.getProperty("user.dir");
        String input = projectPath + File.separator + "src/main/resources/templates/MainTemplate.java.ftl";
        String output = projectPath + File.separator + "MainTemplate.java";

        // 数据体
        MaintemplateConfig maintemplateConfig = new MaintemplateConfig();
        maintemplateConfig.setAuthor("IT蛋");
        maintemplateConfig.setLoop(false);
        maintemplateConfig.setOutputText("求和计算结果");

        doGenerate(input, output, maintemplateConfig);


    }

    /**
     * 生成文件方法
     *
     * @param inputPath 模板文件输入路径
     * @param outputPath 输出路径
     * @param model 数据模型
     */
    public static void doGenerate(String inputPath, String outputPath, Object model) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);

        // 标记指定文件的路径
        File templateDir = new File(inputPath).getParentFile();
        configuration.setDirectoryForTemplateLoading(templateDir);
        // 文件字符集
        configuration.setDefaultEncoding("utf-8");
        // 指定模板
        String templateName = new File(inputPath).getName();
        Template template = configuration.getTemplate(templateName);

        // 生成 outputPath = "MainTemplate.java"
        Writer out = new FileWriter(outputPath);
        template.process(model, out);

        //关闭流
        out.close();
    }

}
