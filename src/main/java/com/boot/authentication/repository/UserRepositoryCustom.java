package com.boot.authentication.repository;

import com.boot.authentication.entity.User;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepositoryCustom extends DataTablesRepository<User, Long>, PagingAndSortingRepository<User,Long> {
}
