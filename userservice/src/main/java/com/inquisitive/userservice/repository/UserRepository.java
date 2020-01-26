package com.inquisitive.userservice.repository;

import com.inquisitive.userservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ankitmishra on 26/01/20.
 */
@Repository
public interface UserRepository extends JpaRepository<Account, Long> {

}
