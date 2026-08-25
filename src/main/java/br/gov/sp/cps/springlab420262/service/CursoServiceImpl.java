package br.gov.sp.cps.springlab420262.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springlab420262.entity.Curso;
import br.gov.sp.cps.springlab420262.repository.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService {

    private final CursoRepository repo;

    public CursoServiceImpl(CursoRepository repo) {
        this.repo = repo;
    }
    
    @Override
    public Curso cadastrar(Curso curso) {
        if (curso == null || 
            curso.getNome() == null || 
            curso.getNome().isBlank() ||
            curso.getSigla() == null ||
            curso.getSigla().isBlank()
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O curso não pode ser nulo.");
        }
        return repo.save(curso);
    }

    @Override
    public Curso buscarPorId(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID não pode ser nulo.");
        }
        Optional<Curso> curso = repo.findById(id);
        if (curso.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado.");
        }
        return curso.get();
    }

    @Override
    public List<Curso> buscarTodos() {
        // Implementação do método de busca de todos os cursos
        return repo.findAll();
    }
    
}
