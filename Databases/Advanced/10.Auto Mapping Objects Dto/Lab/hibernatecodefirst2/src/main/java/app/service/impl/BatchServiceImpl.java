package app.service.impl;

import app.dao.api.BatchDao;
import app.entities.ProductionBatch;
import app.service.api.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@Transactional
public class BatchServiceImpl implements BatchService {

    private final BatchDao batchDao;

    @Autowired
    public BatchServiceImpl(BatchDao batchDao) {
        this.batchDao = batchDao;
    }

    @Override
    public void save(ProductionBatch object) {
        batchDao.save(object);
    }

    @Override
    public List<ProductionBatch> findByDateAfter(Date date) {
        return batchDao.findByDateAfter(date);
    }


    // Problem 9
    @Override
    public List<ProductionBatch> findAllByShampoosIsNull() {
        return batchDao.findAllByShampoosIsNull();
    }
}
