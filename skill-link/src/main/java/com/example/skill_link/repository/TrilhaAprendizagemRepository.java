package com.example.skill_link.repository;

import com.example.skill_link.model.TrilhaAprendizagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrilhaAprendizagemRepository extends JpaRepository<TrilhaAprendizagem, Long> { }
