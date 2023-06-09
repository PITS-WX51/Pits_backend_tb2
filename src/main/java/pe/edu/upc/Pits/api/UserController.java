package pe.edu.upc.Pits.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Pits.domain.model.entity.User;
import pe.edu.upc.Pits.domain.service.UserService;
import pe.edu.upc.Pits.mapping.UserMapper;
import pe.edu.upc.Pits.resource.CreateUserResource;
import pe.edu.upc.Pits.resource.UserResource;
import pe.edu.upc.Pits.resource.UpdateUserResource;

import java.util.List;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
	private final UserService userService;
	private final UserMapper mapper;
	
	@PostMapping
	public UserResource save(@RequestBody CreateUserResource resource) {
		return mapper.toResource( userService.save( mapper.toModel(resource) ) );
	}
	
	@GetMapping
	public List<User> fetchAll() {
		return userService.fetchAll();
	}
	
	@GetMapping("{id}")
	public UserResource fetchId(@PathVariable Integer id) {
		return this.mapper.toResource(userService.fetchById(id).get());
	}
	
	@PutMapping("{id}")
	public ResponseEntity<UserResource> update(@PathVariable Integer id,
																								@RequestBody UpdateUserResource resource) {
		if (id.equals(resource.getId())) {
			UserResource userResource = mapper.toResource(
					userService.update( mapper.toModel(resource) ) );
			return new ResponseEntity<>(userResource, HttpStatus.OK);
		} else {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		if (userService.deleteById(id)) {
			return ResponseEntity.ok().build(); // Devolver de forma directa - lambda
			//return new ResponseEntity<>(HttpStatus.OK); // Devolución con instanciación
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
