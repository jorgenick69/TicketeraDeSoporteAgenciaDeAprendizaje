
package TicketeraDeSoporte.TicketeraDeSoporte.controller;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.UserNew;
import TicketeraDeSoporte.TicketeraDeSoporte.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jorge Dominguez
 */
@Controller
@RequestMapping("/us")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String listUsers(Model model) {
        var users=userService.findAllUser();
        model.addAttribute("users", users);
    return "vusers";
    }
    
    @GetMapping("/users")
    public String userL(Model model) {
        var users = userService.findAllUser();
        for (UserNew user : users) {
            System.out.println(user.getName());
        }
        model.addAttribute("users", users);
        return "vusers";
    }
    @GetMapping("/adding")
    public String add(UserNew userNew) {
              
        return "modify-user";
    }
    @PostMapping("/save")
    public String save(UserNew userNew) {
       userNew.setPassword(new BCryptPasswordEncoder().encode(userNew.getPassword()));
       userService.save(userNew);
        
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(UserNew users, Model model){
        users=userService.findUser(users);
        model.addAttribute("user",users);
        return "modify-user";
    
    }
    @GetMapping("/delete/{id}")
    public String delete(UserNew user){
       userService.delete(user);
        
        return "redirect:/";
    
    }
    

}
