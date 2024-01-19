package com.example.TwoPizza.repositories;

import com.example.TwoPizza.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<UserEntity, Long> {}
