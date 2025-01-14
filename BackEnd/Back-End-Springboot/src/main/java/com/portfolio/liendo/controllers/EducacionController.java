package com.portfolio.liendo.controllers;

import com.portfolio.liendo.Service.EducacionService;
import com.portfolio.liendo.models.Educacion;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;


@RestController
@CrossOrigin(origins = {"https://frontendliendo.web.app","http://localhost:4200"})
@RequestMapping("/educacion")
public class EducacionController {
    private final EducacionService educacionService;
        
    public EducacionController(EducacionService educacionService){
        this.educacionService=educacionService;
    }
    @ApiIgnore
    @GetMapping("/all")
    public ResponseEntity<List<Educacion>> obtenerEducacion(){
        List<Educacion> educaciones=educacionService.buscarEducaciones();
        return new ResponseEntity<>(educaciones, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public  ResponseEntity<Educacion>editarEducacion(@RequestBody Educacion educacion){
        Educacion updateEducacion=educacionService.editarEducacion(educacion);
        return new ResponseEntity<>(updateEducacion, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Educacion>crearEducacion(@RequestBody Educacion educacion){
        Educacion nuevaEducacion=educacionService.addEducacion(educacion);
        return new ResponseEntity<>(nuevaEducacion,HttpStatus.CREATED); 
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>borrarEducacion(@PathVariable("id") Long id){
        educacionService.borrarEducacion(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
