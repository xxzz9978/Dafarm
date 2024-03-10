package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import kr.co.dafarm.bean.UserInformationBean;
import kr.co.dafarm.bean.UserProductBean;

@Mapper
public interface UserTradeMapper {

	@Select("select * from product_table")
	List<UserProductBean> select_product_table();

	@Select("select * from product_table where product_idx = #{product_idx}")
	UserProductBean select_one_product_table(int product_idx);

	@Select("select * from seller_order_table where user_num = #{user_num}")
	List<UserInformationBean> trackingshipment(int user_num);

}
