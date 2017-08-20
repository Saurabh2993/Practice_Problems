package test_Package;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tweet_Recommendation {
	
	static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, int targetUser, int minLikeThreshold) {

		//Create a set of users followed by our target user
		Set<Integer> usersFollowedByTarget = new HashSet<>();

		for(int i = 0; i < followGraph_edges.length; i ++) {
			if(followGraph_edges[i][0] == targetUser) {
				usersFollowedByTarget.add(followGraph_edges[i][1]);
			}
		}
		
		if(usersFollowedByTarget.size() < minLikeThreshold) {
			int[] recommendations = new int[0];
			return recommendations;
		}

		//Create a set of tweets that we are considering
		Set<Integer> allTweets = new HashSet<>();

		//Create a hashmap of users and the list of tweets they have liked
		HashMap<Integer, Set<Integer>> tweetsLiked = new HashMap<>();

		for(int i = 0; i < likeGraph_edges.length; i ++) {
			//Check if the user belongs in the set of users that are followed by targetUser
			if(usersFollowedByTarget.contains(likeGraph_edges[i][0])) {
				//Adding to the set of tweets to be considered
				allTweets.add(likeGraph_edges[i][1]);

				if(tweetsLiked.containsKey(likeGraph_edges[i][0])) {
					Set<Integer> tweets = tweetsLiked.get(likeGraph_edges[i][0]);
					tweets.add(likeGraph_edges[i][1]);
					tweetsLiked.put(likeGraph_edges[i][0], tweets);
				} else {
					Set<Integer> tweets = new HashSet<>();
					tweets.add(likeGraph_edges[i][1]);
					tweetsLiked.put(likeGraph_edges[i][0], tweets);
				}
			}
		}
		
		//Create a hashmap of tweets and the likes they have got from followed users
		HashMap<Integer, Integer> tweetLikes = new HashMap<>();
		
		//Updating the number of likes by going through all the tweets
		for(Integer tweet : allTweets) {
			
			//Finding the likes for each tweet by going through users in our hashmap
			int likes = 0;
			for(Integer user : tweetsLiked.keySet()) {
				Set<Integer> tweets = tweetsLiked.get(user);
				if(tweets.contains(tweet)) {
					likes++;
				}
			}
			tweetLikes.put(tweet, likes);
		}
		
		//Going through our tweetLikes hashmap to find tweets that have likes more than or equal to minLikeThreshold
		List<Integer> recommendationList = new ArrayList<>();
		
		for(Integer tweet : tweetLikes.keySet()) {
			if(tweetLikes.get(tweet) >= minLikeThreshold) {
				recommendationList.add(tweet);
			}
		}
		
		Collections.sort(recommendationList);
		int[] recommendations = new int[recommendationList.size()];
		
		int index = 0;
		for(Integer tweet : recommendationList) {
			recommendations[index++] = tweet;
		}
		
		return recommendations;

	}

}
