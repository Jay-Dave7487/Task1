package com.blog.bloggingplatform.repository;

import com.blog.bloggingplatform.model.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {
}
