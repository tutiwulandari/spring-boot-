package com.enigma.wulan.repositories;

import com.enigma.wulan.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface ItemRepository extends JpaRepository<Item, Integer> {


}
