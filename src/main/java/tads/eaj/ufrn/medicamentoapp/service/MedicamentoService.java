package tads.eaj.ufrn.medicamentoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tads.eaj.ufrn.medicamentoapp.model.Medicamento;
import tads.eaj.ufrn.medicamentoapp.repository.MedicamentoRepository;

import java.util.List;

@Service
public class MedicamentoService {

    MedicamentoRepository repository;

    @Autowired
    public void setRepository(MedicamentoRepository repository) {

        this.repository = repository;
    }

    public List<Medicamento> findAll() {

        return repository.findAll();
    }

    public void save(Medicamento m) {
        repository.save(m);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Medicamento findById(Long id){
        return repository.getById(id);
    }
}