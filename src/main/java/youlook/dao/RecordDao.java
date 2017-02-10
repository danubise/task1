package youlook.dao;

import org.springframework.data.repository.CrudRepository;
import youlook.model.Record;

import javax.transaction.Transactional;

@Transactional
public interface RecordDao extends CrudRepository<Record, Integer> {

}
