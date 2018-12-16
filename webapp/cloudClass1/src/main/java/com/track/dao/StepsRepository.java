package com.track.dao;

import com.track.entity.Steps;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface StepsRepository extends CrudRepository<Steps, String> {


    @Query(value=" select sum(steps) as weeklySteps, username " +
            " from steps " +
            " where steps.date between '2018-12-10 00:00:00' and '2018-12-14 23:59:59' " +
            " group by username order by weeklySteps desc ",nativeQuery = true)
    public List<Map<String, Object>>  findByrank();



    @Query(value="select * from steps where username=:user order by date desc limit 1 ",nativeQuery = true)
    public List<Map<String, Object>>  lastRow( @Param("user") String user);

}
