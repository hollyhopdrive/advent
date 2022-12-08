package day07.solutions;

import day07.solutions.filesystem.FileSystem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * A funky piece of code that restores a FileSystem from previous logs
 */
@RequiredArgsConstructor
public class FileSystemHydrator {

    private static final String COMMAND_PREFIX = "$";
    private static final String CD = "cd";
    private static final String DIR = "dir";
    
    @Getter
    private final FileSystem fs;

    public void process(final String line) {
      if(line.startsWith(COMMAND_PREFIX)) {
          final String command = line.replace(COMMAND_PREFIX, "").strip();
          if(command.startsWith(CD)) {
              handleCd(command);
          }
      } else {
          // If it's not a command, then it is output from the previous ls command
          handleLsResponseLine(line);
      }
    }
    
    private void handleCd(final String line) {
        final String name = line.replaceAll(CD, "").strip();;
        if(!name.equals(FileSystem.UP)) {
            if(!fs.exists(name)) {
                fs.mkdir(name);
            }
        }
        fs.cd(name);            
    }
    
    private void handleLsResponseLine(final String line) {
        String[] lsParts = line.split(" ");
        if(lsParts[0].equals(DIR)) {
            handleLsResponseDir(lsParts[1]);
        } else {
            handleLsResponseFile(Integer.parseInt(lsParts[0]), lsParts[1]);
        }
    }
    
    private void handleLsResponseDir(final String name) {
        fs.mkdir(name);
    }
    
    private void handleLsResponseFile(final int size, final String name) {
        fs.create(name, size);
    }
}
