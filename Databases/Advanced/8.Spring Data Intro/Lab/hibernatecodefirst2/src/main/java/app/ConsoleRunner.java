package app;

import app.entities.model.*;
import app.service.api.IngredientService;
import app.service.api.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Transactional
public class ConsoleRunner implements CommandLineRunner{

    private final ShampooService basicShampooService;
    private final IngredientService basicIngredientService;

    @Autowired
    public ConsoleRunner(ShampooService basicShampooService, IngredientService basicIngredientService) {
        this.basicShampooService = basicShampooService;
        this.basicIngredientService = basicIngredientService;
    }

    @Override
    public void run(String... strings) throws Exception {
        BasicIngredient i1 = new Mint();
        BasicIngredient i2 = new Mint();
        i2.setPrice(BigDecimal.valueOf(1));
        BasicIngredient i3 = new Strawberry();
        BasicIngredient i4 = new AmoniumCloride();
        basicIngredientService.save(i1);
        basicIngredientService.save(i2);
        basicIngredientService.save(i3);
        basicIngredientService.save(i4);

        BasicIngredient b1 = basicIngredientService.findById(1l);
        BasicIngredient b2 = basicIngredientService.findById(2l);
        BasicIngredient b3 = basicIngredientService.findById(3l);
        BasicIngredient b4 = basicIngredientService.findById(4l);

        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(i1);
        ingredients.add(i2);
        ingredients.add(i3);

        ProductionBatch batch = new ProductionBatch();
        ClassicLabel label = new ClassicLabel("Fresh");
        BasicShampoo shampoo = new FreshNuke(label);
        shampoo.setBatch(batch);
        shampoo.setIngredients(ingredients);
        basicShampooService.save(shampoo);
//        List<ProductionBatch> batches = productionBatchService.findAll(ProductionBatch.class);
//        productionBatchService.printBatch(batch);
        List<BasicIngredient> byNameEndingWith = basicIngredientService.findByNameEndingWith("nt");
        List<BasicShampoo> basicShampoos = basicShampooService.shampooByIngredient(i1);
        System.out.println("batchess");
    }
}
