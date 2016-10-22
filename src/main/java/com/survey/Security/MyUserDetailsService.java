/*package com.survey.Security;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.survey.dao.UsersDAO;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

	//get user from the database, via Hibernate
	@Autowired
	private UsersDAO usersDAO;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String email)
		throws UsernameNotFoundException {

		com.survey.model.User user = usersDAO.getUserByEmail(email);
		List<GrantedAuthority> authorities =
                                      buildUserAuthority();

		return buildUserForAuthentication(user, authorities);

	}

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.survey.model.User  user,
		List<GrantedAuthority> authorities) {
		return new User(user.getEmail(), user.getPassword(),
			user.getBlockUser(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority() {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		
			setAuths.add(new SimpleGrantedAuthority("admin"));
			setAuths.add(new SimpleGrantedAuthority("surveyor"));
			setAuths.add(new SimpleGrantedAuthority("user"));
			
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
System.out.println("result"+Result);
		return Result;
	}

}*/