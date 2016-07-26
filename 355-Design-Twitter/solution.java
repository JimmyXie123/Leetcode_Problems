class tweet{
    int order;
    int tweetId;
    int userId;
    public tweet(int userId, int tweetId, int order){
        this.userId = userId;
        this.tweetId = tweetId;
        this.order = order;
    } 
}

public class Twitter {
    HashMap<Integer, HashSet<Integer>> friends;
    HashMap<Integer, ArrayList<tweet>> user_tweets;
    int order;
    /** Initialize your data structure here. */
    public Twitter() {
        friends = new HashMap();
        user_tweets = new HashMap();
        order = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!user_tweets.containsKey(userId)){
            user_tweets.put(userId, new ArrayList<tweet>());
        }
        user_tweets.get(userId).add(new tweet(userId, tweetId, order));
        order++;
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<tweet> tmp = new ArrayList();
        if(user_tweets.containsKey(userId)){         //-------------null pointer -----------------
            tmp.addAll(user_tweets.get(userId));
        }
        if(friends.containsKey(userId)){             //-------------null pointer -----------------
            for(Integer i:friends.get(userId)){
                if(user_tweets.containsKey(i)){      //-------------null pointer-------------
                    tmp.addAll(user_tweets.get(i));
                }
            }
        }
        Collections.sort(tmp, new Comparator<tweet>(){
            public int compare(tweet t1, tweet t2){
                return t2.order-t1.order;
            }
        });
        List<Integer> res = new ArrayList();
        for(int i=0; i<tmp.size()&&i<10; i++){
            res.add(tmp.get(i).tweetId);
        }
        return res;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId==followeeId){
            return;
        }
        if(!friends.containsKey(followerId)){
            friends.put(followerId, new HashSet<Integer>());
        }
        friends.get(followerId).add(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(friends.containsKey(followerId)){
            friends.get(followerId).remove(followeeId);
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