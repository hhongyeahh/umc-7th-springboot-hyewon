package com.study.service.StoreService;

import com.study.domain.Review;
import com.study.domain.Store;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface StoreQueryService {
    Optional<Store> findStore(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);

    Boolean existsById(Long storeId);


}
