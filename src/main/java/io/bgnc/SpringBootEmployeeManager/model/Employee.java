package io.bgnc.SpringBootEmployeeManager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;

    /**
     * job title means that person role such as web developer ,
     * backend developer and devops developer ...
     *
     */
    private String jobTitle;

    private String email;

    /**
     * Employee profile photo absolute path in database
     */
    private String imageUrl;

    private String phone;


    @Column(nullable = false,updatable = false)
    private String employeeCode;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", phone='" + phone + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                '}';
    }
}
