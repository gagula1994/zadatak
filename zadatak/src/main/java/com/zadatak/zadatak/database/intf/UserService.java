package com.zadatak.zadatak.database.intf;

import java.util.List;

import com.zadatak.zadatak.database.UserDTO;
import com.zadatak.zadatak.database.dao.DAOUser;

public interface UserService {
	DAOUser save(UserDTO user);
    List<DAOUser> findAll();
    void delete(int id);
    DAOUser findByUsername(String username);
    DAOUser findById(int id);
	DAOUser updateUser(int id, UserDTO user);
	DAOUser updateAdmin(int id, UserDTO user);

}
