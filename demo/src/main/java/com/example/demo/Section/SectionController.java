package com.example.demo.Section;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="section")
public class SectionController {
    private final SectionServies sectionServies;
@Autowired
    public SectionController(SectionServies sectionServies) {
        this.sectionServies = sectionServies;
    }
    @GetMapping

    public List<Section> getSections() {
        return sectionServies.getSections();
    }

    @GetMapping("/{id}")

    public Section getSection(@PathVariable String id){
        return sectionServies.getSection(id);

    }
    @PostMapping
    public Section createSection(@RequestBody Section section){
        return sectionServies.createSection(section);
    }


    @DeleteMapping("/{id}")

    public void deleteService(@PathVariable String id){
        sectionServies. deleteService(id);

    }
    @PutMapping("/{id}")
    public void updateSection(@PathVariable String id, @RequestBody Section data)
    {
        sectionServies.updateSection(id,data);
    }

}
