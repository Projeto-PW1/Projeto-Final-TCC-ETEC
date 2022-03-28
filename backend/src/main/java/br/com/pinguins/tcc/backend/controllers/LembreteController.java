package br.com.pinguins.tcc.backend.controllers;

import br.com.pinguins.tcc.backend.dtos.LembreteDTO;
import br.com.pinguins.tcc.backend.dtos.UsuarioDTO;
import br.com.pinguins.tcc.backend.services.LembreteService;
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
@RequestMapping(value = "/lembretes")
public class LembreteController {

    @Autowired
    private LembreteService service;

    @GetMapping
    public ResponseEntity<List<LembreteDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping(value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LembreteDTO> findById(@PathVariable("id") Integer id) {
        LembreteDTO lembreteDTO = service.findById(id);

        return ResponseEntity.ok(lembreteDTO);
    }

    @PostMapping(value = "/save", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LembreteDTO> save(@RequestBody LembreteDTO lembreteDTO) {
        service.save(lembreteDTO);

        return ResponseEntity.ok(lembreteDTO);
    }

    @PutMapping(value = "/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<LembreteDTO> updateById(@PathVariable("id") Integer id, @RequestBody LembreteDTO lembrete) {
        LembreteDTO lembreteDTO = service.updateById(id, lembrete);

        return ResponseEntity.ok().body(lembreteDTO);
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteById(@PathVariable("id") Integer id) {
        service.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body(MessageUtil.MESSAGE_DELETE_SUCCESS);

    }

}
