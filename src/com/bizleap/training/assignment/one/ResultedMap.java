package com.bizleap.training.assignment.one;

import java.util.HashMap;
import java.util.Map;

public class ResultedMap {
    // Get Result Map by Loop
    public Map<Integer, Integer> getResultMapByLoop(int inputNumber) {
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        int result = 1;

        for(int i = 1 ; i <= inputNumber; ) {
            resultMap.put(i, result);
            result += ++i;
        }
        return resultMap;
    }

    // Get Result Map by Recursion
    // To call by user
    public Map<Integer, Integer> getResultMapByRecursion(int inputNumber) {
        Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
        return generateResultMap(inputNumber, resultMap);
    }

    // Generate result Map
    public Map<Integer, Integer> generateResultMap(int inputNumber, Map<Integer,Integer> resultMap) {
        if (inputNumber == 1) {
            resultMap.put(1,1);
        } else {
            resultMap.put(inputNumber, getSumResult(inputNumber));
            generateResultMap(inputNumber - 1, resultMap);
        }
        return resultMap;
    }

    // Generate total sum
    private int getSumResult(int input) {
        return input == 1 ? 1 : input + getSumResult(input - 1);
    }

    public static void main(String[] args) {
        System.out.println(new ResultedMap().getResultMapByRecursion(20));
    }
}
