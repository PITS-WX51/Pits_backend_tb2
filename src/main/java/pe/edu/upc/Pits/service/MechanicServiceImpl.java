package pe.edu.upc.Pits.service;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.Pits.domain.model.entity.Mechanic;
import pe.edu.upc.Pits.domain.persistence.MechanicRepository;
import pe.edu.upc.Pits.domain.service.MechanicService;
import pe.edu.upc.Pits.shared.Constant;
import pe.edu.upc.Pits.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Pits.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MechanicServiceImpl implements MechanicService {

    @Autowired
    private MechanicRepository mechanicRepository;

    @Autowired
    private Validator validator;

    @Transactional(readOnly = true)
    @Override
    public List<Mechanic> fetchAll(){return mechanicRepository.findAll();}

    @Transactional(readOnly = true)
    @Override
    public Optional<Mechanic> fetchById(Integer id){
        if (mechanicRepository.existsById(id)){
            return mechanicRepository.findById(id);
        } else {
            throw new ResourceNotFoundException("Mechanic",id);
        }
    }

    @Transactional
    @Override
    public Mechanic save(Mechanic mechanic){
        Set<ConstraintViolation<Mechanic>> violations = validator.validate(mechanic);
        if (!violations.isEmpty()){
            throw new ResourceValidationException(Constant.MECHANIC_ENTITY, violations);
        }
        return  mechanicRepository.save(mechanic);
    }

    @Transactional
    @Override
    public Mechanic update(Mechanic mechanic) {
        return mechanicRepository.save(mechanic);
    }

    @Transactional
    @Override
    public boolean deleteById(Integer id) {
        if (mechanicRepository.existsById(id)) {
            mechanicRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
