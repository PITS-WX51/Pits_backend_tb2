package pe.edu.upc.Pits.domain.service;

import  pe.edu.upc.Pits.domain.model.entity.Mechanic;

import java.util.List;
import java.util.Optional;


public interface MechanicService {

    List<Mechanic> fetchAll();
    Optional<Mechanic> fetchById(Integer id);
    Mechanic save(Mechanic mechanic);
    Mechanic update(Mechanic mechanic);
    boolean deleteById(Integer id);
}
