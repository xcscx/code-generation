package com.ITegg.model;

import lombok.Data;

@Data
public class MaintemplateConfig {

    /**
     * 循环配置
     */
    private boolean loop;

    /**
     * 作者注释
     */
    private String author;

    /**
     * 输出信息
     */
    private String outputText;

}
