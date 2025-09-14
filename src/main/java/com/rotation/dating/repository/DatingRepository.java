package com.rotation.dating.repository;

import com.rotation.dating.entity.Dating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DatingRepository extends JpaRepository<Dating, Long> {
}
