package kr.co.dafarm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.dafarm.bean.SellerProductBean;
import kr.co.dafarm.mapper.SellerProductMapper;

@Repository
public class SellerProductDao {
	
	@Autowired
	private SellerProductMapper sellerProductMapper;
	
	public void addProductInfo(SellerProductBean addProductBean) {
		sellerProductMapper.addProductInfo(addProductBean);
	}
	
	public List<SellerProductBean> getProductList(int seller_num){
		return sellerProductMapper.getProductList(seller_num);
	}
	
	public int getProductCount(int seller_num) {
		return sellerProductMapper.getProductCount(seller_num);
	}
	
	public void deleteProductInfo(int product_idx) {
		 sellerProductMapper.deleteProductInfo(product_idx);
	}
	
	public SellerProductBean getProductInfo(int product_idx) {
		System.out.println(sellerProductMapper.getProductInfo(product_idx));
		System.out.println(sellerProductMapper.getProductInfo(product_idx).getProduct_writer_num());
		return sellerProductMapper.getProductInfo(product_idx);
	}
	
	public void modifyProductInfo(SellerProductBean modifyProductBean) {
		sellerProductMapper.modifyProductInfo(modifyProductBean);
	}
	
	public void deleteProduct_payComp(int product_idx) {
		 sellerProductMapper.deleteProduct_payComp(product_idx);
	}
}
