package pe.edu.upc.Pits.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.Pits.domain.model.entity.Brand;
import pe.edu.upc.Pits.resource.BrandResource;
import pe.edu.upc.Pits.resource.CreateBrandResource;
import pe.edu.upc.Pits.resource.UpdateBrandResource;
import pe.edu.upc.Pits.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class BrandMapper implements Serializable {
	
	@Autowired
	EnhancedModelMapper mapper;
	
	public Brand toModel(CreateBrandResource resource) { return this.mapper.map(resource, Brand.class);
	}
	public Brand toModel(UpdateBrandResource resource) {
		return this.mapper.map(resource, Brand.class);
	}
	public BrandResource toResource(Brand brand) {
		return this.mapper.map(brand, BrandResource.class);
	}
	
}
