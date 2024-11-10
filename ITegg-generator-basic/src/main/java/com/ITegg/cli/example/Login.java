package com.ITegg.cli.example;

import picocli.CommandLine;

import java.util.*;
import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {

    @CommandLine.Option(names = {"-u", "--user"}, description = "User name")
    String user;

    /**
     * arity 参数可以使得参数可选填写
     */
    @CommandLine.Option(names = {"-p", "--password"}, description = "PassWord", arity = "0..1", interactive = true)
    String password;

    @CommandLine.Option(names = {"-cp", "--checkPassword"}, description = "Check Password", arity = "0..1", interactive = true)
    String checkPassword;

    public Integer call() throws Exception {
        System.out.println("user = " + user);
        System.out.println("password = " + password);
        System.out.println("checkPassword = " + checkPassword);
        if(!password.equals(checkPassword)) {
            System.out.println("password ERROR!!!");
        }
        return 0;
    }

    public static String[] needParam() {
        return new String[]{"-p", "-cp"};
    }

    public static String[] combineArraysAndList(String[] a, List<String> b) {
        // 创建一个新的数组，长度是 a 和 b 的长度之和
        String[] result = Arrays.copyOf(a, a.length + b.size());

        // 将 b 中的元素添加到 result 数组的末尾
        for (int i = 0; i < b.size(); i++) {
            result[a.length + i] = b.get(i);
        }

        return result;
    }

    public static String[] CheckFun(String[] strs) {
        Set<String> argSet = new HashSet<>(Arrays.asList(strs));

        String[] need = needParam();
        List<String> resultList = new ArrayList<>();

        for(String value : need) {
            if(!argSet.contains(value))
                resultList.add(value);
        }

        // 缺失必要命令，补充
        if(resultList.size() > 0) {
            return combineArraysAndList(strs, resultList);
        }
        //无缺失
        return strs;
    }

    public static void main(String[] args) {
        // 处理并补充命令行参数
        String[] finalArgs = CheckFun(new String[]{"-u", "user123", "-p", "12354"});
        sout(finalArgs);
        // 使用 CommandLine 执行命令并解析命令行参数
        new CommandLine(new Login()).execute(finalArgs);

//        new CommandLine(new Login()).execute(CheckFun(new String[]{"-u", "user123", "-p", "12354"}));
    }

    public static void sout(String[] list) {
        System.out.println("----------");
        for(String mid : list) {
            System.out.println(mid);
        }
        System.out.println("----------");
    }

}
