package hello;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

	 List<Message> findAllByUser(User customer);
}