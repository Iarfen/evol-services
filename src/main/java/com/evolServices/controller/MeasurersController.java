package com.evolServices.controller;

import com.evolServices.dao.MeasurersDAO;
import com.evolServices.model.Measurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
public class MeasurersController {
    
    @Autowired
    private MeasurersDAO measurersDAO;

    /**
     * GET request. Returns all measurers
     * @return A list of all measurers
     */
    @GetMapping("/measurers")
    public List<Measurer> getMeasurers() {
        return (List<Measurer>) measurersDAO.findAll();
    }

    /**
     * GET request. Returns the requested measurer
     * @param measurerId
     * @return The measurer of the given id
     * @throws ResponseStatusException
     */
    @GetMapping("/measurers/{measurerId}")
    public Measurer getMeasurer(@PathVariable Long measurerId) throws ResponseStatusException {
        return measurersDAO.findById(measurerId).orElseThrow(() -> { throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Measurer not found"); } );
    }

    /**
     * POST request. Creates a new measurer
     * @param client
     */
    @PostMapping("/measurers")
    void addMeasurer(@RequestBody Measurer client) {
        measurersDAO.save(client);
    }

    /**
     * PUT request. Updates a measurer
     * @param client
     * @param measurerId
     * @throws ResponseStatusException
     */
    @PutMapping("/measurers/{measurerId}")
    void putMeasurer(@RequestBody Measurer client,@PathVariable Long measurerId) throws ResponseStatusException {
        Optional<Measurer> dbMeasurer = measurersDAO.findById(measurerId);
        if (dbMeasurer.isPresent())
        {
            client.setId(measurerId);
            measurersDAO.save(client);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Measurer not found");
        }
    }

    /**
     * DELETE request. Deletes the measurer of the given id
     * @param measurerId
     * @throws ResponseStatusException
     */
    @DeleteMapping("/measurers/{measurerId}")
    void deleteMeasurer(@PathVariable Long measurerId) throws ResponseStatusException {
        Optional<Measurer> dbMeasurer = measurersDAO.findById(measurerId);
        if (dbMeasurer.isPresent())
        {
            measurersDAO.deleteById(measurerId);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Measurer not found");
        }
    }
}
