package com.example.projetoescola.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.projetoescola.models.Curso;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class CursoRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Curso salvar (Curso curso) {
        return entityManager.merge(curso);
    }

    public List<Curso> obterTodos() {
        return entityManager
        .createQuery("from Curso", Curso.class).getResultList();
    }
}
