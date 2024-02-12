package org.example.qatester.repository;

import org.example.qatester.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ITestCaseRepository extends JpaRepository<TestCase, Long> {

    @Query("FROM TestCase tc WHERE tc.lastUpdate > :last_update")
    List<TestCase> findByLastUpdateAfter(@Param("last_update") LocalDate last_update);
}
