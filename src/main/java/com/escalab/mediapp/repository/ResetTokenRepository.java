package com.escalab.mediapp.repository;

import com.escalab.mediapp.entity.ResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResetTokenRepository extends JpaRepository<ResetToken, Integer> {

    //from ResetToken where token = :?
    ResetToken findByToken(String token);
}
