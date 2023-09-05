package com.example.demo.dao;

import com.example.demo.entity.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityDAO extends JpaRepository<Authority,Integer> {
}
