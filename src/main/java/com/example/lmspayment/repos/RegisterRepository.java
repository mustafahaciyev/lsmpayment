package com.example.lmspayment.repos;

import com.example.lmspayment.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Long> {

    Register findByUserName(String userName);

}
