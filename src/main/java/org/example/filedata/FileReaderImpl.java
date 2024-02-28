package org.example.filedata;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<Long> readFromFile(File file) {
        List<Long> numbers = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(
                new java.io.FileReader(file))) {
            String fromText = bufferedReader.readLine();
            while (fromText != null) {
                Long number = Long.parseLong(fromText);
                numbers.add(number);
                fromText = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file " + file, e);
        }
        return numbers;
    }
}
