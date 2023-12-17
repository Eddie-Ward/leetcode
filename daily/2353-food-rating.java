package daily;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class FoodRatings {

    private HashMap<String, PriorityQueue<Food>> cuisinesHeap;
    private HashMap<String, Food> foodMap;
    private FoodComparator foodComparator;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisinesHeap = new HashMap<>();
        foodMap = new HashMap<>();
        foodComparator = new FoodComparator();

        for (int i = 0; i < foods.length; ++i) {
            Food curFood = new Food(foods[i], cuisines[i], ratings[i]);
            foodMap.put(foods[i], curFood);

            cuisinesHeap.putIfAbsent(cuisines[i], new PriorityQueue<>(foodComparator));
            PriorityQueue<Food> curCuisine = cuisinesHeap.get(cuisines[i]);
            curCuisine.add(curFood);

        }
    }

    public void changeRating(String food, int newRating) {
        Food curFood = foodMap.get(food);
        String curCuisine = curFood.cuisine;

        PriorityQueue<Food> curCuisineHeap = cuisinesHeap.get(curCuisine);
        curCuisineHeap.remove(curFood);
        curFood.rating = newRating;
        curCuisineHeap.add(curFood);
    }

    public String highestRated(String cuisine) {
        return cuisinesHeap.get(cuisine).peek().name;
    }

    private class Food {
        int rating;
        String name;
        String cuisine;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }

    private class FoodComparator implements Comparator<Food> {
        public int compare(Food a, Food b) {
            if (a.rating == b.rating) {
                return a.name.compareTo(b.name);
            } else {
                return b.rating - a.rating;
            }
        }
    }
}
