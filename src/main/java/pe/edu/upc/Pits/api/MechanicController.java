package pe.edu.upc.Pits.api;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.Pits.domain.model.entity.Mechanic;
import pe.edu.upc.Pits.domain.service.MechanicService;
import pe.edu.upc.Pits.mapping.MechanicMapper;
import pe.edu.upc.Pits.resource.CreateMechanicResource;
import pe.edu.upc.Pits.resource.MechanicResource;
import pe.edu.upc.Pits.resource.UpdateMechanicResource;

import java.util.List;

@RestController
@RequestMapping("mechanics")
@AllArgsConstructor
public class MechanicController {
    private final MechanicService mechanicService;
    private final MechanicMapper mapper;

    @PostMapping
    public MechanicResource save(@RequestBody CreateMechanicResource resource) {
        return mapper.toResource( mechanicService.save( mapper.toModel(resource) ) );
    }

    @GetMapping
    public List<Mechanic> fetchAll() {
        return mechanicService.fetchAll();
    }

    @GetMapping("{id}")
    public MechanicResource fetchId(@PathVariable Integer id) {
        return this.mapper.toResource(mechanicService.fetchById(id).get());
    }

    @PutMapping("{id}")
    public ResponseEntity<MechanicResource> update(@PathVariable Integer id,
                                                   @RequestBody UpdateMechanicResource resource) {
        if (id.equals(resource.getId())) {
            MechanicResource mechanicResource = mapper.toResource(
                    mechanicService.update( mapper.toModel(resource) ) );
            return new ResponseEntity<>(mechanicResource, HttpStatus.OK);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        if (mechanicService.deleteById(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
