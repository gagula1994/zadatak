package com.zadatak.zadatak.log;

import java.util.Date;

import org.hibernate.envers.RevisionListener;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class UserRevisionListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		// TODO Auto-generated method stub
		UserRevisionEntity rev = (UserRevisionEntity) revisionEntity;
		Date timestamp = new Date();
		rev.setUsername(getUsername());
		rev.setModifiedAt(timestamp);
	}
	
	@Cacheable("username")
	private String getUsername() {
		String username = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
		return username;
		
	}

}
