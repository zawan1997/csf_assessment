package vttp2022.csf.assessment.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Restaurant;
import vttp2022.csf.assessment.server.repositories.MapCache;
import vttp2022.csf.assessment.server.repositories.RestaurantRepository;

public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepo;

	@Autowired
	private MapCache mapCache;

	// TODO Task 2
	// Use the following method to get a list of cuisines
	// You can add any parameters (if any) and the return type
	// DO NOT CHNAGE THE METHOD'S NAME
	public Optional<List<String>> getCuisines() {
		return restaurantRepo.getCuisines();
	}

	// TODO Task 3
	// Use the following method to get a list of restaurants by cuisine
	// You can add any parameters (if any) and the return type
	// DO NOT CHNAGE THE METHOD'S NAME
	public Optional<List<Restaurant>> getRestaurantsByCuisine(String name) {
		// Implmementation in here
		Restaurant restaurant = new Restaurant();
		Optional<List<String>> names = restaurantRepo.getRestaurantsByCuisine(name);
		if (names.isPresent()) {
			// for(int i = 0; i<names.size(); i ++)
			// restaurant.setName(names.get(i));
		}
		return null;
	}

	// Duplicate of task 3. Attempting different method
	// public Optional<List<String>> getRestaurantsByCuisine(String name) {
	// // Implmementation in here
	// return restaurantRepo.getRestaurantsByCuisine(name);
	// }

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any)
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// public Optional<Restaurant> getRestaurant(???) {
	// Implmementation in here

	

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	public void addComment(Comment comment) {
		// Implmementation in here

	}
	//
	// You may add other methods to this class
}
