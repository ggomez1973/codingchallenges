package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.cache.CommandManager;

public final class QuitCommand implements Command {
    public static final String CMD = "quit";

    public QuitCommand() {
    }

    @Override
    public void run(CommandManager manager) {
        System.exit(0);
    }
}
