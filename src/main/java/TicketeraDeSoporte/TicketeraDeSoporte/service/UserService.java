/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.service;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.User;
import java.util.List;

/**
 *
 * @author Jorge Dominguez
 */
public interface UserService {
    public List<User> findAllUser();
    public void save(User user);
    public void delete(User user);
    public User findUser(User user);
    
}
