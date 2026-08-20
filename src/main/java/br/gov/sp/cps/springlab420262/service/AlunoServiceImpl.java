package br.gov.sp.cps.springlab420262.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.gov.sp.cps.springlab420262.entity.Aluno;
import br.gov.sp.cps.springlab420262.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

    private final AlunoRepository repo;

    public AlunoServiceImpl(AlunoRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public Aluno cadastrar(Aluno aluno) {
        if (aluno == null || 
            aluno.getNome() == null || 
            aluno.getNome().isBlank() ||
            aluno.getRa() == null
        ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O aluno não pode ser nulo.");
        }
        return repo.save(aluno);
    }

    @Override
    public Aluno buscarPorId(Long id) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID não pode ser nulo.");
        }
        return repo.findById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado.")
        );
    }

    @Override
    public List<Aluno> buscarTodos() {
        return repo.findAll();
    }
    
    

}
