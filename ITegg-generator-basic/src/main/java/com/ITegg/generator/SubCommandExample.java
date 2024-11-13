package com.ITegg.generator;

import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.junit.jupiter.api.Assertions.assertEquals;

@CommandLine.Command(name = "main", mixinStandardHelpOptions = true)
public class SubCommandExample implements Runnable {

    @Override
    public void run() {
        System.out.println("执行主命令");
    }

    @CommandLine.Command(name = "add", description = "增加", mixinStandardHelpOptions = true)
    static class AddCommand implements Runnable {
        public void run() {
            System.out.println("执行增加命令");
        }
    }

    @CommandLine.Command(name = "delete", description = "删除", mixinStandardHelpOptions = true)
    static class DeleteCommand implements Runnable {
        public void run() {
            System.out.println("执行删除命令");
        }
    }

    @CommandLine.Command(name = "query", description = "查询", mixinStandardHelpOptions = true)
    static class QueryCommand implements Runnable {
        public void run() {
            System.out.println("执行查询命令");
        }
    }

    public static void main(String[] args) {
        // 执行主命令
        String[] myArgs = new String[]{};
        // 查看主命令的帮助手册
//         String[] myArgs = new String[]{"--help"};
        // 查看增加命令
//         String[] myArgs = new String[]{"add"};
        // 查看增加命令的帮助手册
//         String[] myArgs = new String[]{"add", "--help"};
        // 查看不存在的命令，会报错
//         String[] myArgs = new String[]{"update"};
        int exitCode = new CommandLine(new SubCommandExample())
                .addSubcommand(new AddCommand())
                .addSubcommand(new DeleteCommand())
                .addSubcommand(new QueryCommand())
                .execute(myArgs);
        System.exit(exitCode);
    }

}

class CommandLineTest {
    // 创建命令行对象
    CommandLine commandLine = new CommandLine(new SubCommandExample())
            .addSubcommand(new SubCommandExample.AddCommand())
            .addSubcommand(new SubCommandExample.DeleteCommand())
            .addSubcommand(new SubCommandExample.QueryCommand());

    // 测试主命令
    @Test
    public void testMainCommand() {
        String[] args = new String[] {};
        int exitCode = commandLine.execute(args);
        assertEquals(0, exitCode);
    }

    // 测试帮助命令
    @Test
    public void testHelpCommand() {
        String[] args = new String[] {"--help"};
        int exitCode = commandLine.execute(args);
        assertEquals(0, exitCode);
    }

    // 测试增加子命令
    @Test
    public void testAddSubCommand() {
        String[] args = new String[] {"add"};
        int exitCode = commandLine.execute(args);
        assertEquals(0, exitCode);
    }


    // 测试增加帮助子命令
    @Test
    public void testAddHelpSubCommand() {
        String[] args = new String[] {"add", "--help"};
        int exitCode = commandLine.execute(args);
        assertEquals(0, exitCode);
    }

}