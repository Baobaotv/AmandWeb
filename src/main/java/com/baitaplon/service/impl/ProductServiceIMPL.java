package com.baitaplon.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.baitaplon.controller.admin.form.productForm;
import com.baitaplon.dto.ProductDTO;
import com.baitaplon.entity.CategoryEntity;
import com.baitaplon.entity.InventoryEntity;
import com.baitaplon.entity.ProductEntity;
import com.baitaplon.entity.SizeEntity;
import com.baitaplon.repository.CategoryRepository;
import com.baitaplon.repository.InventoryRepository;
import com.baitaplon.repository.ProductRepository;
import com.baitaplon.repository.SizeRepository;
import com.baitaplon.service.ProductService;

@Service
public class ProductServiceIMPL implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SizeRepository sizeRepository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private InventoryRepository inventoryRepository;

	public String save(productForm form) {

		SizeEntity size = sizeRepository.findSizeById(form.getSizeId());

		CategoryEntity category = categoryRepository.findCategoryById(form.getCategoryId());

		if (!Objects.nonNull(size.getId())) {
			return "Size not found";
		}

		if (!Objects.nonNull(category.getId())) {
			return "Category not found";
		}
		String img = "";
		if(StringUtils.isNotEmpty(form.getFiles().getOriginalFilename())) {
			MultipartFile multipartFile = form.getFiles();
			String fileName = multipartFile.getOriginalFilename();
			File file = new File("D:/files");
			if (!file.exists()) {
				file.mkdir();
			}
			File file1 = new File("D:/files/" + fileName);
			
			try {
				multipartFile.transferTo(file1);
				img = encodeFileToBase64Binary(file1);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		ProductEntity e = new ProductEntity();
		if(Objects.nonNull(form.getId())) {
			e= productRepository.findOneById(form.getId());
			e.setId(form.getId());
			e.setName(form.getNameProduct());
			e.setCategoryId(category);
			if(Objects.nonNull(form.getFiles())&&form.getFiles().getSize()!=0) {
				e.setImage(img);
			}
			e.setModifiedDate(new Date());
			e.setCreatedDate(new Date());
			e.setMemo(form.getMemo());
			e.setSizeId(size);
			e.setPrice(Integer.valueOf(form.getPrice()));
			e.setCode(form.getCodeProduct());
		}else {
			e.setName(form.getNameProduct());
			e.setCategoryId(category);
			e.setImage(img);
			e.setIsDelete("0");
			e.setCreatedDate(new Date());
			e.setMemo(form.getMemo());
			e.setSizeId(size);
			e.setPrice(Integer.valueOf(form.getPrice()));
			e.setCode(form.getCodeProduct());
		}
		

		

		ProductEntity product= productRepository.save(e);
		InventoryEntity inventory=null ;
		inventory=	inventoryRepository.findOneByProductId(product.getId());
		if(inventory==null) {
			inventory=new InventoryEntity();
			inventory.setProductCode(product.getCode());
			inventory.setProductId(product.getId());
			inventory.setQty(form.getAmount());
		}
		else {
			inventory.setQty(form.getAmount());
		}
		
		
		inventoryRepository.save(inventory);
		return "done";

	}

	private String encodeFileToBase64Binary(File file) {
		FileInputStream fileInputStreamReader;
		String img = "";
		try {
			fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			img = new String(Base64.encodeBase64(bytes), "UTF-8");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}

	@Override
	public List<ProductDTO> getAllProduct() {
		List<ProductEntity> lstPrd = productRepository.findAllProductByIsDelete("0");
		List<ProductDTO> lDto = convertToDto(lstPrd);
		
		return lDto;
	}
	
	List<ProductDTO> convertToDto(List<ProductEntity> lst) {
		
		List<ProductDTO> lstDto = new ArrayList<ProductDTO>();
		ProductDTO dto = null;
		for(ProductEntity e:lst) {
			dto = new ProductDTO();
			dto.setId(e.getId());
			dto.setName(e.getName());
			dto.setPrice(e.getPrice());
			dto.setMemo(e.getMemo());
			dto.setCategoryId(e.getCategoryId().getId().toString());
			dto.setSizeId(e.getSizeId().getId().toString());
			dto.setImage(e.getImage());
			dto.setCode(e.getCode());
			if(inventoryRepository.findOneByProductId(dto.getId())!=null) {
				dto.setQty(inventoryRepository.findOneByProductId(dto.getId()).getQty());
			}
			
		
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			  
			dto.setCreatedDate(dateFormat.format(e.getCreatedDate()));
			/* dto.setCreatedDate(e.getCreatedDate()); */
			lstDto.add(dto);
		}
		
		return lstDto;
		
	}
	
	public String convertStringToImage(String base64) {
		String imgDecode = "";
        try {
            byte[] imageByteArray = decodeImage(base64);
            
            imgDecode = new String(imageByteArray);
           return imgDecode;

        } catch (Exception e) {
            e.printStackTrace();
        }
		return imgDecode;
    }
	
	public static byte[] decodeImage(String imageDataString) {
        return Base64.decodeBase64(imageDataString);
    }

	@Override
	public List<ProductDTO> getAllByCategory(String code) {
		List<ProductEntity> lstPrd = productRepository.findAllByCategory(code, "0");
		List<ProductDTO> lDto = convertToDto(lstPrd);
		return lDto;
	}

	@Override
	public ProductDTO findOneById(Long id) {
		ProductEntity productEntity= productRepository.findOne(id);
		ProductDTO dto = new ProductDTO();
			dto.setId(productEntity.getId());
			dto.setName(productEntity.getName());
			dto.setPrice(productEntity.getPrice());
			dto.setMemo(productEntity.getMemo());
			dto.setCategoryId(productEntity.getCategoryId().getId().toString());
			dto.setSizeId(productEntity.getSizeId().getId().toString());
			dto.setImage(productEntity.getImage());
			dto.setCode(productEntity.getCode());
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");   
			dto.setCreatedDate(dateFormat.format(productEntity.getCreatedDate()));
		return dto;
	}

	@Override
	public String delete(List<String> ids) {
		try {
			Integer i= productRepository.deleteProduct(ids);
			if(i>0) {
				return "done";
			}else {
				return "false";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
	
	}

	@Override
	public ProductDTO findOneRandomProduct() {
		ProductEntity productEntity= productRepository.findOneRandomProduct();
		ProductDTO productDTO= new ProductDTO();
		productDTO.setName(productEntity.getName());
		productDTO.setCategoryId(productEntity.getCode());
		productDTO.setCategoryId( String.valueOf(productEntity.getCategoryId()));
		productDTO.setSizeId(String.valueOf(productEntity.getSizeId()));
		productDTO.setId(productEntity.getId());
		productDTO.setImage(productEntity.getImage());
		productDTO.setMemo(productEntity.getMemo());
		productDTO.setPrice(productEntity.getPrice());
		productDTO.setCode(productEntity.getCode());
		return productDTO;
	}

	@Override
	public List<ProductDTO> findAllByCategoryId(List<Long> ids) {
		List<ProductEntity> lstPrd = productRepository.findAllByCategoryId(ids);
		List<ProductDTO> lDto = convertToDto(lstPrd);
		
		return lDto;
	}



}
