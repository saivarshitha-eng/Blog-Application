package com.blogapplication;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="posts")
public class Post {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable =false)
private String title;
@Column(columnDefinition="TEXT")
private String content;
private String author;
private LocalDateTime createdAt;
public Post() {}

public Post(Long id, String title, String content, String author, LocalDateTime createdAt) {
	super();
	this.id = id;
	this.title = title;
	this.content = content;
	this.author = author;
	this.createdAt = createdAt;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getAuthor() {
	return author;  
}
public void setAuthor(String author) {
	this.author = author;
}
public LocalDateTime getCreatedAt() {
	return createdAt;
}
public void setCreatedAt(LocalDateTime createdAt) {
	this.createdAt = createdAt;
}

@Override
public String toString() {
	return "Post [id=" + id + ", title=" + title + ", content=" + content + ", author=" + author + ", createdAt="
			+ createdAt + "]";
}
 



}
