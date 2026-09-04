class Twitter {
    private int timestamp;
    private Map<Integer, List<int[]>> tweets;
    private Map<Integer, Set<Integer>> followers;

    public Twitter() {
        this.tweets = new HashMap<>();
        this.followers = new HashMap<>();
        this.timestamp = 0;
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new LinkedList<>());
        tweets.get(userId).add(new int[]{timestamp++, tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // Add user's own tweets
        addRecentTweets(userId, maxHeap);

        // Add followed users' tweets
        for (int followeeId : followers.getOrDefault(userId, new HashSet<>())) {
            if (followeeId != userId) {
                addRecentTweets(followeeId, maxHeap);
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!maxHeap.isEmpty() && res.size() < 10) {
            res.add(maxHeap.poll()[1]); // tweetId
        }
        return res;
    }

    private void addRecentTweets(int userId, PriorityQueue<int[]> heap) {
        List<int[]> userTweets = tweets.getOrDefault(userId, new ArrayList<>());
        int n = userTweets.size();
        for (int i = n - 1; i >= Math.max(0, n - 10); i--) {
            heap.offer(userTweets.get(i));
        }
    }
    
    public void follow(int followerId, int followeeId) {
        followers.putIfAbsent(followerId, new HashSet<>());
        followers.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (followers.containsKey(followerId)) {
            followers.get(followerId).remove(followeeId);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */