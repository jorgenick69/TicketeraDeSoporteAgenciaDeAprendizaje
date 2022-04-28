/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.serviceIMPL;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.User;
import TicketeraDeSoporte.TicketeraDeSoporte.repository.UserRepository;
import TicketeraDeSoporte.TicketeraDeSoporte.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    @Override
    public List<User> findAllUser() {
        return (List<User>) userRepository.findAll();
    }

    @Transactional
    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findUser(User user) {
        return userRepository.findById(user.getId()).orElse(null);
    }

}
