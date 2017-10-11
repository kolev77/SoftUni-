package kolev.exam.services.impl;

import kolev.exam.constants.ResultMessages;
import kolev.exam.dto.products.ProductImportXmlDto;
import kolev.exam.entities.Branch;
import kolev.exam.entities.Product;
import kolev.exam.repositories.BranchRepository;
import kolev.exam.repositories.ProductRepository;
import kolev.exam.services.api.ProductService;
import kolev.exam.services.api.TownService;
import kolev.exam.utils.DTOConverter;
import kolev.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final BranchRepository branchRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, BranchRepository branchRepository) {
        this.productRepository = productRepository;
        this.branchRepository = branchRepository;
    }

    @Override
    public String add(ProductImportXmlDto productImportXmlDto) {
        Product product = DTOConverter.convert(productImportXmlDto, Product.class);

        Branch branch = this.branchRepository.findByName(productImportXmlDto.getBranch());
        product.setBranch(branch);

        String result;
        if (DataValidator.isValid(product)) {
            this.productRepository.save(product);
            result = String.format(ResultMessages.SUCCESSFUL,
                    product.getClass().getSimpleName(),
                    product);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }

    @Override
    public List<Product> findByBranch(Branch branch) {
        return this.productRepository.findByBranch(branch);
    }
}
