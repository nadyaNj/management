package com.home.management.service.impl;

import com.home.management.persistence.repository.AbstractRepository;
import com.home.management.service.BaseService;
import com.home.management.service.common.AbstractEntityModel;
import com.home.management.service.common.dto.AbstractEntityDto;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/31/15
 * TIME:    8:49 PM
 */
public abstract class AbstractServiceImpl<T extends AbstractEntityModel> implements BaseService<T> {

    //TODO: add logger


    @Nullable
    @Override
    public T getById(@Nonnull final Long id) {

        // TODO: assertNotNull id
        // TODO: log about getting entity by id

        // TODO: before return entity log about successfully getting and log entity + id

        return getRepository().findOne(id);
    }

    @Nonnull
    @Override
    public T createEntity(@Nonnull T entity) {
        return getRepository().save(entity);
    }

    @Nonnull
    @Override
    public T updateEntity(@Nonnull Long id, @Nonnull AbstractEntityDto<T> dto) {
        return null;
    }


    public abstract AbstractRepository<T> getRepository();


}
