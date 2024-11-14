package com.study.repository.StoreRepository;

import com.study.domain.Region;
import com.study.domain.Store;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom{
    Optional<Store> findByName(String storeName);

}
