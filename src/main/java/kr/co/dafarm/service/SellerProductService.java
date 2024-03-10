package kr.co.dafarm.service;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.co.dafarm.bean.SellerBean;
import kr.co.dafarm.bean.SellerProductBean;
import kr.co.dafarm.dao.SellerProductDao;

@Service
public class SellerProductService {

	@Value("${path.upload}")
	private String path_upload;

	@Autowired
	SellerProductDao sellerProductDao;

	@Resource(name = "loginSellerBean")
	private SellerBean loginSellerBean;

	// 파일 저장 메서드
	private String saveUploadFile(MultipartFile upload_file) {

		// 경로 시스템 오류시
		String file_name = System.currentTimeMillis() + "_"
				+ FilenameUtils.getBaseName(upload_file.getOriginalFilename()) + "."
				+ FilenameUtils.getExtension(upload_file.getOriginalFilename());

		try {
			upload_file.transferTo(new File(path_upload + "/" + file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return file_name;
	}

	public void addProductInfo(SellerProductBean addProductBean) {

		MultipartFile upload_file = addProductBean.getUpload_file();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			System.out.println(file_name);
			addProductBean.setProduct_image(file_name);
		}
		addProductBean.setProduct_writer_num(loginSellerBean.getSeller_num());
		sellerProductDao.addProductInfo(addProductBean);
	}
	
	public List<SellerProductBean> getProductList(int seller_num){
		return sellerProductDao.getProductList(seller_num);
	}
	
	public int getProductCount(int seller_num) {
		return sellerProductDao.getProductCount(seller_num);
	}
	
	public SellerProductBean getProductInfo(int product_idx) {
		System.out.println(sellerProductDao.getProductInfo(product_idx));
		System.out.println(sellerProductDao.getProductInfo(product_idx).getProduct_writer_num());
		return sellerProductDao.getProductInfo(product_idx);
	}
	
	public void deleteProductInfo(int product_idx) {
		sellerProductDao.deleteProductInfo(product_idx);
	}
	
	public void modifyProductInfo(SellerProductBean modifyProductBean) {
		MultipartFile upload_file = modifyProductBean.getUpload_file();

		if (upload_file.getSize() > 0) {
			String file_name = saveUploadFile(upload_file);
			System.out.println(file_name);
			modifyProductBean.setProduct_image(file_name);
		}
		modifyProductBean.setProduct_writer_num(loginSellerBean.getSeller_num());
		sellerProductDao.modifyProductInfo(modifyProductBean);
	}
	
	public void deleteProduct_payComp(int product_idx) {
		sellerProductDao.deleteProduct_payComp(product_idx);
	}
}
