package com.amoncardim.agendamento_horarios.controller;

import com.amoncardim.agendamento_horarios.infrastructure.entity.AgendamentoEntity;
import com.amoncardim.agendamento_horarios.services.AgendamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/agendamentos")
@RequiredArgsConstructor
public class AgendamentoController {

    private final AgendamentoService agendamentoService;

    @PostMapping
    public ResponseEntity<AgendamentoEntity> salvarAgendamento(@RequestBody AgendamentoEntity agendamentoEntity) {
        return ResponseEntity.accepted().body(agendamentoService.salvarAgendamento(agendamentoEntity));
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarAgendamento(@RequestBody String cliente, @RequestBody LocalDateTime dataHoraAgendamento) {

        agendamentoService.deletaAgendamento(dataHoraAgendamento,  cliente);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<AgendamentoEntity>> buscarAgendamentosDia(@RequestParam LocalDate data){
        return ResponseEntity.ok().body(agendamentoService.buscarAgendamentosDia(data));
    }

    @PutMapping ResponseEntity<AgendamentoEntity> alterarAgendamento(@RequestBody AgendamentoEntity agendamentoEntity,
                                                                        @RequestParam String cliente,
                                                                        @RequestParam LocalDateTime dataHoraAgendamento){
        return ResponseEntity.accepted().body(agendamentoService.alterarAgendamento(agendamentoEntity, cliente, dataHoraAgendamento));
    }
}
