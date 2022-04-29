
package TicketeraDeSoporte.TicketeraDeSoporte.repository;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.UserNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jorge Dominguez
 */
@Repository
public interface UserRepository extends JpaRepository<UserNew,Long>{
    
     public UserNew findByUsername(String username);
    public UserNew findByEmail(String mail);
}
