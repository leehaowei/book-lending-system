package com.leehaowei.booklendingsystem.appuser;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "app_user")
public class AppUser {

    @Id
    @SequenceGenerator(
            name = "user_id_sequence",
            sequenceName = "user_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Integer user_id;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String user_name;

    @Column(nullable = false)
    private LocalDateTime registration_time;

    private LocalDateTime lastLogin_time;

    // Constructors
    public AppUser() {
    }

//    public AppUser(String phone_number, String password, String user_name) {
//        this.phone_number = phone_number;
//        this.password = password;
//        this.user_name = user_name;
//    }

    public AppUser(String phone_number,
                   String password,
                   String user_name,
                   LocalDateTime registration_time,
                   LocalDateTime lastLogin_time) {

        this.phone_number = phone_number;
        this.password = password;
        this.user_name = user_name;
        this.registration_time = registration_time;
        this.lastLogin_time = lastLogin_time;
    }
}

