package com.leticiacampos.publicacoes.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leticiacampos.publicacoes.domain.User;
import com.leticiacampos.publicacoes.dto.UserDTO;
import com.leticiacampos.publicacoes.repositories.UserRepository;
import com.leticiacampos.publicacoes.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<UserDTO> findAll(){
		
		List<User> users = userRepository.findAll();
		List<UserDTO> usersDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return usersDTO;
	}
	
	public UserDTO findById(String id) {
		
		Optional<User> user = userRepository.findById(id);
		
		if (user.isEmpty()) {
			
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		
		return new UserDTO(user.get());
	}
}