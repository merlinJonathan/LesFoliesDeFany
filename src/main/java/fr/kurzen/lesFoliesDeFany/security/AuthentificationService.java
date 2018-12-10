package fr.kurzen.lesFoliesDeFany.security;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import fr.kurzen.lesFoliesDeFany.enums.EnumRoles;
import fr.kurzen.lesFoliesDeFany.model.MyUser;
import fr.kurzen.lesFoliesDeFany.service.MyUserService;

@Service
@Transactional
public class AuthentificationService implements UserDetailsService{

	@Autowired
	private MyUserService myuserservice;
	
	@Override
	public UserDetails loadUserByUsername(final String login) {
		MyUser user =myuserservice.findBylogin(login);
		List<GrantedAuthority> rules = this.getUserCredentials(user);
		return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), rules);
		
	}

	private List<GrantedAuthority> getUserCredentials(MyUser user) {
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		 
		 authorities.add(new SimpleGrantedAuthority(EnumRoles.ROLE_USER.getRole()));
		 if(user.getRole().equals(EnumRoles.ROLE_ADMIN.getRole()))
		 {
			 authorities.add(new SimpleGrantedAuthority(EnumRoles.ROLE_ADMIN.getRole()));
		 }
		 
		return authorities;
	}

}