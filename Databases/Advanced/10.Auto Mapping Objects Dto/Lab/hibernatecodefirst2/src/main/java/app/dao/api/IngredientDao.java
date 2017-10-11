package app.dao.api;

import app.entities.BasicIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface IngredientDao extends JpaRepository<BasicIngredient, Long> {

    List<BasicIngredient> findByNameEndingWith(String suffix);

    //Problem 8
    List<BasicIngredient> findAllByNameInOrderByPriceAsc(Collection<String> name);

    //Problem 12 - JPQL
    @Query(value = "SELECT bi FROM BasicIngredient AS bi WHERE bi.name IN :namesList ORDER BY bi.id DESC ")
    List<BasicIngredient> findByNameIn(@Param("namesList") List<String> names);

    //Problem 21
    @Query(value = "DELETE FROM BasicIngredient AS b where b.name = :name")
    @Modifying
    void deleteIngByName(@Param("name")String name);

    //Problem 22
    @Modifying
    @Query("UPDATE BasicIngredient AS b SET b.price = b.price * 1.10")
    void updateIngPrice();
}
