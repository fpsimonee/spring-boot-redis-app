package br.com.spring.cache.demo.controller;

import br.com.spring.cache.demo.exception.PostNotFoundException;
import br.com.spring.cache.demo.model.Post;
import br.com.spring.cache.demo.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    private static final Logger log = LoggerFactory.getLogger(PostController.class);

    @Autowired
    private PostService postService;

    @Cacheable(value = "post-single", key = "#id")
    @GetMapping("/{id}")
    public Post getPostById(@PathVariable String id) throws PostNotFoundException, IOException {
        log.info("search for post id: "+id);
        return postService.getPostById(id);
    }

    @CacheEvict(value = "post-single", key = "#id")
    @DeleteMapping("/{id}")
    public Post deletePostById(@PathVariable String id) throws PostNotFoundException, IOException {
        return postService.deletePostById(id);
    }

    @CachePut(value = "post-single", key = "#id")
    @PutMapping("/{id}")
    public Post updatePostById(@PathVariable String id, @RequestBody Post body) throws PostNotFoundException, IOException {
        return postService.updateById(body, id);
    }

//    @CachePut(value = "post-single", key = "#posts.getId()")
    @PostMapping("/")
    public Post createNewPost(@RequestBody Post body) throws PostNotFoundException, IOException {
        return postService.createNewPost(body);
    }
}
