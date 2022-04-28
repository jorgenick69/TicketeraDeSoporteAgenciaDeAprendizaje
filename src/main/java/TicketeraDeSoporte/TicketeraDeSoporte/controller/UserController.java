
package TicketeraDeSoporte.TicketeraDeSoporte.controller;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.User;
import TicketeraDeSoporte.TicketeraDeSoporte.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/user")
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
    public String user(Model model) {
        var users = userService.findAllUser();
        for (User user : users) {
            System.out.println(user.getName());
        }
        model.addAttribute("users", users);
        return null;
    }
    @GetMapping("/add")
    public String add(User user) {
              
        return "modify-user";
    }
    @PostMapping("/save")
    public String save(User user) {
       userService.save(user);
        
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String edit(User user, Model model){
        user=userService.findUser(user);
        model.addAttribute("user",user);
        return "modify-user";
    
    }
    @GetMapping("/delete/{id}")
    public String delete(User user){
       userService.delete(user);
        
        return "redirect:/";
    
    }
    

}
