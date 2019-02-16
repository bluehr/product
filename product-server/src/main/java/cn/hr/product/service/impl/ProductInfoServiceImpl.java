package cn.hr.product.service.impl;

import cn.hr.product.dao.ProductInfoDao;
import cn.hr.product.entity.ProductInfo;
import cn.hr.product.entity.dto.CartDTO;
import cn.hr.product.enums.ProductStatusEnum;
import cn.hr.product.enums.ResultEnum;
import cn.hr.product.exception.ProductException;
import cn.hr.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author fys2000
 * @Date: 2019/1/18 15:04
 * @Description:
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {
    @Autowired
    private ProductInfoDao productInfoDao;

    @Override
    public List<ProductInfo> listUpProduct(){
        return productInfoDao.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo>
    listProductByIds(List<String> ids) {
        return productInfoDao.findAllById(ids);
    }

    /**
     * 扣库存
     * @param cartDTOS
     */
    @Override
    @Transactional(rollbackOn = Exception.class)
    public void decreaseStock(List<CartDTO> cartDTOS) {
        cartDTOS.forEach(cartDTO ->{
            Optional<ProductInfo> optionalInfo = productInfoDao.findById(cartDTO.getProductId());
            if (!optionalInfo.isPresent()) {
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = optionalInfo.get();
            int i = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if (i < 0) {
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }
            productInfo.setProductStock(i);
            productInfoDao.save(productInfo);
        });

    }
}
