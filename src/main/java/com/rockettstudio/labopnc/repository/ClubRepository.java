package com.rockettstudio.labopnc.repository;

import com.rockettstudio.labopnc.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public class ClubRepository {
    public interface ClubRepository extends JpaRepository<Club, UUID> {
        boolean existsByName(String name);
}
