package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kr.co.dafarm.bean.UserCartBean;

@Mapper
public interface UserCartMapper {
	
	
	@Insert("insert into cart (cart_num, user_num, user_name, product_name, product_price, "
			+ "product_weight, product_quantity, product_writer_num, product_idx, product_date) "
			+ "values (cart_seq.nextval, #{user_num}, #{user_name}, #{product_name}, #{product_price}, "
			+ "#{product_weight}, #{product_quantity}, #{product_writer_num}, #{product_idx}, #{product_date})")
	void addCartInfo(UserCartBean addCartBean);
	
	// 장바구니 조회
	@Select("select * from cart where user_num = #{user_num}")
	List<UserCartBean> select_cart_table(int user_num);
	
	// 장바구니에서 사용자가 삭제하는것
	@Delete("delete from cart where cart_num = #{cart_num} and user_num = #{user_num}")
	void delete_cart(@Param("cart_num")int cart_num, @Param("user_num")int user_num);
	
	// 결제 완료 이후 결제된 상품 삭제하는것
	@Delete("delete from cart where user_num = #{user_num}")
	void paySuccess_delete(@Param("cart_num")int cart_num, @Param("user_num")int user_num);
}
