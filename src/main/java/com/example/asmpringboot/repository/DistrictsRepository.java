package com.example.asmpringboot.repository;

import com.example.asmpringboot.entity.Districts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistrictsRepository extends JpaRepository<Districts, Integer> {
}
