package day7.solutions;

import java.util.List;

import day7.solutions.filesystem.FileSystem;
import day7.solutions.filesystem.operations.DirectoryOperation;
import shared.InputReader;

public class Runner {

    public static int run(final String path, final DirectoryOperation operation) {
        
        final List<String> input = new InputReader().readInputFile(path);
        
        // Build (or 'rehydrate') the File System from logs
        final FileSystem fs = new FileSystem();
        final FileSystemHydrator hydrator = new FileSystemHydrator(fs);
        input.forEach(l -> hydrator.process(l));
        
        // Operate on the file system
        fs.cd(FileSystem.ROOT);
        return operation.operate(fs);
    }
}
