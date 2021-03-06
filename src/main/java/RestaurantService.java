import javax.management.InvalidApplicationException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class RestaurantService {
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        Restaurant restaurantToBeFound = new Restaurant(restaurantName);
        if (restaurantToBeFound.getName() == restaurantName) {
            return restaurantToBeFound;
        }
        throw new restaurantNotFoundException(restaurantName + " does not exists");
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

    public String orderTotal(Item... items) {
        String orderTotal = "" ;
        for (int i = 0;i< items.length;i++){
            orderTotal += items[i];
        }
        return orderTotal;

    }
}
