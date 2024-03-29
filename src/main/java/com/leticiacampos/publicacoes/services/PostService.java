package com.leticiacampos.publicacoes.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leticiacampos.publicacoes.domain.Post;
import com.leticiacampos.publicacoes.repositories.PostRepository;
import com.leticiacampos.publicacoes.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	public Post findById(String id) {
		
		Optional<Post> post = postRepository.findById(id);
		
		if (post.isEmpty()) {
			
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return post.get();
	}
	
	public List<Post> findByTitle(String title){
		return postRepository.findByTitle(title);
	}
	
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
	
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullSearch(text, minDate, maxDate);
	}
}