package com.home.management.service;

import com.home.management.service.common.AbstractEntityModel;
import com.home.management.service.common.dto.AbstractEntityDto;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/31/15
 * TIME:    12:08 PM
 */
public interface BaseService<T extends AbstractEntityModel> {

    /**
     * get entity by id
     *
     * @param id
     * @return T
     */
    @Nullable
    T getById(@Nonnull final Long id);


    /**
     * create entity
     *
     * @param entity
     * @return T
     */
    @Nonnull
    T  createEntity(@Nonnull final T entity);


    /**
     * update entity
     *
     * @param id
     * @param dto
     * @return T
     */
    @Nonnull
    public T updateEntity(@Nonnull final Long id, @Nonnull final AbstractEntityDto<T> dto);
}
