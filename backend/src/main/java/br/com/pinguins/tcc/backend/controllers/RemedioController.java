<<<<<<< HEAD
package br.com.pinguins.tcc.backend.controllers;

import br.com.pinguins.tcc.backend.dtos.RemedioDTO;
import br.com.pinguins.tcc.backend.entities.Remedio;
import br.com.pinguins.tcc.backend.entities.Usuario;
import br.com.pinguins.tcc.backend.repositories.UsuarioRepository;
import br.com.pinguins.tcc.backend.services.RemedioService;
import br.com.pinguins.tcc.backend.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/remedios")
public class RemedioController {

    private final RemedioService remedioService;

    @Autowired
    public RemedioController(RemedioService remedioService) {
        this.remedioService = remedioService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RemedioDTO>> findAll() {
        return ResponseEntity.ok(remedioService.findAll());
    }

    @GetMapping(value = "/id/{nome}")
    public ResponseEntity<List<RemedioDTO>> findByNome(@PathVariable("nome") String nome) {
        List<RemedioDTO> remedioDTO = remedioService.findByNome(nome);

        return ResponseEntity.status(HttpStatus.OK).body(remedioDTO);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RemedioDTO> save(@RequestBody RemedioDTO remedioDTO) {
        remedioService.save(remedioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(remedioDTO);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RemedioDTO> update(@PathVariable("id") Integer id, @RequestBody RemedioDTO remedio) {
        RemedioDTO remedioDTO = remedioService.updateById(id, remedio);

        return ResponseEntity.status(HttpStatus.OK).body(remedioDTO);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        remedioService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(MessageUtil.MESSAGE_DELETE_SUCCESS);
    }
}
=======
package br.com.pinguins.tcc.backend.controllers;

import br.com.pinguins.tcc.backend.dtos.RemedioDTO;
import br.com.pinguins.tcc.backend.entities.Remedio;
import br.com.pinguins.tcc.backend.entities.Usuario;
import br.com.pinguins.tcc.backend.repositories.UsuarioRepository;
import br.com.pinguins.tcc.backend.services.RemedioService;
import br.com.pinguins.tcc.backend.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/remedios")
public class RemedioController {

    private final RemedioService remedioService;

    @Autowired
    public RemedioController(RemedioService remedioService) {
        this.remedioService = remedioService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<RemedioDTO>> findAll() {
        return ResponseEntity.ok(remedioService.findAll());
    }

    @GetMapping(value = "/id/{nome}")
    public ResponseEntity<List<RemedioDTO>> findByNome(@PathVariable("nome") String nome) {
        List<RemedioDTO> remedioDTO = remedioService.findByNome(nome);

        return ResponseEntity.status(HttpStatus.OK).body(remedioDTO);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RemedioDTO> save(@RequestBody RemedioDTO remedioDTO) {
        remedioService.save(remedioDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(remedioDTO);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<RemedioDTO> update(@PathVariable("id") Integer id, @RequestBody RemedioDTO remedio) {
        RemedioDTO remedioDTO = remedioService.updateById(id, remedio);

        return ResponseEntity.status(HttpStatus.OK).body(remedioDTO);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        remedioService.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(MessageUtil.MESSAGE_DELETE_SUCCESS);
    }
}
>>>>>>> 606904349d8119483c76590e5f98c9c5439da15d
