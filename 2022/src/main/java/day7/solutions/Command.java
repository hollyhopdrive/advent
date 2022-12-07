package day7.solutions;

import day7.solutions.filesystem.FileSystem;

public interface Command {

    FileSystem execute(FileSystem fs);
}
