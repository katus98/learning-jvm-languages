package com.leetcode.exam.autumn.formal.honor;

import java.util.*;

/**
 * @author SUN Katus
 * @version 1.0, 2022-08-20
 */
public class Task2 {
    public static void main(String[] args) {
        int maxTime = 0;
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Product> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Product(array));
            maxTime = Math.max(maxTime, array[3]);
        }
        scanner.close();
        list.sort((o1, o2) -> {
            int c = Integer.compare(o1.getStart(), o2.getStart());
            if (c != 0) {
                return c;
            } else {
                return Integer.compare(o1.getEnd(), o2.getEnd());
            }
        });
        int idx = 0;
        LinkedHashMap<Integer, List<Product>> map = new LinkedHashMap<>();
        map.put(0, new ArrayList<>());
        map.get(0).add(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            Product party = list.get(i);
            if (party.start >= list.get(i - 1).end) {
                idx++;
            }
            if (!map.containsKey(idx)) {
                map.put(idx, new ArrayList<>());
            }
            map.get(idx).add(party);
        }
        int res = 0;
        for (Map.Entry<Integer, List<Product>> entry : map.entrySet()) {
            res += process(entry.getValue());
        }
        System.out.println(res);
    }

    public static int process(List<Product> list) {
        if (list.size() == 1) return list.get(0).price;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(i);
        }
        int maxPrice = 0, price;
        while (!set.isEmpty()) {
            price = 0;
            int i;
            for (i = 0; i < list.size(); i++) {
                if (set.contains(i)) break;
            }
            int preEnd = 0;
            for (int j = i; j < list.size(); j++) {
                Product party = list.get(j);
                if (party.start >= preEnd) {
                    preEnd = party.end;
                    set.remove(j);
                    price += party.price;
                }
            }
            maxPrice = Math.max(maxPrice, price);
        }
        return maxPrice;
    }

    public static class Product {
        int id;
        int price;
        int start, end;

        public Product(int[] array) {
            this.id = array[0];
            this.price = array[1];
            this.start = array[2];
            this.end = array[3];
        }

        public int getId() {
            return id;
        }

        public int getPrice() {
            return price;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }
}
