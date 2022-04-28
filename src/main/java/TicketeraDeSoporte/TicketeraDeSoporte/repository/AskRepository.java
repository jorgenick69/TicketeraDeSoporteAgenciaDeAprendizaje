/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package TicketeraDeSoporte.TicketeraDeSoporte.repository;

import TicketeraDeSoporte.TicketeraDeSoporte.entity.Ask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jorge Dominguez
 */
@Repository
public interface AskRepository extends JpaRepository<Ask,Long>{
    
}
