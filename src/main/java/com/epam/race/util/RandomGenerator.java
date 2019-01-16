package com.epam.race.util;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerator {

    public static final int RACE_SIZE = 4;

    public List<Integer> randomNumbers(){
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while (set.size() < RACE_SIZE){
            int a = (int) (Math.random() * RACE_SIZE);
            set.add(a);
        }
        return set.stream().collect(Collectors.toList());
    }
}
