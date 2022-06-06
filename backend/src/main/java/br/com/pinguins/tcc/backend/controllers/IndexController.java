package br.com.pinguins.tcc.backend.controllers;

import br.com.pinguins.tcc.backend.utils.MessageUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return MessageUtil.ACCESS_SUCCESS;
    }
}
