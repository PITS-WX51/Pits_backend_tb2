package pe.edu.upc.Pits.service.impl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.Pits.domain.model.entity.Brand;
import pe.edu.upc.Pits.domain.persistence.BrandRepository;
import pe.edu.upc.Pits.domain.service.BrandService;
import pe.edu.upc.Pits.shared.Constant;
import pe.edu.upc.Pits.shared.exception.ResourceNotFoundException;
import pe.edu.upc.Pits.shared.exception.ResourceValidationException;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandRepository brandRepository;
	
	@Autowired
	private Validator validator;
	
	@Transactional(readOnly = true)
	@Override
	public List<Brand> fetchAll(){return brandRepository.findAll();}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Brand> fetchById(Integer id){
		if (brandRepository.existsById(id)){
			return brandRepository.findById(id);
		} else {
			throw new ResourceNotFoundException("Brand",id);
		}
	}
	
	@Transactional
	@Override
	public Brand save(Brand brand){
		Set<ConstraintViolation<Brand>> violations = validator.validate(brand);
		if (!violations.isEmpty()){
			throw new ResourceValidationException(Constant.BRAND_ENTITY, violations);
		}
		return brandRepository.save(brand);
	}
	
	@Transactional
	@Override
	public Brand update(Brand brand) {
		return brandRepository.save(brand);
	}
	
	@Transactional
	@Override
	public boolean deleteById(Integer id) {
		if (brandRepository.existsById(id)) {
			brandRepository.deleteById(id);
			return true;
		}
		return false;
	}
	
}
