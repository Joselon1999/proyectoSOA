package utp.soa.avance.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import utp.soa.avance.dto.PasswordResetToken;

public interface TokenRepository extends JpaRepository<PasswordResetToken, Integer> {

    PasswordResetToken findByToken(String token);

}