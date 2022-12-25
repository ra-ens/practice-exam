package com.abdelhakimrafik.violationservice.commands.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
@Data @Builder
@AllArgsConstructor @NoArgsConstructor
public class Owner {
    @Id
    private String id;
    private String name;
    private Date birthday;
    private String email;

    @OneToMany(mappedBy = "owner")
    private List<Vehicle> vehicles;
}
