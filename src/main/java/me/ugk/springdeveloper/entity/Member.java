package me.ugk.springdeveloper.entity; // Fixed package

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id // Fixed capitalization
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Changed to wrapper class Long

    @Column(nullable = false)
    private String name;

    private String email;

    public Member(String name, String email) {
        this.name = name;
        this.email = email;
    }
}