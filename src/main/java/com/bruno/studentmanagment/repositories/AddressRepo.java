package com.bruno.studentmanagment.repositories;

import com.bruno.studentmanagment.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Long> {
}
