package com.example.demo.repositories;

import com.example.demo.domains.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRoomRepository extends JpaRepository<ClassRoom, Long>{
    List<ClassRoom> findByClassName(String className);
}