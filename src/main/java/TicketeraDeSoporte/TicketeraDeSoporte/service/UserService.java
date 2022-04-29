/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.service;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.UserNew;
import java.util.List;

/**
 *
 * @author Jorge Dominguez
 */
public interface UserService {
    public List<UserNew> findAllUser();
    public void save(UserNew user);
    public void delete(UserNew user);
    public UserNew findUser(UserNew user);
    
}
