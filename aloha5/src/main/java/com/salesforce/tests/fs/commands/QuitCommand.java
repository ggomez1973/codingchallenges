package com.salesforce.tests.fs.commands;

public final class QuitCommand implements Command {
    public static final String CMD = "quit";

    public QuitCommand() {
    }

    @Override
    public void run() {
        System.exit(0);
    }
}
