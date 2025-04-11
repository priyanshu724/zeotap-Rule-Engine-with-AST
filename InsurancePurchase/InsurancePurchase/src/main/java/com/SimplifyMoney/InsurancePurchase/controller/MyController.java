package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.InsaurenceService;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    private InsaurenceService insaurenceService;

    @GetMapping("/insaurence")
    public List<Insaurence> getInsaurence(){
    return this.insaurenceService.getInsaurence();
    }

}
