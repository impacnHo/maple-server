package com.maple.service.impl;

import com.maple.dao.BrandDao;
import com.maple.dto.BrandDTO;
import com.maple.entity.Brand;
import com.maple.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service("brandService")
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandDao brandDao;

    @Override
    public List<BrandDTO> listBrand() {
        List<BrandDTO> brandDTOList = new ArrayList<>();
        List<Brand> brandList = brandDao.listBrand();
        BrandDTO brandDTO;
        for (Brand b : brandList) {
            brandDTO = new BrandDTO();
            brandDTO.setId(b.getId());
            brandDTO.setName(b.getName());
            brandDTOList.add(brandDTO);
        }
        return brandDTOList;
    }

    @Override
    public BrandDTO getBrand(Integer id) {
        Brand brand = brandDao.getBrand(id);
        BrandDTO brandDTO = new BrandDTO();
        brandDTO.setId(brand.getId());
        brandDTO.setName(brand.getName());
        return brandDTO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Integer saveBrand(BrandDTO brandDTO) {
        Brand brand = new Brand();
        brand.setName(brandDTO.getName());
        brandDao.saveBrand(brand);
        return brand.getId();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateBrand(Integer id, String name) {
        return brandDao.updateBrand(id, name) != null;
    }
}
