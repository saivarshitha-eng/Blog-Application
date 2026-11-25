package com.blogapplication;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
	public class PostService {
	@Autowired
	private final PostRepositary postRepositary;
	public PostService (PostRepositary postRepositary) {
	this.postRepositary= postRepositary;	
	}
	public List<Post> getAllPosts(){
		return postRepositary.findAll();
		
	}
	public Optional<Post> getPostById(Long id){
		return postRepositary.findById(id);
	}
	public Post createPost(Post post) {
		post.setCreatedAt(LocalDateTime.now());
		return postRepositary.save(post);
	}
	public Post updatePost(Long id,Post postDetails) {
		Post post=postRepositary.findById(id)
				.orElseThrow(() -> new RuntimeException("Post not found with id:" +id));
		post.setTitle(postDetails.getTitle());
		post.setContent(postDetails.getContent());
		post.setAuthor(postDetails.getAuthor());
		return postRepositary.save(post);
	}
	public void deletePost(Long id) {
		postRepositary.deleteById(id);
	}
	}

