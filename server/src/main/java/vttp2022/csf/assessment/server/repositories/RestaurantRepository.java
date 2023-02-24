package vttp2022.csf.assessment.server.repositories;

import java.util.List;
import java.util.Optional;

import javax.print.Doc;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp2022.csf.assessment.server.models.Comment;
import vttp2022.csf.assessment.server.models.Cuisine;
import vttp2022.csf.assessment.server.models.Restaurant;

@Repository
public class RestaurantRepository {

	@Autowired
	private MongoTemplate template;

	private static final String CUISINE_COL = "cuisine";

	// {
	// "address": {
	// "building": "1007",
	// "coord": [
	// -73.856077,
	// 40.848447
	// ],
	// "street": "Morris Park Ave",
	// "zipcode": "10462"
	// },
	// "borough": "Bronx",
	// "cuisine": "Bakery",
	// "grades": [

	// TODO Task 2
	// Use this method to retrive a list of cuisines from the restaurant collection
	// You can add any parameters (if any) and the return type
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	//
	public Optional<List<String>> getCuisines() {
		// Implmementation in here

		// Criteria c = Criteria.where("cuisine");
		// return template.find(c,Document.class, CUISINE_COL);
		Criteria c = Criteria.where("cuisine");
		Query q = Query.query(c);
		List<Document> results = template.find(q, Document.class, CUISINE_COL);
		if (results.isEmpty()) {
			return Optional.empty();
		}

		List<String> cuisine = results.stream().map(g -> g.getString("cuisine")).toList();

		return Optional.of(cuisine);
	}

	// TODO Task 3
	// Use this method to retrive a all restaurants for a particular cuisine
	// You can add any parameters (if any) and the return type
	// DO NOT CHNAGE THE METHOD'S NAME
	// Write the Mongo native query above for this method
	//
	public Optional<List<String>> getRestaurantsByCuisine(String cuisine) {
		Criteria criteria = Criteria.where("cuisine").is(cuisine);
		// LookupOperation findRestaraunt = Aggregation.("restaraunts",)
		Query q = Query.query(criteria);
		// Document doc = document.iterator().next();
		// List<Restaurant> restaurant = doc.getList()
		// Looking through Mongo to try and find if the cuisine exists
		List<Document> document = template.find(q, Document.class, CUISINE_COL);

		if (document.isEmpty()) {
			return Optional.empty();
		}
		// Mapping the result
		List<String> restaraunts = document.stream().map(g -> g.getString("name")).toList();
		return Optional.of(restaraunts);

		//Get back a list of string of names. For task 4 use the name go back to repo to call other
	}

	// TODO Task 4
	// Use this method to find a specific restaurant
	// You can add any parameters (if any)
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//
	public Optional<Restaurant> getRestaurant(String name) {
		// Implmementation in here
		Criteria criteria = Criteria.where("name").is(name);
	Query query = Query.query(criteria);
	// return template.find(query, Document.class, "restaurants")	
	// .stream().map(v->)
	return null;

	
	}

	// TODO Task 5
	// Use this method to insert a comment into the restaurant database
	// DO NOT CHNAGE THE METHOD'S NAME OR THE RETURN TYPE
	// Write the Mongo native query above for this method
	//
	public void addComment(Comment comment) {
		// Implmementation in here

	}

	// You may add other methods to this class

}
