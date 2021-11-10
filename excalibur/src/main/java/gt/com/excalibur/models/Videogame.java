/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.com.excalibur.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author malopez
 */
@Entity
@Data
@Table(name = "videogame")
public class Videogame implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "release")
    private String releaseDate;

    @Column(name = "idpublisher")
    private Integer idpublisher;

    @ManyToMany(cascade = { CascadeType.MERGE })
    @JoinTable(name = "videogameGenre", joinColumns = { @JoinColumn(name = "idvideogame", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "idgenre", referencedColumnName = "id") })
    private Set<Genre> genres = new HashSet<>();

}
