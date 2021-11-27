package com.example.demo.Specialties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path = "specialties")
public class SpecialtiesController {
    private SpecialtiesServies specialtiesServies;
@Autowired
    public  SpecialtiesController(SpecialtiesServies specialtiesServies){ this.specialtiesServies=specialtiesServies;}
    @GetMapping
    private List<Specialties> getSpecialtiess(){return specialtiesServies.getSpecialtiess();}
    @GetMapping("/{id}")
    public Specialties getSpecialties(@PathVariable String id){
        return specialtiesServies.getSpecialties(id);
    }
    @PostMapping
    public Specialties createSpecialties(@RequestBody Specialties specialties){return specialtiesServies.createSpecialties(specialties);}

    @DeleteMapping("/{id}")
    public void deleteSpecialties(@PathVariable String id){specialtiesServies.deleteSpecialties(id);}

    @PutMapping("/{id}")
    public void updateSpecialties(@PathVariable String id, @RequestBody Specialties data){
        specialtiesServies.updateSpecialties(id,data);
    }
}
