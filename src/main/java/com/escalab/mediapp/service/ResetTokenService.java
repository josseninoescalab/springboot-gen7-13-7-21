package com.escalab.mediapp.service;

import com.escalab.mediapp.entity.ResetToken;

public interface ResetTokenService {

    ResetToken findByToken(String token);

    void guardar(ResetToken token);

    void eliminar(ResetToken token);

    void update(ResetToken token);
}
