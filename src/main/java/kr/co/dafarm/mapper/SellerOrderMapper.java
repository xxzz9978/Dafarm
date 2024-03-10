package kr.co.dafarm.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.session.RowBounds;

import kr.co.dafarm.bean.SellerOrderBean;

public interface SellerOrderMapper {
	
	@SelectKey(statement="select order_seq.nextval from dual", keyProperty = "order_number", 
			before = true, resultType = int.class)

	// 주문 데이터를 주문 테이블에 추가하는 쿼리 - (최종 수정 : 김지섭)
	@Insert("insert into seller_order_table(order_number, order_status, order_date, delivery_company, delivery_number, seller_name, seller_phone, item_name, "
			+ "user_name, user_phone, address, seller_num, user_num) "
			+ "values (order_seq.nextval, '결제완료', #{order_date}, '배송 준비중', '배송 준비중', #{seller_name}, #{seller_phone}, "
			+ "#{item_name}, #{user_name}, #{user_phone}, #{address}, #{seller_num}, #{user_num})")
	void addOrderInfo(SellerOrderBean addOrderBean);
	
	// 주문 테이블에서 판매자 고유 번호를 조회해 해당 값을 반환하는 쿼리 (rowbounds 없음)
	@Select("select order_number, order_status, TO_CHAR(order_date, 'YYYY-MM-DD') AS order_date, delivery_company, "
			+ "delivery_number, seller_name, seller_phone, item_name, user_name, user_phone, "
			+ "address,  seller_num, user_num "
			+ "from seller_order_table "
			+ "where seller_num = #{seller_num} "
			+ "order by order_number asc")
	List<SellerOrderBean> getOrderListVanila(@Param("seller_num") int seller_num);
	
	// 주문 테이블에서 판매자 고유 번호를 조회해 해당 값을 반환하는 쿼리
	@Select("select order_number, order_status, TO_CHAR(order_date, 'YYYY-MM-DD') AS order_date, delivery_company, "
			+ "delivery_number, seller_name, seller_phone, item_name, user_name, user_phone, "
			+ "address,  seller_num, user_num "
			+ "from seller_order_table "
			+ "where seller_num = #{seller_num} "
			+ "order by order_number asc")
	List<SellerOrderBean> getOrderList(@Param("seller_num") int seller_num, RowBounds rowBounds);
	
	// 주문 테이블에서 판매자 고유 번호와 주문상태를 조회해 해당 값을 반환하는 쿼리
	@Select("select order_number, order_status, TO_CHAR(order_date, 'YYYY-MM-DD') AS order_date, delivery_company, "
			+ "delivery_number, seller_name, seller_phone, item_name, user_name , user_phone , "
			+ "address, seller_num, user_num "
			+ "from seller_order_table "
			+ "where seller_num = #{seller_num} and order_status = #{order_status} "
			+ "order by order_number asc")
	List<SellerOrderBean> getOrderByStatus(@Param("seller_num") int seller_num, @Param("order_status") String order_status, RowBounds rowBounds);
	
	// 주문 테이블에서 판매자 고유 번호와 특정 날짜를 조회해 해당 값을 반환하는 쿼리
	@Select("select order_number, order_status, TO_CHAR(order_date, 'YYYY-MM-DD') AS order_date, delivery_company, "
			+ "delivery_number, seller_name, seller_phone, item_name, user_name, user_phone, "
			+ "address, seller_num, user_num "
			+ "from seller_order_table "
			+ "where seller_num = #{seller_num} and order_date like #{order_date}")
	List<SellerOrderBean> getOrderListByDate(@Param("seller_num") int seller_num, @Param("order_date") String order_date);
	
	// 주문 테이블에서 판매자 고유 번호와 특정 기간을 조회해 해당 값을 반환하는 쿼리
	@Select("select order_number, order_status, TO_CHAR(order_date, 'YYYY-MM-DD') AS order_date, delivery_company, "
			+ "delivery_number, seller_name, seller_phone, item_name, user_name, user_phone, "
			+ "address, seller_num, user_num "
			+ "from seller_order_table "
			+ "where seller_num = #{seller_num} and order_date between #{order_date_from} and #{order_date_to}")
	List<SellerOrderBean> getOrderListByBetweenDate(@Param("seller_num") int seller_num, @Param("order_date_from") String order_date_from, @Param("order_date_to") String order_date_to);
	
	// 주문 테이블에서 판매자 고유 번호를 조회해 그 데이터들의 수를 반환하는 쿼리
	@Select("select count(*) as cnt "
			+ "from seller_order_table "
			+ "where seller_num = #{seller_num}")
	int getOrderCount(@Param("seller_num") int seller_num);
	
	// 주문 테이블에서 판매자 고유 번호와 주문상태를 조회해 데이터들의 수를 반환하는 쿼리
	@Select("select count(*) as cnt "
			+ "from seller_order_table "
			+ "where seller_num = #{seller_num} and order_status = #{order_status}")
	int getOrderCountByStatus(@Param("seller_num") int seller_num, @Param("order_status") String order_status);
	
}
