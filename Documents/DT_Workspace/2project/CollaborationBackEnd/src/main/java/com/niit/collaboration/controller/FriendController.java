package com.niit.collaboration.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;
import com.niit.collaboration.model.User;
import com.niit.collaboration.model.Friend;

@RestController
public class FriendController {

	private static final Logger logger = LoggerFactory.getLogger(FriendController.class);

	@Autowired
	FriendDAO friendDAO;

	@Autowired
	Friend friend;
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	UserDAO userDAO;

	@RequestMapping(value = "/myFriends", method = RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriends() {
		logger.debug("->->->->calling method getMyFriends");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		List<Friend> myFriends = new ArrayList<Friend>();
		if(loggedInUserID == null)
		{
			friend.setErrorCode("404");
			friend.setErrorMessage("Please login to know your friends");
			myFriends.add(friend);
			return new ResponseEntity<List<Friend>>(myFriends, HttpStatus.OK);
			
		}
       
		logger.debug("getting friends of : " + loggedInUserID);
		 myFriends = friendDAO.getMyFriends(loggedInUserID);

		if (myFriends.isEmpty()) {
			logger.debug("Friends does not exsit for the user : " + loggedInUserID);
			friend.setErrorCode("404");
			friend.setErrorMessage("You does not have any friends");
			myFriends.add(friend);
		}
		logger.debug("Send the friend list ");
		return new ResponseEntity<List<Friend>>(myFriends, HttpStatus.OK);
	}

	@RequestMapping(value = "/addFriend/{friendID}", method = RequestMethod.GET)
	public ResponseEntity<Friend> sendFriendRequest(@PathVariable("friendID") String friendID) {
		logger.debug("->->->->calling method sendFriendRequest");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		friend.setUserID(loggedInUserID);
		friend.setFriendID(friendID);
		friend.setStatus("N"); // N - New, R->Rejected, A->Accepted
		friend.setIsOnline('N');
		// Is the user already sent the request previous?
		
		//check whether the friend exist in user table or not
		if(isUserExist(friendID)==false)
		{
			friend.setErrorCode("404");
			friend.setErrorMessage("No user exist with the id :" + friendID);
		}
		
		else

		if (friendDAO.get(loggedInUserID, friendID) != null) {
			friend.setErrorCode("404");
			friend.setErrorMessage("You already sent the friend request to " + friendID);

		} else {
			friendDAO.save(friend);

			friend.setErrorCode("200");
			friend.setErrorMessage("Friend request successfull.." + friendID);
		}

		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}
	
	
	
	private boolean isUserExist(String id)
	{
		if(userDAO.get(id)==null)
			return false;
		else
			return true;
	}
	
	
	private boolean isFriendRequestAvailabe(String friendID)
	{
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		
		if(friendDAO.get(loggedInUserID,friendID)==null)
			return false;
		else
			return true;
	}

	@RequestMapping(value = "/unFriend/{friendID}", method = RequestMethod.PUT)
	public ResponseEntity<Friend> unFriend(@PathVariable("friendID") String friendID) {
		logger.debug("->->->->calling method unFriend");
		updateRequest(friendID, "U");
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}

	@RequestMapping(value = "/rejectFriend/{friendID}", method = RequestMethod.PUT)
	public ResponseEntity<Friend> rejectFriendFriendRequest(@PathVariable("friendID") String friendID) {
		logger.debug("->->->->calling method rejectFriendFriendRequest");

		updateRequest(friendID, "R");
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}

	@RequestMapping(value = "/accepttFriend/{friendID}", method = RequestMethod.PUT)
	public ResponseEntity<Friend> acceptFriendFriendRequest(@PathVariable("friendID") String friendID) {
		logger.debug("->->->->calling method acceptFriendFriendRequest");
        
		friend = updateRequest(friendID, "A");
		return new ResponseEntity<Friend>(friend, HttpStatus.OK);

	}

	private Friend updateRequest(String friendID, String status) {
		logger.debug("Starting of the method updateRequest");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		logger.debug("loggedInUserID : " + loggedInUserID);
		
		if(isFriendRequestAvailabe(friendID)==false)
		{
			friend.setErrorCode("404");
			friend.setErrorMessage("The request does not exist.  So you can not update to "+status);
		}
		
		if (status.equals("A") || status.equals("R"))
			friend = friendDAO.get(friendID, loggedInUserID);
		else
			friend = friendDAO.get(loggedInUserID, friendID);
		friend.setStatus(status); // N - New, R->Rejected, A->Accepted

		friendDAO.update(friend);

		friend.setErrorCode("200");
		friend.setErrorMessage(
				"Request from   " + friend.getUserID() + " To " + friend.getFriendID() + " has updated to :" + status);
		logger.debug("Ending of the method updateRequest");
		return friend;

	}

	@RequestMapping(value = "/getMyFriendRequests/", method = RequestMethod.GET)
	public ResponseEntity<List<Friend>> getMyFriendRequests() {
		logger.debug("->->->->calling method getMyFriendRequests");
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		List<Friend> myFriendRequests = friendDAO.getNewFriendRequests(loggedInUserID);
		return new ResponseEntity<List<Friend>>(myFriendRequests, HttpStatus.OK);

	}
	
	
	@RequestMapping("/getRequestsSendByMe")
	public ResponseEntity<List<Friend>>  getRequestsSendByMe()
	{
		logger.debug("->->->->calling method getRequestsSendByMe");
		
		String loggedInUserID = (String) httpSession.getAttribute("loggedInUserID");
		List<Friend> requestSendByMe = friendDAO.getRequestsSendByMe(loggedInUserID);
		
		logger.debug("->->->->Ending method getRequestsSendByMe");
		
		return new ResponseEntity<List<Friend>>(requestSendByMe, HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
