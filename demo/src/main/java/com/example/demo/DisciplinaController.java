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
public class DisciplinaController {
    private List<Disciplina> disciplinas;

    public DisciplinaController() {
        this.disciplinas = new ArrayList<>();
        disciplinas.add(new Disciplina(1, "Matemática", "MAT", "Engenharia", 1));
        disciplinas.add(new Disciplina(2, "Física", "FIS", "Engenharia", 1));
        disciplinas.add(new Disciplina(3, "Química", "QUI", "Engenharia", 2));
    }

    
    @GetMapping("/disciplinas")
    public Iterable<Disciplina> getDisciplinas() {
        return this.disciplinas;
    }

    //  obter uma disciplina específica pelo ID
    @GetMapping("/disciplinas/{id}")
    public Optional<Disciplina> getDisciplina(@PathVariable int id) {
        for (Disciplina d : disciplinas) {
            if (d.getId() == id) {
                return Optional.of(d);
            }
        }
        return Optional.empty();
    }

    
    @PostMapping("/disciplinas")
    public Disciplina createDisciplina(@RequestBody Disciplina d) {
        int maxId = 0;
        for (Disciplina disciplina : disciplinas) {
            if (disciplina.getId() > maxId) {
                maxId = disciplina.getId();
            }
        }
        d.setId(maxId + 1);
        disciplinas.add(d);
        return d;
    }

    
    @PutMapping("/disciplinas/{id}")
    public Optional<Disciplina> updateDisciplina(@RequestBody Disciplina disciplinaRequest, @PathVariable int id) {
        Optional<Disciplina> opt = this.getDisciplina(id);
        if (opt.isPresent()) {
            Disciplina disciplina = opt.get();
            disciplina.setNome(disciplinaRequest.getNome());
            disciplina.setSigla(disciplinaRequest.getSigla());
            disciplina.setCurso(disciplinaRequest.getCurso());
            disciplina.setSemestre(disciplinaRequest.getSemestre());
        }
        return opt;
    }

    
    @DeleteMapping("/disciplinas/{id}")
    public void deleteDisciplina(@PathVariable int id) {
        disciplinas.removeIf(d -> d.getId() == id);
    }
}
