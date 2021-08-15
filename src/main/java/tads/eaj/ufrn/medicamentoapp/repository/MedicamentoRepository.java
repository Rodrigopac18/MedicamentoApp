package tads.eaj.ufrn.medicamentoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tads.eaj.ufrn.medicamentoapp.model.Medicamento;



public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {


}
