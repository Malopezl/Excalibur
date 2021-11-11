/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.dtos;

import java.util.ArrayList;
import lombok.Data;

/**
 *
 * @author malopez
 */
@Data
public class PublisherDto {

    private Integer id;
    private String name;
    ArrayList<Integer> videogames = new ArrayList();

}
