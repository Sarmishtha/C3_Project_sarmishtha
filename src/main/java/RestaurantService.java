import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException{
    	 for(Restaurant res: restaurants) {
             if(res.getName().equals(restaurantName))
                 return res;
         }
    	 throw new restaurantNotFoundException(restaurantName);
    }

  public String findTotalCost(List<Item> items)
    {
    	Integer total=0;
    	 for(Item item: items) {
    		 total=total+item.getPrice();
    	 }
    	 if(total==0)
    		 return "Failed to add";
    	return total.toString();
    	
    }
    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
