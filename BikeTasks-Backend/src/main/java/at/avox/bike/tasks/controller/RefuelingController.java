package at.avox.bike.tasks.controller;

import at.avox.bike.tasks.controller.dto.RefuelingDto;
import at.avox.bike.tasks.controller.dto.RefuelingUpdateDto;
import at.avox.bike.tasks.service.RefuelingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/refueling")
@RequiredArgsConstructor
public class RefuelingController {
    private final RefuelingService refuelingService;

    @PutMapping("/{id}")
    public RefuelingDto updateRefueling(@PathVariable UUID id, @Valid @RequestBody RefuelingUpdateDto refuelingUpdateDto) {
        return refuelingService.updateRefueling(id, refuelingUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteRefueling(@PathVariable UUID id) {
        refuelingService.deleteRefueling(id);
    }
}
