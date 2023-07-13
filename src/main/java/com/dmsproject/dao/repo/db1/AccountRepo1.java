package com.dmsproject.dao.repo.db1;

import com.dmsproject.dao.entity.db1.Account1DO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo1 extends JpaRepository<Account1DO, Integer> {
}
