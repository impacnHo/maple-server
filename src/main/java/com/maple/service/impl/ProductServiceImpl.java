package com.maple.service.impl;

import com.github.pagehelper.PageHelper;
import com.maple.dao.BrandDao;
import com.maple.dao.ProductDao;
import com.maple.dao.StockDao;
import com.maple.dto.ProductDTO;
import com.maple.dto.ProductItemDTO;
import com.maple.dto.StockDTO;
import com.maple.entity.Brand;
import com.maple.entity.Product;
import com.maple.entity.Stock;
import com.maple.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("productService")
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private StockDao stockDao;
    @Autowired
    private BrandDao brandDao;

    @Override
    public List<ProductItemDTO> listProduct() {
        List<ProductItemDTO> productItemDTOList = new ArrayList<>();
        List<Product> productList = productDao.listProduct();
        ProductItemDTO productItemDTO;

        // pass
        for (Product p : productList) {
            productItemDTO = new ProductItemDTO(p.getProductNum(), p.getName(), p.getSubName(), p.getPrice(), p.getLanchDate());
            productItemDTOList.add(productItemDTO);
        }
        return productItemDTOList;
    }

    @Override
    public List<ProductItemDTO> listProductByTypeName(String typeName) {
        List<Product> productList = productDao.listProductByTypeName(typeName);
        List<ProductItemDTO> productItemDTOList = new ArrayList<>();
        ProductItemDTO productItemDTO;
        for (Product p : productList) {
            productItemDTO = new ProductItemDTO(p.getProductNum(), p.getName(), p.getSubName(), p.getPrice(), p.getLanchDate());
            productItemDTOList.add(productItemDTO);
        }
        return productItemDTOList;
    }

    @Override
    public List<ProductItemDTO> listProductBySearch(String keyword) {
        keyword = '%' + keyword + '%';
        List<Product> productList = productDao.listProductBySearch(keyword);
        List<ProductItemDTO> productItemDTOList = new ArrayList<>();
        ProductItemDTO productItemDTO;
        for (Product p : productList) {
            productItemDTO = new ProductItemDTO(p.getProductNum(), p.getName(), p.getSubName(), p.getPrice(), p.getLanchDate());
            productItemDTOList.add(productItemDTO);
        }
        return productItemDTOList;
    }

    @Override
    public ProductDTO getProduct(String productNum) {
        ProductDTO productDTO = new ProductDTO();
        Product product = productDao.getProduct(productNum);
        List<Stock> stocks = stockDao.listStock(productNum);
        List<StockDTO> stockDTOList = new ArrayList<>();
        Brand brand = brandDao.getBrandByProductNum(productNum);

        // exchange
        StockDTO stockDTO;
        for (Stock s : stocks) {
            stockDTO = new StockDTO();
            stockDTO.setId(s.getId());
            stockDTO.setName(s.getName());
            stockDTO.setQuanlity(s.getQuanlity());
            stockDTOList.add(stockDTO);
        }

        // pass
        productDTO.setName(product.getName());
        productDTO.setSubName(product.getSubName());
        productDTO.setProductNum(product.getProductNum());
        productDTO.setDescr(product.getDescr());
        productDTO.setLanchDate(product.getLanchDate());
        productDTO.setPrice(product.getPrice());
        productDTO.setBrandName(brand.getName());
        productDTO.setStocks(stockDTOList);
        return productDTO;
    }
}
