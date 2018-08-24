package mvc.filters.demofilters;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogMessageRepository  extends JpaRepository<LogMessage,Long>{

}
