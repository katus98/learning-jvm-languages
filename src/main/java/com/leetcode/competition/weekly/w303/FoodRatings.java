package com.leetcode.competition.weekly.w303;

import java.util.*;

/**
 * 设计食物评分系统
 *
 * @author SUN Katus
 * @version 1.0, 2022-07-24
 */
public class FoodRatings {
    private final Map<String, Food> nameMap;
    private final Map<String, TreeSet<Food>> beatMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        this.nameMap = new HashMap<>();
        this.beatMap = new HashMap<>();
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            nameMap.put(foods[i], food);
            TreeSet<Food> treeSet = beatMap.getOrDefault(cuisines[i], new TreeSet<>((o1, o2) -> {
                int c = -o1.getRating().compareTo(o2.getRating());
                if (c == 0) {
                    return o1.getName().compareTo(o2.getName());
                } else return c;
            }));
            treeSet.add(food);
            beatMap.put(cuisines[i], treeSet);
        }
    }

    public void changeRating(String food, int newRating) {
        Food foodObj = nameMap.get(food);
        TreeSet<Food> treeSet = beatMap.get(foodObj.getCuisine());
        treeSet.remove(foodObj);
        foodObj.setRating(newRating);
        treeSet.add(foodObj);
    }

    public String highestRated(String cuisine) {
        TreeSet<Food> treeSet = beatMap.get(cuisine);
        return treeSet.first().getName();
    }

    public static class Food {
        private final String name;
        private final String cuisine;
        private Integer rating;

        public Food(String name, String cuisine, Integer rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        public String getName() {
            return name;
        }

        public String getCuisine() {
            return cuisine;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Food food = (Food) o;
            return Objects.equals(name, food.name) && Objects.equals(rating, food.rating);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, rating);
        }
    }

    public static void main(String[] args) {
        FoodRatings foodRatings = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        System.out.println(foodRatings.highestRated("korean"));
        // "kimchi" 是分数最高的韩式料理，评分为 9 。
        System.out.println(foodRatings.highestRated("japanese"));
        // "ramen" 是分数最高的日式料理，评分为 14 。
        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
        System.out.println(foodRatings.highestRated("japanese"));
        // "sushi" 是分数最高的日式料理，评分为 16 。
        foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
        System.out.println(foodRatings.highestRated("japanese"));
    }
}
