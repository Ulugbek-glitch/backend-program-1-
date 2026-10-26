package me.ugk.springdeveloper.repository;

import me.ugk.springdeveloper.entity.Member; // Added Member import
import org.springframework.data.jpa.repository.JpaRepository; // Added JpaRepository import

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // findALl() : select * from member;
    // findById() : select * from member where id = ?
    // deleteAll() : delete from member;
    // deleteById() : delete from member where id = ?
    //save() : insert into member(id, name) values (?, ?), update member set ... where id = ?

    // findByName : select * from member where name = ?
    public Optional<Member> findByName(String name);

    //findByEmail : select * from member where email = ?

    //findByNameAndEmail() : select * from member where name = ? and email = ?
}