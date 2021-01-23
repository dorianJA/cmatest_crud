package ru.cma.juntest.cruddemo.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


import java.sql.Date;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "The first name cannot be empty")
    private String firstName;
    @NotBlank(message = "The last name cannot be empty")
    private String lastName;
    @NotBlank(message = "The middle name cannot be empty")
    private String middleName;
    private Date birthday_date;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "group_id")
    private Group group;

    public Student(String firstName, String lastName, String middleName, Date birthday_date, Group group) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday_date = birthday_date;
        this.group = group;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", birthday_date=" + birthday_date +
                ", group=" + group +
                '}';
    }
}
