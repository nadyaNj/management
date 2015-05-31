package com.home.management.persistence.repository.task;

import com.home.management.persistence.repository.AbstractRepository;
import com.home.management.service.task.model.TaskModel;

/**
 * Created: Nadya Dainelyan
 * DATE:    5/31/15
 * TIME:    12:28 PM
 */
public interface TaskRepository extends AbstractRepository<TaskModel>, TaskRepositoryCustom {
}
