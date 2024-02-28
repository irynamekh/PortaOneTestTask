package org.example;

import org.example.filedata.FileReader;
import org.example.filedata.FileReaderImpl;
import org.example.service.TaskService;
import org.example.service.TaskServiceImpl;

import java.io.File;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Main {
    public static final String FROM_FILE_NAME = "src/main/resources/numbers.txt";

    public static void main(String[] args) {
        LocalTime start = LocalTime.now();
        FileReader fileReader = new FileReaderImpl();
        TaskService taskService = new TaskServiceImpl();
        List<Long> fileData = fileReader.readFromFile(new File(FROM_FILE_NAME));

        System.out.println(taskService.getMax(fileData));
        System.out.println(taskService.getMin(fileData));
        System.out.println(taskService.getMedian(fileData));
        System.out.println(taskService.getAverage(fileData));
        System.out.println(taskService.getSequenceASC(fileData));
        System.out.println(taskService.getSequenceDESC(fileData));

        long workTime = ChronoUnit.SECONDS.between(start, LocalTime.now());
        System.out.println("The execution of the task lasted " + workTime + " seconds");
    }
}