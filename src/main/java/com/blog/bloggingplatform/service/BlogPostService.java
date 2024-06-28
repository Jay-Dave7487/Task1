package com.blog.bloggingplatform.service;

import com.blog.bloggingplatform.model.BlogPost;
import com.blog.bloggingplatform.repository.BlogPostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BlogPostService {
    @Autowired
    private BlogPostRepository blogPostRepository;

    public BlogPost createBlogPost(BlogPost blogPost) {
        blogPost.setCreatedAt(LocalDateTime.now());
        blogPost.setUpdatedAt(LocalDateTime.now());
        return blogPostRepository.save(blogPost);
    }

    public List<BlogPost> getAllBlogPosts() {
        return blogPostRepository.findAll();
    }

    public Optional<BlogPost> getBlogPostById(Long id) {
        return blogPostRepository.findById(id);
    }
    
    public BlogPost updateBlogPost(Long id, BlogPost updatedBlogPost) {
        Optional<BlogPost> existingBlogPostOpt = blogPostRepository.findById(id);
        if (existingBlogPostOpt.isPresent()) {
            BlogPost existingBlogPost = existingBlogPostOpt.get();
            
            updatedBlogPost.setCreatedAt(existingBlogPost.getCreatedAt());
            updatedBlogPost.setId(id);
            updatedBlogPost.setUpdatedAt(LocalDateTime.now());
            
            return blogPostRepository.save(updatedBlogPost);
        } else {
            throw new RuntimeException("Blog post not found");
        }
    }


    public void deleteBlogPost(Long id) {
        blogPostRepository.deleteById(id);
    }
}
