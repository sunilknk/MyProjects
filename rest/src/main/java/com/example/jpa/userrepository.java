package com.example.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.user.user;

public interface userrepository extends JpaRepository<user,Integer>
{

}
