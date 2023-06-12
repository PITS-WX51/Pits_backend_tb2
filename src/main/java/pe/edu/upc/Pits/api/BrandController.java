package pe.edu.upc.Pits.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Pits.domain.model.entity.Brand;
import pe.edu.upc.Pits.domain.service.BrandService;
import pe.edu.upc.Pits.mapping.BrandMapper;
import pe.edu.upc.Pits.resource.CreateBrandResource;
import pe.edu.upc.Pits.resource.BrandResource;
import pe.edu.upc.Pits.resource.UpdateBrandResource;

import java.util.List;

@RestController
@RequestMapping("brands")
@AllArgsConstructor
public class BrandController {
	private final BrandService brandService;
	private final BrandMapper mapper;
	
	@PostMapping
	public BrandResource save(@RequestBody CreateBrandResource resource) {
		return mapper.toResource( brandService.save( mapper.toModel(resource) ) );
	}
	
	@GetMapping
	public List<Brand> fetchAll() {
		return brandService.fetchAll();
	}
	
	@GetMapping("{id}")
	public BrandResource fetchId(@PathVariable Integer id) {
		return this.mapper.toResource(brandService.fetchById(id).get());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<BrandResource> update(@PathVariable Integer id,
																							@RequestBody UpdateBrandResource resource) {
		if (id.equals(resource.getId())) {
			BrandResource brandResource = mapper.toResource(
				brandService.update( mapper.toModel(resource) ) );
			return new ResponseEntity<>(brandResource, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		if (brandService.deleteById(id)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
