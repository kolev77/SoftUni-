package kolev.exam.services.api;

import kolev.exam.dto.products.ProductImportXmlDto;
import kolev.exam.entities.Branch;
import kolev.exam.entities.Product;

import java.util.List;

public interface ProductService {
    String add(ProductImportXmlDto productImportXmlDto);
    List<Product> findByBranch(Branch branch);
}
