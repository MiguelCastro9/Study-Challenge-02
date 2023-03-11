package com.api.controller;

import com.api.dto.PacienteRequestDto;
import com.api.dto.PacienteResponseDto;
import com.api.model.PacienteModel;
import com.api.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Miguel Castro
 */
@Tag(name = "Paciente")
@RestController
@RequestMapping("/")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;

    @GetMapping
    @Operation(description = "Listar")
    public ResponseEntity<List<PacienteResponseDto>> listar() {

        return new ResponseEntity<List<PacienteResponseDto>>(
                pacienteService.listar().stream().map(paciente
                        -> PacienteResponseDto.converterEntidadeParaPacienteDto(paciente))
                        .collect(Collectors.toList()), HttpStatus.OK);
    }
    
    @PostMapping
    @Operation(description = "Salvar")
    public ResponseEntity<PacienteResponseDto> salvar(@Valid @RequestBody PacienteRequestDto pacienteRequestDto) {
        System.out.println("aqui:" + pacienteRequestDto);
        PacienteModel pacienteModel = pacienteService.salvar(pacienteRequestDto.converterPacienteDtoParaEntidade());
        return new ResponseEntity<PacienteResponseDto>(PacienteResponseDto.converterEntidadeParaPacienteDto(pacienteModel), HttpStatus.CREATED);
    }
}