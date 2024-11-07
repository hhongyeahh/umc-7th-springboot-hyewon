package com.study.repository.StoreRepository;

import com.study.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {

    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
