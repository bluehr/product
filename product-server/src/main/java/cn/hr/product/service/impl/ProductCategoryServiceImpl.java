package cn.hr.product.service.impl;

import cn.hr.product.dao.ProductCategoryDao;
import cn.hr.product.entity.ProductCategory;
import cn.hr.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fys2000
 * @date 2019/1/25 10:37
 * @description
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryDao productCategoryDao;
    @Override
    public List<ProductCategory> getProductCatories(List<Integer> categories) {
        List<ProductCategory> productCategories = productCategoryDao.findByCategoryTypeIn(categories);
        return productCategories;
    }
}
