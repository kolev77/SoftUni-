package app.service.api;

import app.entities.model.BasicIngredient;
import app.entities.model.BasicShampoo;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShampooService {

    BasicShampoo findById(Long id);

    void remove(BasicShampoo object);

    List<BasicShampoo> findAll();

    void save(BasicShampoo object);

    List<BasicShampoo> shampooByIngredient(BasicIngredient ingredient);
}
