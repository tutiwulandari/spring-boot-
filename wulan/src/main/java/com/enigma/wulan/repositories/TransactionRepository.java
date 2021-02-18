package com.enigma.wulan.repositories;
import com.enigma.wulan.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {


}
