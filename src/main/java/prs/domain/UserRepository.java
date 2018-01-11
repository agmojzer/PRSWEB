//https://spring.io/guides/gs/accessing-data-mysql/
package prs.domain;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository <User, Integer>{
	
	User findByusernameAndPassword(String uname, String pwd);

}