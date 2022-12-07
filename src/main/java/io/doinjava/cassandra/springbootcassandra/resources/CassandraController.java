 package io.doinjava.cassandra.springbootcassandra.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.doinjava.cassandra.springbootcassandra.entities.UserData;
import io.doinjava.cassandra.springbootcassandra.exceptions.UserNotFoundException;
import io.doinjava.cassandra.springbootcassandra.repositories.UserDataRepository;

@RestController
@RequestMapping("/cassandrademo")
public class CassandraController {

	@Autowired
	private UserDataRepository repository;
	
	@PostMapping("/users")
	public ResponseEntity<String> craeteUser(@RequestBody UserData user)
	{
		UserData userCreated=repository.save(user);
		System.out.println("User Created :: "+userCreated.toString());
		return new ResponseEntity<String>("User Created!!",HttpStatus.CREATED);
		
	}
	
	@GetMapping("/users")
	public List<UserData> getAllUserDetails(){
		List<UserData> userList=repository.findAll();		
		return userList;
	}
	
	@GetMapping("/users/{firstName}")
	public UserData getUserDetails(@PathVariable String firstName){
		Optional<UserData> userOps=repository.findUserDataByFirstName(firstName);
		UserData user=userOps.isPresent()?userOps.get():null;
		
		if(user==null)
			throw new UserNotFoundException("User not found for firstName-"+firstName);
		else
			System.out.println("User by firstname :: "+user.toString());
		
		return user;
	}
	
	@PutMapping("/users")
	public ResponseEntity<UserData> updateUser(@RequestBody UserData user)
	{
		UserData userCreated=repository.save(user);
		System.out.println("User Created :: "+userCreated.toString());
		return new ResponseEntity<UserData>(userCreated,HttpStatus.OK);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable int id)
	{
		repository.deleteById(id);
		return new ResponseEntity<String>("User Deleted!!",HttpStatus.OK);
	}
}
