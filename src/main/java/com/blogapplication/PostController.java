package com.blogapplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins = "http://localhost:5173")
public class PostController {
@Autowired
private final PostService postService;
public PostController (PostService postService) {
	this.postService=postService;

}
@GetMapping
public List<Post> getAllPosts(){
	return postService.getAllPosts();
}
@GetMapping("/{id}")
public ResponseEntity<Post> getPostById(@PathVariable Long id){
return postService.getPostById(id)
		.map(ResponseEntity::ok)
		.orElse(ResponseEntity.notFound().build());}
@PostMapping
public Post createPost(@RequestBody Post post) {
	return postService.createPost(post);
}
@PutMapping("/{id}")
public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post){
	try {
		Post updated = postService.updatePost(id, post);
		return ResponseEntity.ok(updated);
	} catch (RuntimeException e) {
		return ResponseEntity.notFound().build();
	}
}
@DeleteMapping("/{id}")
public ResponseEntity<Void> deletePost(@PathVariable Long id){
	postService.deletePost(id);
	return ResponseEntity.noContent().build();
}
    }

