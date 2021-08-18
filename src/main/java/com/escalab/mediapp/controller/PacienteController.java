package com.escalab.mediapp.controller;

import com.escalab.mediapp.entity.Paciente;
import com.escalab.mediapp.exceptions.ModeloNotFoundException;
import com.escalab.mediapp.response.ExceptionResponse;
import com.escalab.mediapp.service.PacienteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    //localhost:8080/paciente
    @ApiOperation(value = "Obtener todos los pacientes",
            notes = "No necesita parametros de entrada",
            response = List.class,
            responseContainer = "Pacientes")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente", response = ExceptionResponse.class),
            @ApiResponse(code = 404, message = "Not found, no encontrado", response = ExceptionResponse.class),
            @ApiResponse(code = 405, message = "No se encontraron pacientes en la BD", response = ExceptionResponse.class),
            @ApiResponse(code = 200, message = "Peticón OK", response = Paciente.class, responseContainer = "List")})
    @GetMapping
    public  @ResponseBody List<Paciente> findAll(){
        // retornar la lista de paciente
        return pacienteService.findAll();
    }

    //Path variable
    //localhost:8080/paciente/1
    @GetMapping("/{id}")
    public  @ResponseBody Paciente findById(@PathVariable("id") Integer id){
        // retornar un paciente por ID
        return pacienteService.findById(id);
    }

    //localhost:8080/dni/1-9/nombre/Juanito
    @GetMapping("/dni/{dni}/nombre/{nombre}")
    public  @ResponseBody Paciente findByDniAndNombre(@PathVariable("dni") String dni, @PathVariable("nombre") String nombre){
        // retornar un paciente por dni y por nombre
        if(dni == null || "".equalsIgnoreCase(dni)){
            throw new ModeloNotFoundException("No existe paciente o es nulo");
        }
        return pacienteService.findByDniAndNombre(dni, nombre);
    }

    //localhost:8080?dni=1-9?nombre=Juanito
    @GetMapping("/query")
    public  @ResponseBody Paciente findByDniAndNombre2(@RequestParam(value = "dni", required = false) String dni, @RequestParam(value = "nombre", required = false) String nombre){
        // retornar un paciente por dni y por nombre
        return pacienteService.findByDniAndNombre(dni, nombre);
    }

    //localhost:8080/paciente
    @PostMapping
    public @ResponseBody Paciente save(@RequestBody Paciente paciente){
        //guardar el paciente
        return pacienteService.save(paciente);
    }

    //localhost:8080/paciente
    @PutMapping("/{id}")
    public @ResponseBody Paciente update(@PathVariable("id") Integer id, @RequestBody Paciente paciente){
        // actualizar el paciente
        return pacienteService.update(paciente, id);
    }

    //localhost:8080/paciente
    @DeleteMapping("/{id}")
    public @ResponseBody ResponseEntity<String> deleteById(@PathVariable("id") Integer id) throws Exception {
        pacienteService.delete(id);
        return new ResponseEntity<String>("Paciente eliminado correctamente", HttpStatus.OK);
    }

}
