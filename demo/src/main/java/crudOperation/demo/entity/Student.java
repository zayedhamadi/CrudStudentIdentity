package crudOperation.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data

public class Student {
    @Id
    private int rollNumber;
    private String name;
    private String adresse;

}
