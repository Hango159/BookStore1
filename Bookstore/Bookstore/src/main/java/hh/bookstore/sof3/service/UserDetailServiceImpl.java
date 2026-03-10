package hh.bookstore.sof3.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hh.bookstore.sof3.domain.AppUsers;
import hh.bookstore.sof3.domain.UsersRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UsersRepository repository;

    public UserDetailServiceImpl(UsersRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUsers curruser = repository.findByUsername(username);
        UserDetails user = new User(username, curruser.getPasswordHash(),
                AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }
}
