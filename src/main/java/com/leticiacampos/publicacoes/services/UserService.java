package com.leticiacampos.publicacoes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leticiacampos.publicacoes.domain.User;
import com.leticiacampos.publicacoes.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> findAll(){
		
		return userRepository.findAll();
	}
}