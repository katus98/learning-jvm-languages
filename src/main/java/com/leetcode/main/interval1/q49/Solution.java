package com.leetcode.main.interval1.q49;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @author SUN Katus
 * @version 1.0, 2022-05-28
 */
public class Solution {
    /**
     * 异构词排序后字符串是一样的 + 哈希
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = String.valueOf(chars);
            if (map.containsKey(sortStr)) {
                resultList.get(map.get(sortStr)).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                resultList.add(list);
                map.put(sortStr, resultList.size() - 1);
            }
        }
        return resultList;
    }
}
