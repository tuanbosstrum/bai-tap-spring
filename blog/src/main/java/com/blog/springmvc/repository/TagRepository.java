package com.blog.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.springmvc.entity.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

}
