package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;

public interface FriendDAO {	
	
	public boolean save(Friend friend);
    public boolean update(Friend friend);
    public void delete(String userID, String friendID);
    public List<Friend> getMyFriends(String userID);
    public List<Friend> getNewFriendRequests(String friendID);
    public List<Friend> getRequestsSendByMe(String userID);
    public Friend get(String userID, String friendID);
    public Friend get(String userID);
    public void setOnline(String id);
	public void setOffLine(String loggedInUserID);
    

}
