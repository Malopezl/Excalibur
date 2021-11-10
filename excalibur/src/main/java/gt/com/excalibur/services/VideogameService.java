/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.services;

import gt.com.excalibur.models.Videogame;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author malopez
 */
public interface VideogameService {

    public ArrayList<Videogame> getAll();

    public Videogame getVideogameById(Integer id);

    public Set<Videogame> getVideogamesByGenre(Integer id);

    public Set<Videogame> getVideogamesByPublisher(Integer id);

    public Videogame createVideogame(Videogame videogame);

    public Videogame updateVideogame(Videogame videogame, Integer id);

    public void deleteVideogame(Integer id);

}
