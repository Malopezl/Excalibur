/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.repositories;

import gt.com.excalibur.models.Genre;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author malopez
 */
@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer>{

    @Query(value = "SELECT idvideogame FROM videogameGenre WHERE idgenre = :idgenre", nativeQuery = true)
    ArrayList<Integer> getVideogameId(@Param("idgenre") Integer idgenre);

}
