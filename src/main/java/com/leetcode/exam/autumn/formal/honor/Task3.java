package com.leetcode.exam.autumn.formal.honor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-20
 */
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<int[]> partyList = Arrays.stream(scanner.nextLine().split(" "))
                .map(item -> Arrays
                        .stream(item.substring(1, item.length() - 1).split(","))
                        .mapToInt(Integer::parseInt)
                        .toArray())
                .collect(Collectors.toList());
        scanner.close();
        partyList.sort((o1, o2) -> {
            int c = Integer.compare(o1[0], o2[0]);
            if (c == 0) {
                return Integer.compare(o1[1], o2[1]);
            }
            return c;
        });
        int idx = 0;
        LinkedHashMap<Integer, List<int[]>> map = new LinkedHashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(partyList.get(0));
        for (int i = 1; i < partyList.size(); i++) {
            int[] party = partyList.get(i);
            if (party[0] >= partyList.get(i - 1)[1]) {
                idx++;
            }
            if (!map.containsKey(idx)) {
                map.put(idx, new ArrayList<>());
            }
            map.get(idx).add(party);
        }
        List<int[]> resList = new ArrayList<>();
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {
            idx = entry.getKey();
            int[] process = process(entry.getValue());
            for (int i : process) {
                resList.add(entry.getValue().get(i));
            }
        }
        System.out.printf("count:%d\n", resList.size());
        for (int[] ints : resList) {
            System.out.printf("(%d,%d) ", ints[0], ints[1]);
        }
    }

    public static int[] process(List<int[]> list) {
        if (list.size() == 1) return new int[]{0};
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(i);
        }
        List<Integer> resList = new ArrayList<>(), theList;
        int maxCount = 0;
        while (!set.isEmpty()) {
            theList = new ArrayList<>();
            int i;
            for (i = 0; i < list.size(); i++) {
                if (set.contains(i)) break;
            }
            int preEnd = 0;
            for (int j = i; j < list.size(); j++) {
                int[] party = list.get(j);
                if (party[0] >= preEnd) {
                    theList.add(j);
                    preEnd = party[1];
                    set.remove(j);
                }
            }
            if (maxCount < theList.size()) {
                resList = theList;
            } else if (maxCount == theList.size() && list.get(resList.get(maxCount - 1))[1] == list.get(theList.get(maxCount - 1))[1]) {
                if (list.get(resList.get(0))[0] < list.get(theList.get(0))[0]) {
                    resList = theList;
                }
            }
            maxCount = Math.max(maxCount, theList.size());
        }
        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}
