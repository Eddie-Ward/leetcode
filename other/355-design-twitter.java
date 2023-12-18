package other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class Twitter {

    private HashMap<Integer, User> users;
    private List<Tweet> tweets;

    public Twitter() {
        users = new HashMap<>();
        tweets = new ArrayList<>();
    }

    public void postTweet(int userId, int tweetId) {
        getOrCreateUser(userId);
        Tweet newTweet = new Tweet(userId, tweetId);
        tweets.add(newTweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> newsFeed = new ArrayList<>();

        if (!users.containsKey(userId)) {
            return newsFeed;
        }

        HashSet<Integer> following = users.get(userId).following;

        for (int i = tweets.size() - 1; i >= 0; --i) {
            Tweet curTweet = tweets.get(i);
            if (following.contains(curTweet.userId)) {
                newsFeed.add(curTweet.postId);
            }
            if (newsFeed.size() == 10) {
                return newsFeed;
            }
        }
        return newsFeed;
    }

    public void follow(int followerId, int followeeId) {
        User newFollower = getOrCreateUser(followerId);
        getOrCreateUser(followeeId);

        if (newFollower.following.contains(followeeId)) {
            return;
        }

        newFollower.following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User curFollower = getOrCreateUser(followerId);
        getOrCreateUser(followeeId);

        if (curFollower.following.contains(followeeId)) {
            curFollower.following.remove(followeeId);
        }
    }

    private User getOrCreateUser(int userId) {
        if (!users.containsKey(userId)) {
            users.put(userId, new User(userId));
        }
        return users.get(userId);
    }

    class User {
        int userId;
        HashSet<Integer> following;

        private User(int userId) {
            this.userId = userId;
            following = new HashSet<>();
        }
    }

    class Tweet {
        int userId;
        int postId;

        private Tweet(int userId, int postId) {
            this.userId = userId;
            this.postId = postId;
        }
    }
}
