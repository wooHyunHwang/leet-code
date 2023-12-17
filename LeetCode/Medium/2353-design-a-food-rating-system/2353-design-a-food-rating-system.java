class FoodRatings {

    Map<String, String> foodCuisinesName = new HashMap<>();
    Map<String, Map<String, Food>> foodList = new HashMap<>();
    Map<String, PriorityQueue<Food>> topRate = new HashMap<>();

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        // System.out.println("init");
        for (int i = 0; i < foods.length; ++i) {
            this.foodCuisinesName.put(foods[i], cuisines[i]);

            Food food = new Food(foods[i], cuisines[i], ratings[i]);
            Map<String, Food> list = this.foodList.containsKey(cuisines[i]) ? this.foodList.get(cuisines[i]) : new HashMap<>();
            list.put(foods[i], food);
            this.foodList.put(cuisines[i], list);

            PriorityQueue<Food> top = this.topRate.containsKey(cuisines[i]) ? this.topRate.get(cuisines[i]) : new PriorityQueue<>();
            top.add(food);
            this.topRate.put(cuisines[i], top);

            // System.out.print("[" + food.cuisine + "]" + food.foodName + " / " + food.rate);
            // System.out.println(" - " + top.peek().foodName);
        }

    }
    
    public void changeRating(String food, int newRating) {
        // System.out.println("changeRating");
        String cuisine = foodCuisinesName.get(food);
        Map<String, Food> list = foodList.get(cuisine);
        Food foodData = list.get(food);

        foodData = new Food(foodData.foodName, foodData.cuisine, newRating);

        list.put(food, foodData);
        this.foodList.put(cuisine, list);

        // System.out.print("[" + foodData.cuisine + "]" + foodData.foodName + " / " + foodData.rate);

        PriorityQueue<Food> top = this.topRate.containsKey(cuisine) ? this.topRate.get(cuisine) : new PriorityQueue<>();
        top.add(foodData);
        this.topRate.put(cuisine, top);

        // System.out.println(" - " + top.peek().foodName);
    }
    
    public String highestRated(String cuisine) {
        // System.out.println("highestRated");
        Food food = this.topRate.get(cuisine).peek();
        if (food.rate == foodList.get(cuisine).get(food.foodName).rate) {
            return food.foodName;
        } else {
            this.topRate.get(cuisine).poll();
            return this.highestRated(cuisine);
        }
    }

    public static class Food implements Comparable<Food> {
        public String foodName;
        public String cuisine;
        public int rate;

        public Food(String food, String cuisine, int rate) {
            this.foodName = food;
            this.cuisine = cuisine;
            this.rate = rate;
        }

        @Override
        public int compareTo(Food food) {

            if (this.rate < food.rate) return 1;
            else if (this.rate > food.rate) return -1;

            // 알파벳
            int i = 0;
            while(i < this.foodName.length() && i < food.foodName.length()) {
                if (this.foodName.charAt(i) > food.foodName.charAt(i)) {
                    return 1;
                }
                else if (this.foodName.charAt(i) < food.foodName.charAt(i)) {
                    return -1;
                }
                ++i;
            }
            return 0;
        }
    }

/*
    public static class FoodRate {
        public int topRate = 0;
        public Food food = null;

        public FoodRate() {}

        public void nextFood(Food food) {
            System.out.println("Food - " + food.foodName + " / " + food.rate);
            if (food.rate >= topRate) {
                this.topRate = food.rate;
                this.food = food;
            }
        }
    }
*/

}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */