package com.portfolio.liendo.controllers;

import com.portfolio.liendo.Service.ProyectosService;
import com.portfolio.liendo.models.Proyectos;
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
@RequestMapping("/proyectos")
public class ProyectosController {
    private final ProyectosService proyectosService;
        
    public ProyectosController(ProyectosService proyectosService){
        this.proyectosService=proyectosService;
    }
    @ApiIgnore
    @GetMapping("/all")
    public ResponseEntity<List<Proyectos>> obtenerProyectos(){
        List<Proyectos> proyectos=proyectosService.buscarProyectos();
        return new ResponseEntity<>(proyectos, HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public  ResponseEntity<Proyectos>editarProyectos(@RequestBody Proyectos proyectos){
        Proyectos updateProyectos=proyectosService.editarProyectos(proyectos);
        return new ResponseEntity<>(updateProyectos, HttpStatus.OK);
    }
    
    @PostMapping("/add")
    public ResponseEntity<Proyectos>crearProyectos(@RequestBody Proyectos proyectos){
        Proyectos nuevaProyectos=proyectosService.addProyectos(proyectos);
        return new ResponseEntity<>(nuevaProyectos,HttpStatus.CREATED); 
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>borrarProyectos(@PathVariable("id") Long id){
        proyectosService.borrarProyectos(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}