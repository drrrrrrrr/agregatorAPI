package main.rest;

import main.model.Client;
import main.model.Customer;
import main.parser.ParsingFNK;
import main.service.ClientService;
import main.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/clients/")
public class ClientRestControllerV1 {

    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Client> getClient(@PathVariable("id") Long сlientId) {

        if (сlientId == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Client customer = this.clientService.getById(сlientId);

        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(customer, HttpStatus.OK);

    }



}
