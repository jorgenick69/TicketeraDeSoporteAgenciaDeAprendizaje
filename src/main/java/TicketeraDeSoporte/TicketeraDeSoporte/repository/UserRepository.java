
package TicketeraDeSoporte.TicketeraDeSoporte.repository;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jorge Dominguez
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>{
    
}
