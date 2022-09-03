package com.tms.homework_40.web;

import com.tms.homework_40.controller.Handler;
import com.tms.homework_40.dto.CatDTO;
import com.tms.homework_40.model.Cat;
import com.tms.homework_40.model.SearchRequest;
import com.tms.homework_40.service.CatServiceImpl;
import com.tms.homework_40.service.CatSpecificationService;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(path = "/api/cat")
@Tag(name = "Main cat controller", description = "This controller is used for cats' CRUD operations.")
public class CatController {

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
                            @Content(schema = @Schema(implementation = Handler.class))
                    })
    })
    public ResponseEntity<CatDTO> getById(@PathVariable("catId") Long catId) {
        Cat catFromDB = catService.getById(catId);
        CatDTO catDTO = createCatDTO(catFromDB);
        System.out.println("get cat from db with id = " + catId);
        return ResponseEntity.ok(catDTO);
    }

    @GetMapping()
    @Tag(name = "Get All", description = "Get all cats")
    public ResponseEntity<List<CatDTO>> getAll() {
        List<Cat> allCatsFromDB = catService.getAll();
        List<CatDTO> allCatsDTO = getListCatDTOFromDBAndAddLink(allCatsFromDB);
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
                            @Content(schema = @Schema(implementation = Handler.class))
                    })
    })
    public ResponseEntity<Cat> addCat(@RequestBody Cat cat) {
        catService.saveCat(cat);
        System.out.println("created cat " + cat);
        return ResponseEntity.ok(cat);
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
                            @Content(schema = @Schema(implementation = Handler.class))
                    })
    })
    public ResponseEntity<CatDTO> updateCat(@RequestBody Cat cat,
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
    @Tag(name = "Delete by id",
            description = "Delete information about Cat by id")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "success operation",
                    content = {
                            @Content(schema = @Schema(implementation = String.class))
                    }),
            @ApiResponse(responseCode = "400", description = "cat with such id was not found",
                    content = {
                            @Content(schema = @Schema(implementation = Handler.class))
                    })
    })
    public ResponseEntity<String> delete(@PathVariable("catId") Long catId) {
        catService.getById(catId);
        catService.deleteById(catId);
        System.out.println("delete cat with id " + catId);
        return ResponseEntity.ok().body("Cat with id = " + catId + " was removed.");
    }

    @PostMapping("/search")
    @Tag(name = "Search cat",
            description = "Search information about Cat by name, breed, age")
    @ApiResponse(responseCode = "200", description = "success operation",
            content = {
                    @Content(schema = @Schema(implementation = CatDTO.class))
            })
    public ResponseEntity<List<CatDTO>> search(@RequestBody SearchRequest request) {
        Specification<Cat> catSpecification = CatSpecificationService.getCatSpecification(request);
        List<Cat> allCatsBySearch = catService.getAllBySearch(catSpecification);
        List<CatDTO> allCatsDTO = getListCatDTOFromDBAndAddLink(allCatsBySearch);
        return ResponseEntity.ok(allCatsDTO);
    }

    private CatDTO createCatDTO(Cat catFromDB) {
        CatDTO catDTO = new CatDTO();
        catDTO.setId(catFromDB.getId());
        catDTO.setAge(catFromDB.getAge());
        catDTO.setName(catFromDB.getName());
        catDTO.setBreed(catFromDB.getBreed());
        return catDTO;
    }

    private List<CatDTO> getListCatDTOFromDBAndAddLink(List<Cat> catsFromDB) {
        List<CatDTO> allCatsDTO = new ArrayList<>();
        for (Cat cat : catsFromDB) {
            Link link = WebMvcLinkBuilder.linkTo(methodOn(CatController.class).getById(cat.getId())).withSelfRel();
            CatDTO catDTO = createCatDTO(cat);
            catDTO.add(link);
            allCatsDTO.add(catDTO);
        }
        return allCatsDTO;
    }
}
