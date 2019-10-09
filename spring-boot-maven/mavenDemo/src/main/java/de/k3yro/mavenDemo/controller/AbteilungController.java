package de.k3yro.mavenDemo.controller;

import de.k3yro.mavenDemo.entity.Abteilung;
import de.k3yro.mavenDemo.repository.AbteilungRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AbteilungController {

    @Autowired
    AbteilungRepository abteilungRepository;

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/abteilung",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Abteilung> getAbteilung(){
        List<Abteilung> abteilungList = abteilungRepository.selectAbteilungen();
        return  abteilungList;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/abteilung/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Object getAbteilungById(@PathVariable("id") Integer id){
        return abteilungRepository.findById(id);
    }

    @RequestMapping(
            method = RequestMethod.POST,
            path = "/abteilung",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public Abteilung saveAbteilung(@RequestBody Abteilung abteilung){
        return abteilungRepository.save(abteilung);
    }

    @Transactional
    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/abteilung",
            consumes =  MediaType.APPLICATION_JSON_VALUE
    )
    public Integer updateAbteilung(@RequestBody Abteilung abteilung){
        return abteilungRepository.updateAbteilung(
                abteilung.getId(),
                abteilung.getName()
        );
    }

    @Transactional
    @RequestMapping(
            method = RequestMethod.PUT,
            path = "/abteilung2",
            consumes =  MediaType.APPLICATION_JSON_VALUE
    )
    public Abteilung updateAbteilung2(@RequestBody Abteilung abteilung){
        Abteilung updateAbteilung = abteilungRepository.getOne(abteilung.getId());

        updateAbteilung.setName(abteilung.getName());

        return abteilungRepository.saveAndFlush(updateAbteilung);
    }

    @Transactional
    @RequestMapping(
            method = RequestMethod.DELETE,
            path = "/abteilung/{id}",
            consumes =  MediaType.APPLICATION_JSON_VALUE
    )
    public void deleteAbteilung(@PathVariable("id") Integer id){
        abteilungRepository.deleteAbteilung(id);
    }
}
