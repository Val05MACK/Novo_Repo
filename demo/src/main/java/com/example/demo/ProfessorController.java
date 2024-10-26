package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ProfessorController {
    private List<Professor> professores;

    public ProfessorController() {
        this.professores = new ArrayList<>();
        professores.add(new Professor(1, "Ana", 111, "Security"));
        professores.add(new Professor(2, "Alana", 222, "Science Data"));
        professores.add(new Professor(3, "Ana Livia", 333, "Security"));
    }

    @GetMapping("/professor")
    public Iterable<Professor> getProfessores() {
        return this.professores;
    }

    @GetMapping("/professor/{id}")
    public Optional<Professor> getProfessor(@PathVariable long id) {
        for (Professor p : professores) {
            if (p.getId() == id) {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/professor")
    public Professor createProfessor(@RequestBody Professor p) {
        long maxId = 1;
        for (Professor prof : professores) {
            if (prof.getId() > maxId) {
                maxId = prof.getId();
            }
        }
        p.setId(maxId + 1);
        professores.add(p);
        return p;
    }

    @PutMapping("/professor/{professorId}")
    public Optional<Professor> updateProfessor(@RequestBody Professor professorRequest, @PathVariable long professorId) {
        Optional<Professor> opt = this.getProfessor(professorId);
        if (opt.isPresent()) {
            Professor professor = opt.get();
            professor.setNome(professorRequest.getNome());
            professor.setMatricula(professorRequest.getMatricula());
            professor.setArea(professorRequest.getArea());
        }
        return opt;
    }

    @DeleteMapping("/professor/{id}")
    public void deleteProfessor(@PathVariable long id) {
        professores.removeIf(p -> p.getId() == id);
    }
}
