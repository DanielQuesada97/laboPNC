package com.rockettstudio.labopnc.controller;
import com.rockettstudio.labopnc.service.ClubService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/club")
@RequiredArgsConstructor
public class ClubController {
    private final ClubService clubService;

    @PostMapping
    public ResponseEntity<ClubResponse> createProduct(@Valid @RequestBody CreateProductRequest request) {
        return ResponseEntity.ok(clubService.createProduct(request));
    }

    @GetMapping
    public ResponseEntity<List<ClubResponse>> getAllProducts() {
        return ResponseEntity.ok(clubService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClubResponse> getProductById(@PathVariable UUID id) {
        return ResponseEntity.ok(clubService.getProductById(id));
    }
}
