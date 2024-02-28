package org.example.filedata;

import java.io.File;
import java.util.List;

public interface FileReader {
    List<Long> readFromFile(File file);
}
