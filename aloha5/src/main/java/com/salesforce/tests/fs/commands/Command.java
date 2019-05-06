package com.salesforce.tests.fs.commands;

import com.salesforce.tests.fs.cache.CommandManager;

public interface Command {
    void run(CommandManager manger);
}
