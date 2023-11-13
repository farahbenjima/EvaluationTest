package com.evaluation.springboot.service;

import com.evaluation.springboot.model.BlogPost;

import java.util.List;

public interface BlogService {
    BlogPost createBlog(BlogPost blog);

    BlogPost getBlogById(Long blogId);

    List<BlogPost> getAllBlogs();

    BlogPost updateBlog(BlogPost blogPost);

    void deleteBlog(Long blogId);
    void deleteAllBlog();
}
