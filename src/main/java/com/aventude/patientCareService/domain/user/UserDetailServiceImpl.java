package com.aventude.patientCareService.domain.user;

import com.aventude.patientCareService.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * Implementation of spring provides UserDetailsService.
 *
 * @author Nuwan Danushka
 */

@Service
public class UserDetailServiceImpl implements UserDetailsService {

  @Autowired
  UserRepository userIdentityRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Optional<User> optionalUser = userIdentityRepository
            .findUserByEmailAndEnabled(email, true);
    optionalUser.orElseThrow(() ->
            new UsernameNotFoundException("User Not Found")
    );
    return optionalUser.map(user -> {
      Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
      grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
      return new org.springframework.security.core.userdetails.User(user.getEmail(),
              user.getPassword(), grantedAuthorities);
    }).get();

  }
}
