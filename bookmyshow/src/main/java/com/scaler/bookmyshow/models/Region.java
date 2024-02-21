package com.scaler.bookmyshow.models;


import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Region extends BaseModel{
    private String name;
    @OneToMany
    private List<Theatre> theatreList;

    //Region Movie
    //1 : M
    //M : 1
//    @ManyToMany
//    private List<Movie> movies;
}
