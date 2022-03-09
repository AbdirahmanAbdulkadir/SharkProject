package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import com.example.demo.entity.Shark;

import com.example.demo.repo.Sharkrepo;

@Service
public class SharkService implements ServiceMethods<Shark> {

	private Sharkrepo repo;
	
	public SharkService(Sharkrepo repo) {
		this.repo=repo;
	}
	
	@Override
	public Shark create(Shark shark) {
		return this.repo.save(shark);
	}

	@Override
	public List<Shark> readAll() {
	return this.repo.findAll();
	}

	@Override
	public Shark readById(long id) {
		Optional<Shark> getShark = this.repo.findById(id);
		if(getShark.isPresent()) {
			return getShark.get();
		}
		return null;
	}
	

	@Override
	public Shark update(long id, Shark shark) {
		Optional<Shark> existingShark = this.repo.findById(id);
		if(existingShark.isPresent()) {
			Shark exists = existingShark.get();
			exists.setAge(shark.getAge());
			exists.setGender(shark.getGender());
			exists.setHabitat(shark.getHabitat());
			exists.setName(shark.getName());
			return this.repo.saveAndFlush(exists);
			}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
