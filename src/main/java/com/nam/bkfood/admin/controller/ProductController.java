package com.nam.bkfood.admin.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nam.bkfood.model.ProductDTO;
import com.nam.bkfood.model.SearchProductDTO;
import com.nam.bkfood.model.SearchSubCategoryDTO;
import com.nam.bkfood.model.SubCategoryDTO;
import com.nam.bkfood.service.ProductService;
import com.nam.bkfood.service.SubCategoryService;

@Controller
@RequestMapping(value="/admin")
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	SubCategoryService subCategoryService;
	
	private String UPLOAD_DIR = "/home/namnguyen/project/bkfood/src/main/resources/templates/admin/product/upload";

	
	@GetMapping(value="/list-product")
	public String listProduct(Model model){
		SearchProductDTO searchProductDTO=new SearchProductDTO();
		List<ProductDTO> listProductDTO=productService.findProduct(searchProductDTO);
		model.addAttribute("listProduct",listProductDTO);
		model.addAttribute("searchProductDTO",searchProductDTO);
		model.addAttribute("count", productService.coutProduct(searchProductDTO));
		return "admin/product/listProduct";
	}

	@GetMapping("/search-product")
	public String searchProduct(Model model, @ModelAttribute("searchProductDTO") SearchProductDTO searchProductDTO) {
		List<ProductDTO> productDTOs = productService.findProduct(searchProductDTO);
		model.addAttribute("listProduct", productDTOs);
		model.addAttribute("searchProductDTO", searchProductDTO);
		model.addAttribute("count", productService.coutProduct(searchProductDTO));
		return "admin/product/listProduct";
	}
	
	@GetMapping("/add-product")
	public String addProduct(Model model){
		ProductDTO productDTO=new ProductDTO();
		model.addAttribute("listSubCategory",subCategoryService.findSubCategory(new SearchSubCategoryDTO()));
		model.addAttribute("addProductForm",productDTO);
		return "admin/product/addProduct";
	}
	
	@PostMapping("/add-product")
	public String addProduct(@ModelAttribute("addProductForm") ProductDTO productDTO,@RequestParam("file") MultipartFile multipartFile) throws IOException{
		String originalFilename = multipartFile.getOriginalFilename();
		String onlyFileName = originalFilename.substring(0, originalFilename.length() - 4);
		File destinationFile = new File(UPLOAD_DIR + File.separator + onlyFileName + ".jpg");
		if (!destinationFile.exists()) {
			destinationFile.createNewFile();
			multipartFile.transferTo(destinationFile);
			productDTO.setImage(onlyFileName);
			productService.addProduct(productDTO);
		}
		return "redirect:/admin/list-product";
	}
	
	@GetMapping("/product-detail/{id}")
	public String viewDetailProduct(Model model,@PathVariable(name="id")Long id){
		ProductDTO productDTO=productService.getProductById(id);
		model.addAttribute("product",productDTO);
		
		return "admin/product/viewproduct";
	}
	
	@GetMapping("/update-product/{id}")
	public String updateProduct(Model model,@PathVariable(name="id")Long id){		
		ProductDTO productDTO=productService.getProductById(id);
		model.addAttribute("updateProductForm",productDTO);
		model.addAttribute("listSubCategory",subCategoryService.findSubCategory(new SearchSubCategoryDTO()));
		return "admin/product/updateProduct";
	}
	
	@PostMapping("/update-product")
	public String updateProduct(@ModelAttribute("updateProductForm")ProductDTO productDTO,@RequestParam("file")MultipartFile multipartFile) throws IOException{
		String originalFilename = multipartFile.getOriginalFilename();
		String onlyFileName = originalFilename.substring(0, originalFilename.length() - 4);
		File destinationFile = new File(UPLOAD_DIR + File.separator + onlyFileName + ".jpg");
		if (!destinationFile.exists()) {
			destinationFile.createNewFile();
			multipartFile.transferTo(destinationFile);
			productDTO.setImage(onlyFileName);
			productService.updateProduct(productDTO);
		}
		return "redirect:/admin/list-product";
		
	}
	
	@GetMapping("/delete-product/{id}")
	public String deleteProduct(@PathVariable(name="id")Long id){		
		ProductDTO productDTO=productService.getProductById(id);
		if(productDTO!=null){
			productService.deleteProduct(productDTO);
		}
		return "redirect:/admin/list-product";
	}

	

}
