/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.controllers;

import gt.com.excalibur.dtos.VideogameDto;
import gt.com.excalibur.models.Videogame;
import gt.com.excalibur.services.VideogameService;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author malopez
 */
@RestController
@RequestMapping(value = "api/videogame")
public class VideogameController {

    @Autowired
    private VideogameService videogameService;

    @GetMapping("")
    List<Videogame> getVideogameList() {
        return videogameService.getAll();
    }

    @GetMapping("/{id}")
    Videogame getVideogame(@PathVariable Integer id) {
        return videogameService.getVideogameById(id);
    }

    @GetMapping("/publisher/{id}")
    Set<Videogame> getVideogamesByPublisher(@PathVariable Integer id) {
        return videogameService.getVideogamesByPublisher(id);
    }

    @PostMapping("")
    Videogame createVideogame(@RequestBody VideogameDto videogame) {
        return videogameService.createVideogame(videogame);
    }

    @PutMapping("/{id}")
    Videogame updateVideogame(@PathVariable Integer id, @RequestBody VideogameDto videogame) {
        return videogameService.updateVideogame(videogame, id);
    }

    @DeleteMapping("/{id}")
    void deleteGenre(@PathVariable Integer id) {
        videogameService.deleteVideogame(id);
    }

}
