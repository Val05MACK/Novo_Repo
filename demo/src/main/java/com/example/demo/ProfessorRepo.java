package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepo extends CrudRepository<Professor, Long> {
	Iterable<Professor> findByDisciplinaId(int DisciplinaId);
}