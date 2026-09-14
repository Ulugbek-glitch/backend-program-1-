package me.ugk.springdeveloper.repository;

import me.ugk.springdeveloper.entity.Member; // Added Member import
import org.springframework.data.jpa.repository.JpaRepository; // Added JpaRepository import

public interface MemberRepository extends JpaRepository<Member, Long> {
}