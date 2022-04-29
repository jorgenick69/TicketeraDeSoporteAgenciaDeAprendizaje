package TicketeraDeSoporte.TicketeraDeSoporte;

import TicketeraDeSoporte.TicketeraDeSoporte.serviceIMPL.UserServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class TicketeraDeSoporteApplication extends WebSecurityConfigurerAdapter{

   @Autowired
   private UserServiceIMPL userServiceIMPL;

    public static void main(String[] args) {
        SpringApplication.run(TicketeraDeSoporteApplication.class, args);
    }
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)throws Exception{
    auth.userDetailsService(userServiceIMPL).passwordEncoder(new BCryptPasswordEncoder());
    }
    

}
