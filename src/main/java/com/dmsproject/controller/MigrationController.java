//package com.dmsproject.controller;
//
//import com.dmsproject.controller.pojo.MigrationDTO;
//import com.dmsproject.controller.service.MigrationService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class MigrationController {
//
//    private final MigrationService migrationService;
//
//    public MigrationController(MigrationService migrationService) {
//        this.migrationService = migrationService;
//    }
//
//    @PostMapping(path = "/time-sheet-migration")
//    public ResponseEntity<MigrationDTO> timeSheetMigration() {
//
//        MigrationDTO migrationDTO = migrationService.timeSheetMigration();
//        return ResponseEntity.ok().body(migrationDTO);
//    }
//}
