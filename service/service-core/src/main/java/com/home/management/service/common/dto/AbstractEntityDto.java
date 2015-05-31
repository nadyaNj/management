package com.home.management.service.common.dto;


import com.home.management.service.common.AbstractEntityModel;

import java.io.Serializable;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/25/15
 * TIME:    8:18 PM
 */
public abstract class AbstractEntityDto<T extends AbstractEntityModel> implements Serializable {

    private static final long serialVersionUID = 2307929810491964480L;

    public abstract void updateModelProperties(T entity);

}
