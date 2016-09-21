package hashtable;


import java.util.*;

/**
 * Created by xiyuanbupt on 9/21/16.
 */
public class Twitter {

    /**
     * 一个用户关注了哪些用户
     */
    Map<Integer,Set<Integer>> follows = new HashMap<>();

    /**
     * 一个用户发送的所有Twitter
     */
    Map<Integer,List<Message>> post = new HashMap<>();


    /**
     * 用于记录发送Twitter 的时间
     */
    long time = 0;

    /** Initialize your data structure here. */
    public Twitter() {

    }

    class Message implements Comparable<Message>{
        int id;
        long time;

        @Override
        public int compareTo(Message o) {
            return (int)(-this.time + o.time);
        }

        public Message(int id, long time){
            this.id = id;
            this.time = time;
        }

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!follows.containsKey(userId)){
            Set<Integer> follow = new HashSet<>();
            follow.add(userId);
            follows.put(userId,follow);
        }
        if(!post.containsKey(userId)){
            post.put(userId,new ArrayList<Message>());
        }
        post.get(userId).add(new Message(tweetId,time++));
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Message> res = new ArrayList<>();
        Set<Integer> follows = this.follows.get(userId);
        if(follows==null)return new ArrayList<>();
        for(int i:follows){
            if(!post.containsKey(i)){
                post.put(i,new ArrayList<Message>());
            }
            res.addAll(post.get(i));
        }
        Collections.sort(res);
        if(res.size()<=0)return new ArrayList<>();
        if(res.size()>10){
            res = res.subList(0,10);
        }
        List<Integer> messages = new ArrayList<>();
        for(Message message:res){
            messages.add(message.id);
        }
        return messages;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!follows.containsKey(followerId)){
            Set<Integer> follow = new HashSet<>();
            follow.add(followeeId);
            follow.add(followerId);
            follows.put(followerId,follow);
        }else {
            follows.get(followerId).add(followeeId);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId)return ;
        try {
            follows.get(followerId).remove(new Integer(followeeId));
        }catch (Exception e){

        }
    }

    public static void main(String[] args){
        List<Integer> res = new ArrayList<>();
        res.add(1);
        System.out.println(res.subList(0,10));
    }
}
