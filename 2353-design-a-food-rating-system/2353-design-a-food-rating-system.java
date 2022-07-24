class FoodRatings {
    
    class Food {
        String name;
        String cuisine;
        int rating;
        Food (String name, String cuisine , int rating){
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }
    }
    
    Map<String,PriorityQueue<Food>> cuisineFoodMap;
    Map<String,Food> foodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        cuisineFoodMap = new HashMap<>();
        foodMap = new HashMap<>();
        for(int i=0;i<foods.length;i+=1){
            if(!cuisineFoodMap.containsKey(cuisines[i])){
                PriorityQueue<Food> pq = new PriorityQueue<>((f1,f2)-> {
                    if(Integer.compare(f1.rating,f2.rating) == 0)
                        return f1.name.compareTo(f2.name);
                    return Integer.compare(f2.rating,f1.rating);
                });
                cuisineFoodMap.put(cuisines[i],pq);
            }
            
            Food currFood = new Food(foods[i],cuisines[i],ratings[i]);
            PriorityQueue<Food> pq = cuisineFoodMap.get(cuisines[i]);
            pq.add(currFood);
            
            foodMap.put(foods[i],currFood);
        }
    }
    
    public void changeRating(String food, int newRating) {
        Food currFood = foodMap.get(food);
        PriorityQueue<Food> currPq = cuisineFoodMap.get(currFood.cuisine);
        currPq.remove(currFood);
        currFood.rating = newRating;
        currPq.add(currFood);
    }
    
    public String highestRated(String cuisine) {
        return cuisineFoodMap.get(cuisine).peek().name;
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */