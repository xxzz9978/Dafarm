package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import kr.co.dafarm.bean.SellerProductBean;

public interface SellerProductMapper {

	@SelectKey(statement = "select product_seq.nextval from dual", keyProperty = "product_idx", before = true, resultType = int.class)

	@Insert("insert into product_table(product_name, product_price, product_weight, product_quantity, "
			+ "product_image, product_description, agreement, product_writer_num, product_idx, product_date) "
			+ "values (#{product_name}, #{product_price}, #{product_weight}, #{product_quantity}, "
			+ "#{product_image, jdbcType=VARCHAR}, #{product_description}, #{agreement}, #{product_writer_num}, product_seq.nextval, sysdate)")
	void addProductInfo(SellerProductBean addProductBean);

	@Select("select a1.product_idx, a1.product_name, a1.product_weight, a1.product_quantity, TO_CHAR(a1.product_price, '999,999,999,999,999') AS product_price, "
			+ "a2.business_name as content_writer_name, to_char(a1.product_date, 'YYYY-MM-DD') as product_date "
			+ "from product_table a1, seller_business_table a2 "
			+ "where a1.product_writer_num = #{seller_num} and a2.seller_num = #{seller_num} "
			+ "order by a1.product_idx desc")
	List<SellerProductBean> getProductList(int seller_num);

	@Select("SELECT COUNT(*) as cnt FROM product_table a1, seller_business_table a2 where a1.product_writer_num = #{seller_num} and a2.seller_num = #{seller_num}")
	int getProductCount(int seller_num);

	@Delete("delete from product_table where product_idx = #{product_idx}")
	void deleteProductInfo(int product_idx);

	@Select("select a2.business_name as product_writer_name, "
			+ "to_char(a1.product_date, 'YYYY-MM-DD')as product_date, "
			+ "a1.product_name, a1.product_price, a1.product_weight, a1.product_quantity, a1.product_description, a1.product_image "
			+ "from product_table a1, seller_business_table a2 "
			+ "where a1.product_writer_num = a2.seller_num and a1.product_idx = #{product_idx}")
	SellerProductBean getProductInfo(int product_idx);

	@Update("update product_table set product_name = #{product_name}, product_quantity=#{product_name}, product_weight=#{product_weight}, product_price=#{product_price}, product_description=#{product_description}, "
			+ "product_image=#{product_image, jdbcType=VARCHAR} where product_idx = #{product_idx}")
	void modifyProductInfo(SellerProductBean modifyProductBean);

	// 결제된 상품 삭제 (김지섭 추가)
	@Delete("delete from product_table where product_idx = #{product_idx}")
	void deleteProduct_payComp(int product_idx);

}
