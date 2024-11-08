


import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FreeMarkerTest {

    public static void main(String[] args) throws IOException, TemplateException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);

        configuration.setDirectoryForTemplateLoading(new File("src/main/resources/templates"));

        configuration.setDefaultEncoding("utf-8");

        Template template = configuration.getTemplate("myweb.html.ftl");
        configuration.setNumberFormat("0.####");

        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("currentYear", 2024);
        List<Map<String, Object>> menuItems = new ArrayList<>();
        Map<String, Object> menuItem1 = new HashMap<>();
        menuItem1.put("url", "www.baidu.com");
        menuItem1.put("label", "快乐标签label");
        Map<String, Object> menuItem2 = new HashMap<>();
        menuItem2.put("url", "www.baidu3.com");
        menuItem2.put("label", "快乐标签label3");
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        dataModel.put("menuItems", menuItems);

        Writer out = new FileWriter("myweb.html");

        template.process(dataModel, out);

        out.close();
    }

}
