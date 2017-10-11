package app;

import entities.model.*;
import service.api.BatchService;
import service.api.Service;
import service.impl.BatchServiceImpl;
import service.impl.ServiceImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ShampooCompany {
    private Service<BasicIngredient, Long> basicIngredientService = new ServiceImpl<>();
    private Service<BasicShampoo, Long> basicShampooService = new ServiceImpl<>();
    private BatchService productionBatchService = new BatchServiceImpl();

    public static void main(String[] args) {
        ShampooCompany app = new ShampooCompany();
        app.run();
    }

    private void run() {

        BasicIngredient i1 = new Mint();
        BasicIngredient i2 = new Mint();
        i2.setPrice(BigDecimal.valueOf(1));
        BasicIngredient i3 = new Strawberry();
        BasicIngredient i4 = new AmoniumCloride();
        basicIngredientService.save(i1);
        basicIngredientService.save(i2);
        basicIngredientService.save(i3);
        basicIngredientService.save(i4);

        BasicIngredient b1 = basicIngredientService.findById(BasicIngredient.class, 1l);
        BasicIngredient b2 = basicIngredientService.findById(BasicIngredient.class, 2l);
        BasicIngredient b3 = basicIngredientService.findById(BasicIngredient.class, 3l);
        BasicIngredient b4 = basicIngredientService.findById(BasicIngredient.class, 4l);

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
        List<ProductionBatch> batches = productionBatchService.findAll(ProductionBatch.class);
        productionBatchService.printBatch(batch);
        System.out.println("batchess");
    }
}
