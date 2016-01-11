package com.prongbang.moni.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException; 
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 *
 * @author prongbang
 */
public class UserAuthenticationProvider implements UserDetailsService, AuthenticationProvider {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        // TODO
        
        return null;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        
        final String username = authentication.getName();
        final String password = authentication.getCredentials().toString();
        
        
//         User user = userDao.findByLoginAndPassword(loginname, password);
//             if (user == null) {
//                    throw new BadCredentialsException("user not found");
//             }
//             List<GrantedAuthority> grantedAuths = new ArrayList<>();
//             grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
//             Authentication auth=new UsernamePasswordAuthenticationToken(loginname,password,grantedAuths);
//             return auth;
        
        System.out.println(username + " " + password);
        
        return new UsernamePasswordAuthenticationToken(null, password, null);
        
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
