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
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);

        // 标记路径
        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));
        // 文件字符集
        configuration.setDefaultEncoding("utf-8");
        // 指定模板
        Template template = configuration.getTemplate("MainTemplate.java.ftl");

        // 数据体
        MaintemplateConfig maintemplateConfig = new MaintemplateConfig();
        maintemplateConfig.setAuthor("IT蛋");
        maintemplateConfig.setLoop(false);
        maintemplateConfig.setOutputText("求和计算结果");

        // 生成
        Writer out = new FileWriter("MainTemplate.java");
        template.process(maintemplateConfig, out);

        //关闭流
        out.close();
    }

}
