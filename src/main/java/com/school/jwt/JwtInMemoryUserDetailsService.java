package com.school.jwt;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.school.beans.User;
import com.school.repositories.UserRepo;



@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {

  @Autowired
  private UserRepo uR ;
	
	
  //static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();

  //static {
  //  inMemoryUserList.add(new JwtUserDetails(1L, "toto",
  //      "$2a$10$Bi7DWJTLZp4fjT8oT96q0erNCzQD5QtR62uT1v7QFWddmp3c9.g.G", "ADMIN"));
  //}

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    
	  Optional<User> user = uR.findByEmail(email);
	    
	  Optional<JwtUserDetails> userJwt = Optional.empty();
	  
	  if(user.isPresent()) {
		  userJwt = Optional.of(new JwtUserDetails(user.get().getIdUser(),user.get().getEmail(),user.get().getPass(),user.get().getRole()));
	  }
	  
	  //Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
      //  .filter(userJwt -> userJwt.getUsername().equals(userJwtname)).findFirst();

	  if (!userJwt.isPresent()) {
		  throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", email));
	  }

	  return userJwt.get();
  }

}