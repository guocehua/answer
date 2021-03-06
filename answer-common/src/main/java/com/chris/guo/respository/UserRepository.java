package com.chris.guo.respository;

import com.chris.guo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.invoke.LambdaConversionException;
@Repository
public interface UserRepository extends JpaRepository<User,LambdaConversionException> {
    User findByName(String username);
}
