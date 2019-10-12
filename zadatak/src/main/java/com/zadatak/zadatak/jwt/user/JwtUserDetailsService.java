package com.zadatak.zadatak.jwt.user;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zadatak.zadatak.database.UserDTO;
import com.zadatak.zadatak.database.dao.DAORole;
import com.zadatak.zadatak.database.dao.DAOUser;
import com.zadatak.zadatak.database.intf.UserDao;
import com.zadatak.zadatak.database.intf.UserService;

@Service(value = "userService")
public class JwtUserDetailsService implements UserDetailsService, UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public DAOUser save(UserDTO user) {
		// TODO Auto-generated method stub
		DAOUser newUser = new DAOUser();
		DAORole role = new DAORole();
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    role.setName("USER");
	    Set<DAORole> setRole = new HashSet<DAORole>();
	    setRole.add(role);
	    newUser.setRoles(setRole);
        return userDao.save(newUser);
	}

	@Override
	public List<DAOUser> findAll() {
		// TODO Auto-generated method stub
		List<DAOUser> list = new ArrayList<>();
		userDao.findAll().iterator().forEachRemaining(list::add);
		return list;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userDao.deleteById(id);
	}

	@Override
	@Cacheable("username")
	public DAOUser findByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.findByUsername(username);
	}

	@Override
	@Cacheable("id")
	public DAOUser findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		DAOUser user = userDao.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new User(user.getUsername(), user.getPassword(), getAuthority(user));
	}
	
	@Cacheable("authorities")
	private Set<SimpleGrantedAuthority> getAuthority(DAOUser user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getRoles().forEach(role -> {authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));});
		return authorities;
	}

	@Override
	public DAOUser updateUser(int id, UserDTO user) {
		// TODO Auto-generated method stubs
		userDao.findById(id);
		DAOUser newUser = new DAOUser();
		DAORole role = new DAORole();
		newUser.setId(id);
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    role.setName("USER");
	    Set<DAORole> setRole = new HashSet<DAORole>();
	    setRole.add(role);
	    newUser.setRoles(setRole);
        return userDao.save(newUser);
	}

	@Override
	public DAOUser updateAdmin(int id, UserDTO user) {
		// TODO Auto-generated method stub
		userDao.findById(id);
		DAOUser newUser = new DAOUser();
		DAORole role = new DAORole();
		newUser.setId(id);
	    newUser.setUsername(user.getUsername());
	    newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
	    role.setName("ADMIN");
	    Set<DAORole> setRole = new HashSet<DAORole>();
	    setRole.add(role);
	    newUser.setRoles(setRole);
        return userDao.save(newUser);
	}

}
