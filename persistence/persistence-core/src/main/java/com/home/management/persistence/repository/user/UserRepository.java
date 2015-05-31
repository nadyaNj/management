package com.home.management.persistence.repository.user;

import com.home.management.persistence.repository.AbstractRepository;
import com.home.management.service.user.model.UserModel;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/31/15
 * TIME:    12:27 PM
 */
public interface  UserRepository extends AbstractRepository<UserModel>, UserRepositoryCustom {
}
