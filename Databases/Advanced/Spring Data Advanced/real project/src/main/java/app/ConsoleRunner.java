package app;

import app.dao.api.ChemicalIngredietsDao;
import app.service.api.IngredientService;
import app.service.api.ProductionBatchService;
import app.model.*;
import app.service.api.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ConsoleRunner implements CommandLineRunner {

    private final ProductionBatchService<ProductionBatch, Long> productionBatchService;

    private final IngredientService<BasicIngredient, Long> basicIngredientService;

    private final ShampooService<BasicShampoos, Long> basicShampoosService;

    @Autowired
    public ConsoleRunner(ProductionBatchService<ProductionBatch, Long> productionBatchService, IngredientService<BasicIngredient, Long> basicIngredientService, ShampooService<BasicShampoos, Long> basicShampoosService) {
        this.productionBatchService = productionBatchService;
        this.basicIngredientService = basicIngredientService;
        this.basicShampoosService = basicShampoosService;
    }

    @Override
    public void run(String... strings) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        BasicIngredient i1 = new Mint();
        BasicIngredient i2 = new Mint();
        BasicIngredient i3 = new Strawberry();
        i1.setPrice(BigDecimal.valueOf(0.4));
        i2.setPrice(BigDecimal.valueOf(0.4));
        i3.setPrice(BigDecimal.valueOf(0.4));
        basicIngredientService.save(i1);
        basicIngredientService.save(i2);
        basicIngredientService.save(i3);

        ClassicLabel label = new ClassicLabel("Fresh Shine");
        BasicShampoos shampoo = new FreshNuke();
        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(i1);
        ingredients.add(i2);
        shampoo.setIngredients(ingredients);
        shampoo.setLabel(label);
        shampoo.setBrand("Brand1");
        shampoo.setSize(3);
        shampoo.setPrice(BigDecimal.valueOf(3.5));

        ProductionBatch batch = new ProductionBatch();
        batch.setDate(sdf.parse("2010-10-10"));
        batch.setName("FirstSeries");
        productionBatchService.save(batch);
        shampoo.setBatch(batch);
        basicShampoosService.save(shampoo);

        ProductionBatch batch1 = new ProductionBatch();
        batch1.setDate(sdf.parse("2005-10-10"));
        productionBatchService.save(batch1);
        BasicShampoos shampoo1 = new FreshNuke();
        BasicIngredient i7 = new Mint();
        BasicIngredient i8 = new Strawberry();
        i7.setPrice(BigDecimal.valueOf(15));
        i8.setPrice(BigDecimal.valueOf(15));
        basicIngredientService.save(i7);
        basicIngredientService.save(i8);
        Set<BasicIngredient> ingredients2 = new HashSet<>();
        ingredients.add(i7);
        ingredients.add(i8);

        shampoo1.setIngredients(ingredients2);

        shampoo1.setIngredients(ingredients);
        shampoo1.setBatch(new ProductionBatch());
        shampoo1.setLabel(new ClassicLabel());
        shampoo1.setBrand("Brand2");
        shampoo1.setSize(2);
        shampoo1.setPrice(BigDecimal.valueOf(6.78));
        basicShampoosService.save(shampoo1);
        ProductionBatch emptyBatch = new ProductionBatch();
        emptyBatch.setName("Empty Batch");
        productionBatchService.save(emptyBatch);
        basicShampoosService.save(shampoo);
        basicShampoosService.save(shampoo1);
//        // problem 9
//        List<ProductionBatch> byShampoosIsNull = productionBatchService.findByShampoosIsNull();
//        System.out.println(byShampoosIsNull);

        //problem 12
//        List<String> ingredientList = new ArrayList<>();
//        ingredientList.add("Strawberry");
//        List<BasicIngredient> basicIngredientServiceByNameIn = basicIngredientService.findByNameIn(ingredientList);
//        System.out.println(basicIngredientServiceByNameIn);

        //Problem 15
//        List<BasicShampoos> shampoosByBatchDate = basicShampoosService.findByBatchDate(sdf.parse("2001-10-10"));
//        System.out.println(shampoosByBatchDate);

        //Problem 16
        //        List<BasicShampoos> shampoosServiceByIngPriceSum = basicShampoosService.findByIngPriceSum(BigDecimal.valueOf(10.8));
        //        System.out.println(shampoosServiceByIngPriceSum);

        //problem 21
//        basicIngredientService.deleteByName("Strawberry");
//        System.out.println("delete");
//
//        basicIngredientService.updatePrice();
//        System.out.println("update");h

        // problem  Find by chemical formula

//        BasicIngredient nh4clInput = new AmoniumCloride();
//        basicIngredientService.save(nh4clInput);
//
//        List<BasicChemicatIngredient> nh4CL = basicIngredientService.findChemicalIngWithFormula("NH4CL");
//        System.out.println("find by formula !");


        // Problem find shampoos by Ingredient
        List<BasicShampoos> findByIngredient = basicShampoosService.findByIng(i2);
        System.out.println(findByIngredient);
    }
}
