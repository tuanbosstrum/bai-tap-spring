package edu.phuxuan.k17.spring.jpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import edu.phuxuan.k17.spring.jpa.entity.Hobby;

public interface HobbyRepository extends JpaRepository<Hobby, Integer> {
}
