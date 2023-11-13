package com.evaluation.springboot.repository;

import com.evaluation.springboot.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<BlogPost, Long> {
}
