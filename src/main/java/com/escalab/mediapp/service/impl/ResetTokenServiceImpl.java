package com.escalab.mediapp.service.impl;

import com.escalab.mediapp.entity.ResetToken;
import com.escalab.mediapp.repository.ResetTokenRepository;
import com.escalab.mediapp.service.ResetTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Service;

@Service
public class ResetTokenServiceImpl implements ResetTokenService {

    @Autowired
    private ResetTokenRepository repo;

    @Override
    public ResetToken findByToken(String token) {
        return repo.findByToken(token);
    }

    @Override
    public void guardar(ResetToken token) {
        repo.save(token);

    }

    @Override
    public void eliminar(ResetToken token) {
        repo.delete(token);
    }

    @Override
    public void update(ResetToken token) {
        repo.save(token);
    }
}
