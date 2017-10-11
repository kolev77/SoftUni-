package app;

import app.entities.*;
import app.service.api.BatchService;
import app.service.api.IngredientService;
import app.service.api.ShampooService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@Transactional
public class ConsoleRunner implements CommandLineRunner{

    private final ShampooService basicShampooService;
    private final IngredientService basicIngredientService;
    private final BatchService batchService;
    @Autowired
    public ConsoleRunner(ShampooService basicShampooService, IngredientService basicIngredientService, BatchService batchService) {
        this.basicShampooService = basicShampooService;
        this.basicIngredientService = basicIngredientService;
        this.batchService = batchService;
    }

    @Override
    public void run(String... strings) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        BasicIngredient i1 = new Mint();
        BasicIngredient i2 = new Mint();
        i2.setPrice(BigDecimal.valueOf(1));
        BasicIngredient i3 = new Strawberry();
        BasicIngredient i4 = new AmoniumCloride();
        BasicIngredient i5 = new Water();
        BasicIngredient i6 = new Water();
        basicIngredientService.save(i1);
        basicIngredientService.save(i2);
        basicIngredientService.save(i3);
        basicIngredientService.save(i4);
        basicIngredientService.save(i5);
        basicIngredientService.save(i6);

        BasicIngredient b1 = basicIngredientService.findById(1l);
        BasicIngredient b2 = basicIngredientService.findById(2l);
        BasicIngredient b3 = basicIngredientService.findById(3l);
        BasicIngredient b4 = basicIngredientService.findById(4l);

        Set<BasicIngredient> ingredients = new HashSet<>();
        ingredients.add(i1);
        ingredients.add(i2);
        ingredients.add(i3);

        ProductionBatch batch = new ProductionBatch();
        batch.setDate(sdf.parse("2010-10-10"));
        ClassicLabel label = new ClassicLabel("Fresh");
        BasicShampoo shampoo = new FreshNuke(label);
        shampoo.setBatch(batch);
        shampoo.setBrand("MaxFresh");
        shampoo.setSize(2);
        shampoo.setPrice(BigDecimal.valueOf(10));
        shampoo.setIngredients(ingredients);
        basicShampooService.save(shampoo);

        BasicShampoo shampoo2 = new FreshNuke();
        shampoo2.setBrand("H&H");
        shampoo2.setBatch(batch);
        shampoo2.setLabel(new ClassicLabel("Best"));
        shampoo2.setSize(1);
        shampoo2.setPrice(BigDecimal.valueOf(4));
        HashSet<BasicIngredient> ingset = new HashSet<>();
        ingset.add(i3);
        ingset.add(i4);
        shampoo2.setIngredients(ingset);
        basicShampooService.save(shampoo2);

        ProductionBatch batch1 = new ProductionBatch();
        batch1.setDate(sdf.parse("2012-05-10"));
        batch1.setName("summer");
        ProductionBatch batch2 = new ProductionBatch();
        batch2.setDate(sdf.parse("2015-12-24"));
        batch1.setName("winter");

        batchService.save(batch);
        batchService.save(batch1);
        batchService.save(batch2);


        //Problem 1
//        List<BasicShampoo> maxFresh = basicShampooService.findByBrand("MaxFresh");

        //Problem 2
//        List<BasicShampoo> shampoosByBrandAndSize = basicShampooService.findByBrandAndSize("H&H",1);

        //Problem 3
//        List<BasicShampoo> shampoosBySizeOrLabel = basicShampooService.findBySizeOrLabel(3,label);

        //Problem 4
//        List<BasicShampoo> shampoosByPrice = basicShampooService.findByPriceGreaterThan(BigDecimal.valueOf(5));

        //Problem 5
        //TODO: parse date

        //Problem 8
        ArrayList<String> ingredientsNames = new ArrayList<>();
        ingredientsNames.add("Mint");
        ingredientsNames.add("Strawberry");
//        List<BasicIngredient> allByNameIn = basicIngredientService.findAllByNameInOrderByPriceAsc(ingredientsNames);

        //Problem 9
//        List<ProductionBatch> allByShampoosIsNull = batchService.findAllByShampoosIsNull();

        //Problem 12
//        List<BasicIngredient> byNameIn = basicIngredientService.findByNameIn(ingredientsNames);

        //Problem 15
//       List<BasicShampoo> byBatchDate = basicShampooService.findByBatchDate(sdf.parse("2013-06-23"));

        //Problem 16
//        List<BasicShampoo> byIngPriceSum = basicShampooService.findByIngPriceSum(BigDecimal.valueOf(1.5));


        //Problem 21
//        List<BasicIngredient> all = basicIngredientService.findAll();
//        int sizeBefore = all.size();
//        basicIngredientService.deleteIngByName("Mint");
//        all = basicIngredientService.findAll();
//        int sizeAfter = all.size();
//

        //Problem 22
//        basicIngredientService.updateIngPrice();

        // Find ingredient by chemical formula
//        List<BasicChemicalIngredient> h2O = basicIngredientService.findAllByChecmicalFormula("NH4CL");

        List<BasicShampoo> byIng = basicShampooService.findByIng(i4);
        System.out.println("batchess");
    }
}
