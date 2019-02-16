package cn.hr.product.controller;

import cn.hr.product.VO.ProductInfoVO;
import cn.hr.product.VO.ProductVO;
import cn.hr.product.VO.ResultVO;
import cn.hr.product.entity.ProductCategory;
import cn.hr.product.entity.ProductInfo;
import cn.hr.product.entity.dto.CartDTO;
import cn.hr.product.service.ProductCategoryService;
import cn.hr.product.service.ProductInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @auther: fys2000
 * @Date: 2019/1/17 09:15
 * @Description:
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductInfoService productInfoService;

    @Autowired
    ProductCategoryService productCategoryService;

    /**
     * 查询所有在架商品列表
     * 查询类目对应商品列表
     * 查询所有类目
     * 构造数据
     */

    /**
     * 查询所有在架商品列表
     */
    @GetMapping("/list")
    public ResultVO listUpProduct() {
        List<ProductInfo> productInfos = productInfoService.listUpProduct();
        List<Integer> categories = productInfos.stream().map(ProductInfo::getCategoryType).distinct().collect(Collectors.toList());
        List<ProductCategory> categoryList = productCategoryService.getProductCatories(categories);
        List<ProductVO> productVOS = new ArrayList<>();
        for (ProductCategory category : categoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            List<ProductInfoVO> productInfoList = productInfos.stream()
                    .filter(productInfo -> productInfo.getCategoryType().equals(category.getCategoryType()))
                    .map(productInfo -> {
                        ProductInfoVO productInfoVO = new ProductInfoVO();
                        BeanUtils.copyProperties(productInfo, productInfoVO);
                        return productInfoVO;
                    }).collect(Collectors.toList());
            productVO.setProductInfoVOS(productInfoList);
            productVOS.add(productVO);
        }
        return ResultVO.SUCCESS(productVOS);
    }

    @PostMapping("/listByIds")
    public List<ProductInfo> listProductByIds(@RequestBody List<String> ids) {
        return productInfoService.listProductByIds(ids);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOS){
        productInfoService.decreaseStock(cartDTOS);
    }
}
