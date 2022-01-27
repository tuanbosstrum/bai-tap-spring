package com.blog.springmvc.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.springmvc.entity.Post;

@Repository
@Transactional
public interface PostRepository extends JpaRepository<Post, Long> {

}
