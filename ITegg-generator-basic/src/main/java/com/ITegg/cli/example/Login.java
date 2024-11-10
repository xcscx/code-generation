package com.ITegg.cli.example;

import picocli.CommandLine;

import java.util.concurrent.Callable;

public class Login implements Callable<Integer> {

    @CommandLine.Option(names = {"-u", "--user"}, description = "User name")
    String user;

    @CommandLine.Option(names = {"-p", "--password"}, description = "PassWord", interactive = true)
    String password;

    public Integer call() throws Exception {
        System.out.println("user = " + user);
        System.out.println("password = " + password);
        return 0;
    }

    public static void main(String[] args) {
        new CommandLine(new Login()).execute("-u", "user123", "-p");
    }

}
