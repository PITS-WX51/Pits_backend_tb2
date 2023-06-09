package pe.edu.upc.Pits.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.Pits.domain.model.entity.User;
import pe.edu.upc.Pits.resource.CreateUserResource;
import pe.edu.upc.Pits.resource.UserResource;
import pe.edu.upc.Pits.resource.UpdateUserResource;
import pe.edu.upc.Pits.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class UserMapper implements Serializable {
	@Autowired
	EnhancedModelMapper mapper;
	
	public User toModel(CreateUserResource resource) {
		return this.mapper.map(resource, User.class);
	}
	public User toModel(UpdateUserResource resource) {
		return this.mapper.map(resource, User.class);
	}
	
	public UserResource toResource(User user) {
		return this.mapper.map(user, UserResource.class);
	}
	
}
