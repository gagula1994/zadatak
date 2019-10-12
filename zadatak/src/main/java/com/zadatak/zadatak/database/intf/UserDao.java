package com.zadatak.zadatak.database.intf;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zadatak.zadatak.database.dao.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, Integer> {
	DAOUser findByUsername(String username);

}
