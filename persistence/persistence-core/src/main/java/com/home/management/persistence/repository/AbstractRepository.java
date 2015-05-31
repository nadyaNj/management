package com.home.management.persistence.repository;

import com.home.management.service.common.AbstractEntityModel;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/31/15
 * TIME:    12:04 PM
 */
public interface AbstractRepository<T extends AbstractEntityModel> extends JpaRepository<T, Long> {
}
