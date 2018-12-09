package com.park.server.demo.controller;

import com.park.server.demo.mapper.Mapper;
import com.park.server.demo.model.Avoir;
import com.park.server.demo.model.Client;
import com.park.server.demo.modelMapper.AvoirModel;
import com.park.server.demo.modelMapper.ClientModel;
import com.park.server.demo.repository.AvoirRepository;
import com.park.server.demo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.List;

@RestController
@RequestMapping("/api/avoir")
public class AvoirController {

   @Autowired
   private AvoirRepository avoirRepository;
   private Mapper mapper;


    public AvoirController(Mapper mapper ) {
        this.mapper = mapper;
    }

    @GetMapping
    public List<Avoir> getAvoirs(){
        return avoirRepository.findAll(); }

    @PostMapping
    public void addAvoir(@RequestBody AvoirModel avoirModel, BindingResult bindingResult) {
            if (bindingResult.hasErrors()) {
                throw new ValidationException();
            }
    //    Avoir avoir = this.mapper.convertToAvoirEntity(avoirModel);

            this.avoirRepository.save(null);


    }

    @PutMapping
    public void updateAvoir(@RequestBody Avoir avoir){
        avoirRepository.save(avoir);
    }
    @DeleteMapping("/{id}")
    public void deleteAvoir(@PathVariable Long id)
    {
        avoirRepository.deleteById(id);
    }

}
