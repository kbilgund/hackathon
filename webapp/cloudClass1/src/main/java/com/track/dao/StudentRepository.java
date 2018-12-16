package com.track.dao;

import com.track.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, String> {


 //   @Query("from Auction a join a.category c where c.name=:categoryName")


}
