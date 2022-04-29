/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.serviceIMPL;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.Rol;
import TicketeraDeSoporte.TicketeraDeSoporte.entity.UserNew;
import TicketeraDeSoporte.TicketeraDeSoporte.repository.UserRepository;
import TicketeraDeSoporte.TicketeraDeSoporte.service.UserService;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceIMPL implements UserService,UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public List<UserNew> findAllUser() {
        return (List<UserNew>) userRepository.findAll();
    }

    @Transactional
    @Override
    public void save(UserNew user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(UserNew user) {
        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public UserNew findUser(UserNew user) {
        return userRepository.findById(user.getId()).orElse(null);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       UserNew usernew=userRepository.findByUsername(username);
        if (usernew != null) {
            List<GrantedAuthority> permisos=new ArrayList<>();
            GrantedAuthority p1= new SimpleGrantedAuthority("ROLE_ADMIN");
            GrantedAuthority p2= new SimpleGrantedAuthority("ROLE_USER");
            permisos.add(p1);
            permisos.add(p2);
            User user= new User(usernew.getEmail(), usernew.getPassword(), permisos);
            return user;
        }else{
        return null;
        }
        
    }

   
   

}
