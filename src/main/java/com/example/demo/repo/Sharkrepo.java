package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.entity.Shark;

public interface Sharkrepo extends JpaRepository<Shark, Long> {

}
