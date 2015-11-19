package com.model;

import java.util.Date;

public class Topic {
private int topicid;
private String topicName;
private String comment;
private String userId;
private Date time;
public int getTopicid() {
	return topicid;
}
public void setTopicid(int topicid) {
	this.topicid = topicid;
}
public String getTopicName() {
	return topicName;
}
public void setTopicName(String topicName) {
	this.topicName = topicName;
}
public String getComment() {
	return comment;
}
public void setComment(String comment) {
	this.comment = comment;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public Date getTime() {
	return time;
}
public void setTime(Date time) {
	this.time = time;
}


}
