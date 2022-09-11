package com.tms.homework_40.web;

import com.tms.homework_40.dto.CatDTO;
import com.tms.homework_40.dto.ErrorDTO;
import com.tms.homework_40.model.Cat;
import com.tms.homework_40.model.SearchRequest;
import com.tms.homework_40.service.CatServiceImpl;
import com.tms.homework_40.service.CatSpecificationService;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/cat")
@Tag(name = "Main cat controller", description = "This controller is used for cats' CRUD operations.")
public class CatController{

    @Autowired
    CatServiceImpl catService;
    @Autowired
    CatSpecificationService specification;

    @GetMapping("/{catId}")
    @Tag(name = "Get by id",
            description = "Get information about Cat by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success operation", headers = {
                    @Header(name = "New header", required = true, description = "cat was shown")},
                    content = {
                            @Content(schema = @Schema(implementation = CatDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "cat with such id was not found",
                    content = {
                            @Content(schema = @Schema(implementation = ErrorDTO.class))
                    })
    })
    public ResponseEntity<CatDTO> getById(@PathVariable("catId") Long catId) {
        Cat catFromDB = catService.getById(catId);
        CatDTO catDTO = mapToCatDTO(catFromDB);
        System.out.println("get cat from db with id = " + catId);
        return ResponseEntity.ok(catDTO);
    }

    @GetMapping
    @Tag(name = "Get All", description = "Get all cats")
    @ApiResponse(responseCode = "200", description = "success operation",
            content = {
                    @Content(array = @ArraySchema( schema = @Schema(implementation = CatDTO.class)))
            })
    public ResponseEntity<List<CatDTO>> getAll() {
        List<Cat> allCatsFromDB = catService.getAll();
        List<CatDTO> allCatsDTO = convertListCatToListCatDTOAndAddLink(allCatsFromDB);
        System.out.println(allCatsDTO);
        System.out.println("get all cats from db");
        return ResponseEntity.ok(allCatsDTO);
    }

    @PostMapping
    @Tag(name = "POST for cat",
            description = "Saves information about new Cat")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success operation", headers = {
                    @Header(name = "New header", required = true, description = "Added headed")},
                    content = {
                            @Content(schema = @Schema(implementation = Cat.class))
                    }),
            @ApiResponse(responseCode = "400", description = "something broken",
                    content = {
                            @Content(schema = @Schema(implementation = ErrorDTO.class))
                    })
    })
    public ResponseEntity<Cat> addCat(@RequestBody Cat cat) {
        catService.saveCat(cat);
        Cat catFromDB = catService.getById(cat.getId());
        System.out.println("created cat " + catFromDB);
        return ResponseEntity.ok(catFromDB);
    }

    @PutMapping("/{catId}")
    @Tag(name = "Update by id",
            description = "Update information about Cat by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success operation",
                    content = {
                            @Content(schema = @Schema(implementation = CatDTO.class))
                    }),
            @ApiResponse(responseCode = "400", description = "cat with such id was not found",
                    content = {
                            @Content(schema = @Schema(implementation = ErrorDTO.class))
                    })
    })
    public ResponseEntity<CatDTO> updateCat(@RequestBody Cat cat,
                                            @PathVariable("catId") Long catId) {
        Cat catFromDB = catService.getById(catId);
        catFromDB.setBreed(cat.getBreed());
        catFromDB.setAge(cat.getAge());
        catFromDB.setName(cat.getName());
        catService.saveCat(catFromDB);
        CatDTO catDTO = mapToCatDTO(catFromDB);
        System.out.println("updated cat " + catDTO);
        return ResponseEntity.ok(catDTO);
    }

    @DeleteMapping("/{catId}")
    @Tag(name = "Delete by id",
            description = "Delete information about Cat by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success operation"),
            @ApiResponse(responseCode = "400", description = "cat with such id was not found",
                    content = {
                            @Content(schema = @Schema(implementation = ErrorDTO.class))
                    })
    })
    public ResponseEntity<String> delete(@PathVariable("catId") Long catId) {
        catService.deleteById(catId);
        System.out.println("delete cat with id " + catId);
        return ResponseEntity.ok().body("Cat with id = " + catId + " was removed.");
    }

    @PostMapping("/search")
    @Tag(name = "Search cat",
            description = "Search information about Cat by name, breed, age")
    @ApiResponse(responseCode = "200", description = "success operation",
            content = {
                    @Content(array = @ArraySchema( schema = @Schema(implementation = CatDTO.class)))
            })
    public ResponseEntity<List<CatDTO>> search(@RequestBody SearchRequest request) {
        List<Cat> allCatsBySearch = catService.getAllBySearch(request);
        List<CatDTO> allCatsDTO = convertListCatToListCatDTOAndAddLink(allCatsBySearch);
        return ResponseEntity.ok(allCatsDTO);
    }

    private CatDTO mapToCatDTO(Cat catFromDB) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(catFromDB, CatDTO.class);
    }

    private List<CatDTO> convertListCatToListCatDTOAndAddLink(List<Cat> catsFromDB) {
        List<CatDTO> allCatsDTO = new ArrayList<>();
        for (Cat cat : catsFromDB) {
            CatDTO catDTO = mapToCatDTO(cat);
            allCatsDTO.add(catDTO);
            catDTO.addLink();
        }
        return allCatsDTO;
    }

}
