package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.dafarm.bean.UserPaymentBean;

@Mapper
public interface UserPaymentMapper {

	@Select("select a1.user_num, a1.user_name, a1.user_phone, a1.user_email, a1.user_address, "
			+ "a2.cart_num, a2.product_name, a2.product_price, a2.product_weight, a2.product_quantity, "
			+ "a2.product_writer_num, a2.product_idx, "
			+ "a3.seller_num, a3.seller_name, a3.seller_phone "
			+ "from users a1, cart a2, seller_table a3 "
			+ "where a1.user_num = #{user_num} and a1.user_num = a2.user_num and "
			+ "a2.product_writer_num = a3.seller_num")
	List<UserPaymentBean> payment_info(int user_num);
}
