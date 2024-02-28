package org.example.service;

import org.example.exception.ResultNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    @Override
    public long getMax(List<Long> numbers) {
        return numbers.stream()
                .mapToLong(Long::longValue)
                .max()
                .orElseThrow(() ->
                        new ResultNotFoundException("Can't find the maximum number"));
    }

    @Override
    public long getMin(List<Long> numbers) {
        return numbers.stream()
                .mapToLong(Long::longValue)
                .min()
                .orElseThrow(() ->
                        new ResultNotFoundException("Can't find the minimum number"));
    }

    @Override
    public long getMedian(List<Long> numbers) {
        List<Long> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        int size = sortedNumbers.size();

        if (size % 2 == 0) {
            long mid1 = sortedNumbers.get(size / 2 - 1);
            long mid2 = sortedNumbers.get(size / 2);
            return (mid1 + mid2) / 2;
        } else {
            return sortedNumbers.get(size / 2);
        }
    }

    @Override
    public double getAverage(List<Long> numbers) {
        return numbers.stream()
                .mapToLong(Long::longValue)
                .average()
                .orElseThrow(() ->
                        new ResultNotFoundException("Can't find the average number"));
    }

    @Override
    public List<Long> getSequenceASC(List<Long> numbers) {
        int endIndex = 0;
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) > numbers.get(i - 1)) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    endIndex = i;
                }
            } else {
                currentLength = 1;
            }
        }
        List<Long> largestSequence = new ArrayList<>();
        for (int i = endIndex - maxLength + 1; i <= endIndex; i++) {
            largestSequence.add(numbers.get(i));
        }

        return largestSequence;
    }

    @Override
    public List<Long> getSequenceDESC(List<Long> numbers) {
        int endIndex = 0;
        int maxLength = 1;
        int currentLength = 1;
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) < numbers.get(i - 1)) {
                currentLength++;
                if (currentLength > maxLength) {
                    maxLength = currentLength;
                    endIndex = i;
                }
            } else {
                currentLength = 1;
            }
        }
        List<Long> largestSequence = new ArrayList<>();
        for (int i = endIndex - maxLength + 1; i <= endIndex; i++) {
            largestSequence.add(numbers.get(i));
        }

        return largestSequence;
    }
}
