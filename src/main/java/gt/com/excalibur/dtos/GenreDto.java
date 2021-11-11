/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.dtos;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;

/**
 *
 * @author malopez
 */
@Data
public class GenreDto {

    private Integer id;
    private String name;
    private Set<VideogameDto> videogames = new HashSet<>();

}
