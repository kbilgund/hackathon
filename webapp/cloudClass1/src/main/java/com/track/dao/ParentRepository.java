package com.track.dao;

import com.track.entity.Parent;
import org.springframework.data.repository.CrudRepository;

public interface ParentRepository extends CrudRepository<Parent, String> {
}
