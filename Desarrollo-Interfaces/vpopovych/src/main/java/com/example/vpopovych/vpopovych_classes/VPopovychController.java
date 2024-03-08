package com.example.vpopovych.vpopovych_classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vpopovych")
@RequiredArgsConstructor
public class VPopovychController {

    // probar swagger  http://localhost:8080/swagger-ui.html

    @Autowired
    private final VPopovychService vPopovychService;

    // crea un nuevo objeto
    

    @PostMapping("/crearVPopovych")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "creado"),
            @ApiResponse(responseCode = "205", description = "creado parcialmente")
    })
    public ResponseEntity<String> insertarVPopovych(@RequestBody VPopovych vPopovych) {

        //hacer la comprobacion de si falta algun dato, si es asi va a ser parcial

        boolean esParcial = false;

        if (vPopovych.getNombre() == null) {
            esParcial = true;
        } else if (vPopovych.getApellidos() == null) {
            esParcial = true;
        } else if (vPopovych.getEmail() == null) {
            esParcial = true;
        }

        if (esParcial) {
            return ResponseEntity.status(205).body("creado parcialmente");
        } else {
            vPopovychService.crearVPopovych(vPopovych);
            return ResponseEntity.status(200).body("creado!!");
        }
    }

    //editar datos de los objetos

    @PutMapping("/editarVPopovych/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "editado!"),
            @ApiResponse(responseCode = "201", description = "editado parcialmente"),
            @ApiResponse(responseCode = "209", description = "No encontrado")
    })

    public ResponseEntity<String> editarElemento(@PathVariable Integer id, @RequestBody VPopovych vPopovych) {
        return vPopovychService.editarVPopovych(id, vPopovych);
    }

    //borrar objetos 

    @PutMapping("/borrarVPopovych/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "borrado:("),
            @ApiResponse(responseCode = "209", description = "elemento no borrado")
    })
    public ResponseEntity<String> borrarVPopovych(@PathVariable Integer id) {

        if (vPopovychService.borrarVPopovych(id)) {
            return ResponseEntity.status(200).body("borrado");
        } else {
            return ResponseEntity.status(209).body("elemento no borrado");
        }
    }

    //buscar objetos por el id

    @GetMapping("/buscarVPopovych/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "encontrado"),
            @ApiResponse(responseCode = "209", description = "no encontrado")
    })

    public ResponseEntity<VPopovych> buscarElemento(@PathVariable Integer id) {
        Optional<VPopovych> vPopovychOptional = vPopovychService.obtenerVPopovych(id);

        //comporbar que el optional existe en la base
        if (vPopovychOptional.isPresent()) {
            return ResponseEntity.status(200).body(vPopovychOptional.get());
        } else {
            return ResponseEntity.status(209).body(null);
        }
    }

    //obtener todos los elementos de la bbdd

    @GetMapping("/obtenerTodo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "elementos encontrados"),
            @ApiResponse(responseCode = "209", description = "no hay elementos")
    })

    public ResponseEntity<?> obtenerTodas() {
        // ? wild card que permite manejar cualquier cuerpo de respuesta, cualquier tipo de objeto
        List<VPopovych> todos = vPopovychService.obtenerTodas();
        if (todos.isEmpty()) {
            return ResponseEntity.status(209).body("no hay elementos");
        } else {
            return ResponseEntity.status(200).body(todos);
        }
    }

    //borrar todos los datos

    @DeleteMapping("/borrarTodo")
    @ApiResponse(responseCode = "200", description = "todo borrado")

    public ResponseEntity<String> borrarTodo() {
        vPopovychService.borrarTodos();
        return ResponseEntity.ok("todo borrado");
    }

    //aumentar el saldo de un id concreto 

    @PutMapping("/aumentarSaldo/{id}/{cantidad}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "saldo aumentado"),
            @ApiResponse(responseCode = "201", description = "Saldo inicializado y aumentado"),
            @ApiResponse(responseCode = "209", description = "id no existe")
    })

    public ResponseEntity<String> aumentarSaldo(@PathVariable Integer id, @PathVariable float cantidad) {
        Optional<VPopovych> vPopovychOptional = vPopovychService.obtenerVPopovych(id);
        if (!vPopovychOptional.isPresent()) {
            return ResponseEntity.status(209).body("id no existe");
        }

        VPopovych vPopovych = vPopovychOptional.get();
        vPopovych.setSaldo(vPopovych.getSaldo() + cantidad);
        vPopovychService.modificarSaldos(vPopovych);

        if (vPopovych.getSaldo() == 0) {
            return ResponseEntity.status(201).body("Saldo inicializado y aumentado ");
        } else {
            return ResponseEntity.status(200).body("saldo aumentado ");
        }
    }

    //reducir el saldo de un id concreto

    @PutMapping("/reducirSaldo/{id}/{cantidad}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "saldo quitado y positivo"),
            @ApiResponse(responseCode = "201", description = "Saldo quitado y negativo"),
            @ApiResponse(responseCode = "209", description = "id no existe")
    })
    public ResponseEntity<String> reducirSaldo(@PathVariable Integer id, @PathVariable float cantidad) {
        Optional<VPopovych> vPopovychOptional = vPopovychService.obtenerVPopovych(id);
        if (!vPopovychOptional.isPresent()) {
            return ResponseEntity.status(209).body("id no existe");
        }

        VPopovych vPopovych = vPopovychOptional.get();
        float nuevoSaldo = vPopovych.getSaldo() - cantidad;
        vPopovych.setSaldo(nuevoSaldo);
        vPopovychService.modificarSaldos(vPopovych);

        if (nuevoSaldo < 0) {
            return ResponseEntity.status(201).body("Saldo quitado y negativo");
        } else {
            return ResponseEntity.ok("saldo quitado y positivo");
        }
    }

    //obtener la media de todos

    @GetMapping("/mediaSaldos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "el saldo medio todos los registros"),
            @ApiResponse(responseCode = "201", description = "saldo medio es negativo")
    })
    public ResponseEntity<String> mediaSaldos() {
        Double media = vPopovychService.mediaSaldos();
        if (media < 0) {
            return ResponseEntity.status(201).body("saldo medio es negativo: " + media);
        } else {
            return ResponseEntity.status(200).body("el saldo medio todos los registros: " + media);
        }
    }
}
