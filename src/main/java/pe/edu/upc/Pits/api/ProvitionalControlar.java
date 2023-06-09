package pe.edu.upc.Pits.api;

import lombok.AllArgsConstructor;
import pe.edu.upc.Pits.domain.service.UserService;

// 3. Lombook
@AllArgsConstructor
public class ProvitionalControlar {
	// 2. @Autowired // @Inject
	private final UserService userService;
	
	// 1. Constructor  -> final
    /*public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }*/
}
