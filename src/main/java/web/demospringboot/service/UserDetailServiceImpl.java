package web.demospringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import web.demospringboot.entity.UserEntity;
import web.demospringboot.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findOneByUser(username);
        System.out.println("Account: "+userEntity);

        if(userEntity == null){
            throw new UsernameNotFoundException("User "+username+" was not found!");
        }

        String role = userEntity.getRole();
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        grantedAuthorities.add(authority);

        boolean enabled = userEntity.getStatus()==1?true:false;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        UserDetails userDetails = (UserDetails) new User(userEntity.getName(),
                userEntity.getPass(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked, grantedAuthorities);

        return userDetails;
    }
}
