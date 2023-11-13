package com.evaluation.springboot.controller;

import com.evaluation.springboot.model.BlogPost;
import com.evaluation.springboot.service.BlogService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/posts")
public class BlogController {
    private BlogService blogService;
    @PostMapping
    public ResponseEntity<BlogPost> createBlog(@RequestBody BlogPost post)

    {
        BlogPost postCreated = blogService.createBlog(post);
        return new ResponseEntity<>(postCreated, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<BlogPost> getBlog(@PathVariable("id") Long id){
        BlogPost blogById= blogService.getBlogById(id);
        return new ResponseEntity<>(blogById,HttpStatus.OK);


    }
    @GetMapping
    public ResponseEntity<List<BlogPost>> getAll(){
        List<BlogPost> allBlogs = blogService.getAllBlogs();
        return new ResponseEntity<>(allBlogs,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<BlogPost> update( @PathVariable("id") Long id,@RequestBody BlogPost blog){
        blog.setId(id);

        BlogPost blogPost = blogService.updateBlog(blog);
        return new ResponseEntity<>(blogPost,HttpStatus.OK);

}
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable ("id") Long id){
        blogService.deleteBlog(id);
        return new ResponseEntity<>("blog deleted",HttpStatus.OK);

    }
    @DeleteMapping
    public ResponseEntity<String> deleteAll(){
        blogService.deleteAllBlog();
        return new ResponseEntity<>("all blogs deleted",HttpStatus.OK);

    }

}
