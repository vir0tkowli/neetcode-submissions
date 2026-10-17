class Twitter {
    private Map<Integer, User> users = new HashMap<>();
    private Map<User, List<Tweet>> tweetMap;

    private int timestamp = 0;

    public Twitter() {
        this.tweetMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        User u = users.computeIfAbsent(userId, id -> new User(id));
        tweetMap.computeIfAbsent(u, k -> new ArrayList<>()).add(new Tweet(tweetId, timestamp--));
        if (tweetMap.get(u).size() > 10) {
            tweetMap.get(u).remove(0);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        User user = users.get(userId);

        if (user == null) {
            return res;
        }
        // Min heap of user id and tweet id
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            Comparator.comparingLong(entry -> tweetMap.get(users.get(entry[0])).get(entry[1]).timestamp));

        Set<Integer> followees = new HashSet<>(user.followees);
        followees.add(userId);
        for (int followeeId : followees) {
            User followee = users.get(followeeId);
            List<Tweet> tweets = tweetMap.get(followee);

            if (tweets != null && !tweets.isEmpty()) {
                minHeap.offer(new int[]{followeeId, tweets.size() - 1});
            }
        }

        while (!minHeap.isEmpty() && res.size() < 10) {
            int[] curr = minHeap.poll();

            List<Tweet> tweets = tweetMap.get(users.get(curr[0]));
            int index = curr[1];

            res.add(tweets.get(index).tweetId);

            if (index > 0) {
                minHeap.offer(new int[]{curr[0], index - 1});
            }
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        User follower = users.computeIfAbsent(
            followerId, id -> new User(id)
        );
        // User follower = new User(followerId);
        users.computeIfAbsent(followeeId, id -> new User(id));
        follower.followees.add(followeeId);

    }
    
    public void unfollow(int followerId, int followeeId) {
        User follower = users.get(followerId);

        if (follower != null) {
            follower.followees.remove(followeeId);
        }
    }

}

class User {
    int userId;
    final Set<Integer> followees = new HashSet<>();

    public User(int userId) {
        this.userId = userId;
    }
    public int getUserId() {
        return this.userId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        return userId == ((User) obj).userId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(userId);
    }
}

class Tweet {
    int tweetId;
    final long timestamp;

    public Tweet(int tweetId, int timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }
    public int getTweetId() {
        return this.tweetId;
    }
}
