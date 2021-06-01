package com.example.demo.controllers;

import com.example.demo.domains.ClassRoom;
import com.example.demo.repositories.ClassRoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClassRoomController {
    @Autowired
    ClassRoomRepository classRoomRepository;

//retrieve all ClassRoom
    @GetMapping("/classroom")
    public List<ClassRoom> getClassRoomList() {
        return classRoomRepository.findAll();
    }
//DELETE	/api/classroom/:id		delete a data table by :id
    @DeleteMapping("/classroom/{id}")
    public ResponseEntity<HttpStatus> deleteClassroom(@PathVariable("id") long id) {
        try {
            classRoomRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
//ADD new classroom
    @PostMapping(value = "/classroom", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClassRoom> createTutorial(@RequestBody ClassRoom classRoom) {
        try {
            ClassRoom _classRoom = classRoomRepository.save (classRoom);
            return new ResponseEntity<>(_classRoom, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
        }

//PUT	/api/tutorials/:id		update a Tutorial by :id
    @PutMapping(value = "/classroom/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClassRoom> updateClassRoom(@PathVariable("id") long id, @RequestBody ClassRoom classRoom) {
        Optional<ClassRoom> classRoomData = classRoomRepository.findById(id);
        ClassRoom _classRoom = new ClassRoom();
        if (id == classRoom.getId()){
            if (classRoomData.isPresent()) {
                _classRoom = classRoomData.get();
                _classRoom.setClassName(classRoom.getClassName());

            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }
            return new ResponseEntity<>(classRoomRepository.save(_classRoom), HttpStatus.OK);
    }

}
