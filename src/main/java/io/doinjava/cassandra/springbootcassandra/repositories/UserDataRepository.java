package io.doinjava.cassandra.springbootcassandra.repositories;

import java.util.Optional;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import io.doinjava.cassandra.springbootcassandra.entities.UserData;

@Repository
public interface UserDataRepository extends CassandraRepository<UserData, Integer> {
	
	@AllowFiltering
	public Optional<UserData> findUserDataByFirstName(String firstName);

}
