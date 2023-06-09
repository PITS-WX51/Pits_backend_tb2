package pe.edu.upc.Pits.mapping;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upc.Pits.domain.model.entity.Mechanic;
import pe.edu.upc.Pits.resource.CreateMechanicResource;
import pe.edu.upc.Pits.resource.MechanicResource;
import pe.edu.upc.Pits.resource.UpdateMechanicResource;
import pe.edu.upc.Pits.shared.mapping.EnhancedModelMapper;

import java.io.Serializable;

public class MechanicMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public Mechanic toModel(CreateMechanicResource resource) { return this.mapper.map(resource, Mechanic.class);
    }
    public Mechanic toModel(UpdateMechanicResource resource) {
        return this.mapper.map(resource, Mechanic.class);
    }

    public MechanicResource toResource(Mechanic mechanic) {
        return this.mapper.map(mechanic, MechanicResource.class);
    }


}
