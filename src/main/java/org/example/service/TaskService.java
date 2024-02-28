package org.example.service;

import java.util.List;

public interface TaskService {
    long getMax(List<Long> numbers);
    long getMin(List<Long> numbers);
    long getMedian(List<Long> numbers);
    double getAverage(List<Long> numbers);
    List<Long> getSequenceASC(List<Long> numbers);
    List<Long> getSequenceDESC(List<Long> numbers);
}
