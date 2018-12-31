package com.epam.race.util;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class RandomGenerator {

    public List<Integer> randomNumbers(){
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        while (set.size() < 4){
            int a = (int) (Math.random() * 4);
            set.add(a);
        }
        return set.stream().collect(Collectors.toList());
    }
}
