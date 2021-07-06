package com.baitaplon.securiry;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.baitaplon.dto.MyUser;
import com.baitaplon.entity.UserEntity;
import com.baitaplon.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntiry= new UserEntity();
		List<GrantedAuthority> authorities= new ArrayList<GrantedAuthority>();
		try {
			userEntiry= userRepository.findOneByUserName(username);
			if(userEntiry==null) {
				throw new UsernameNotFoundException("User not found");
			}
			else
			{
				authorities.add(new SimpleGrantedAuthority(userEntiry.getRole().getCode()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		MyUser myUser = new MyUser(userEntiry.getUserName(), userEntiry.getPassword(), true, true, true, true, authorities);
		myUser.setFullName(userEntiry.getFullName());
		myUser.setId(userEntiry.getId());
		myUser.setRoleCode(userEntiry.getRole().getCode());
		return myUser;
	}

}
