package com.zadatak.zadatak.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zadatak.zadatak.database.dao.DAOUser;
import com.zadatak.zadatak.database.intf.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<DAOUser> listUser(){
        return userService.findAll();
    }
	
	@PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public DAOUser getOne(@PathVariable(value = "id") int id){
        return userService.findById(id);
    }
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
    public DAOUser create(@RequestBody UserDTO user){
        return userService.save(user);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/user/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable(value = "id") int id){
		userService.delete(id);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/create", method = RequestMethod.POST)
    public DAOUser adminCreate(@RequestBody UserDTO user){
        return userService.save(user);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/updateu/{id}", method = RequestMethod.POST)
    public DAOUser updateUser(@PathVariable(value = "id") int id, @RequestBody UserDTO user){
        return userService.updateUser(id, user);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@RequestMapping(value="/updatea/{id}", method = RequestMethod.POST)
    public DAOUser updateAdmin(@PathVariable(value = "id") int id, @RequestBody UserDTO user){
        return userService.updateAdmin(id, user);
    }

}
