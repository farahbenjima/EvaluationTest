package com.evaluation.springboot.service;

import com.evaluation.springboot.model.BlogPost;
import com.evaluation.springboot.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class BlogServiceImp implements BlogService {
private PostRepository postRepository;
    @Override
    public BlogPost createBlog(BlogPost blog) {
    return postRepository.save(blog);

    }

    @Override
    public BlogPost getBlogById(Long blogId) {
        return postRepository.findById(blogId).get();
    }

    @Override
    public List<BlogPost> getAllBlogs() {
        return postRepository.findAll();
    }

    @Override
    public BlogPost updateBlog(BlogPost blogPost) {
        BlogPost existingBlogPost = postRepository.findById(blogPost.getId()).get();
        existingBlogPost.setId(blogPost.getId());
        existingBlogPost.setCategory(blogPost.getCategory());
        existingBlogPost.setTitle(blogPost.getTitle());
        existingBlogPost.setContents(blogPost.getContents());

        BlogPost updatedBlog = postRepository.save(existingBlogPost);
        return updatedBlog;
    }

    @Override
    public void deleteBlog(Long blogId) {
        postRepository.deleteById(blogId);

    }

    @Override
    public void deleteAllBlog() {
        postRepository.deleteAll();


    }
}
