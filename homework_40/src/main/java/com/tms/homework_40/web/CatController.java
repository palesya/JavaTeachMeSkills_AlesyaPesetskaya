package com.tms.homework_40.web;

import com.tms.homework_40.dto.CatDTO;
import com.tms.homework_40.model.Cat;
import com.tms.homework_40.service.CatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/cat")
public class CatController {

    @Autowired
    CatServiceImpl catService;

    @GetMapping("/{catId}")
    public ResponseEntity<Object> getById(@PathVariable("catId") Long catId) {
        Cat catFromDB = catService.getById(catId);
        CatDTO catDTO = createCatDTO(catFromDB);
        System.out.println("get cat from db with id = " + catId);
        return ResponseEntity.ok(catDTO);
    }

    @GetMapping()
    public ResponseEntity<List<CatDTO>> getAll() {
        List<Cat> allCatsFromDB = catService.getAll();
        List<CatDTO> allCatsDTO = new ArrayList<>();
        for (Cat cat : allCatsFromDB) {
            allCatsDTO.add(createCatDTO(cat));
        }
        System.out.println(allCatsDTO);
        System.out.println("get all cats from db");
        return ResponseEntity.ok(allCatsDTO);
    }

    @PostMapping
    public ResponseEntity<Cat> addCat(@RequestBody Cat cat) {
        catService.saveCat(cat);
        System.out.println("created cat " + cat);
        return ResponseEntity.ok(cat);
    }

    @PutMapping("/{catId}")
    public ResponseEntity<Object> updateCat(@RequestBody Cat cat,
                                            @PathVariable("catId") Long catId) {
        Cat catFromDB = catService.getById(catId);
        catFromDB.setBreed(cat.getBreed());
        catFromDB.setAge(cat.getAge());
        catFromDB.setName(cat.getName());
        catService.saveCat(catFromDB);
        CatDTO catDTO = createCatDTO(catFromDB);
        catDTO.setId(catId);
        System.out.println("updated cat " + catDTO);
        return ResponseEntity.ok(catDTO);
    }

    @DeleteMapping("/{catId}")
    public ResponseEntity<String> delete(@PathVariable("catId") Long catId) {
        catService.getById(catId);
        catService.deleteById(catId);
        System.out.println("delete cat with id " + catId);
        return ResponseEntity.ok().body("Cat with id = " + catId + " was removed.");
    }

    private CatDTO createCatDTO(Cat catFromDB) {
        CatDTO catDTO = new CatDTO();
        catDTO.setId(catFromDB.getId());
        catDTO.setAge(catFromDB.getAge());
        catDTO.setName(catFromDB.getName());
        catDTO.setBreed(catFromDB.getBreed());
        return catDTO;
    }
}
