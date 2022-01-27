package com.blog.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.blog.springmvc.entity.Comment;
import com.blog.springmvc.entity.Post;

@Repository
@Transactional
public interface CommentRepository extends JpaRepository<Comment, Long> {

	@Query("SELECT c FROM Comment c WHERE c.post.id =?1 ")
	List<Comment> getCommentsByPost(long id);
	
	Iterable<Comment> findAllByPost(Post post);
}
