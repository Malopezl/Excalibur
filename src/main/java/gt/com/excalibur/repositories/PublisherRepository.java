/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.repositories;

import gt.com.excalibur.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author malopez
 */
public interface PublisherRepository extends JpaRepository<Publisher, Integer>{

}
