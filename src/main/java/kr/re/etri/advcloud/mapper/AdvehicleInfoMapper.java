package kr.re.etri.advcloud.mapper;

import java.util.List;

import kr.re.etri.advcloud.common.annotation.Mapper;
import kr.re.etri.advcloud.model.AdvehicleInfoVO;

@Mapper("advehicleInfoMapper")
public interface AdvehicleInfoMapper {

	List<AdvehicleInfoVO> selectList(AdvehicleInfoVO param);

	AdvehicleInfoVO select(String advehicle_id);

	int insert(AdvehicleInfoVO param);

	int update(AdvehicleInfoVO param);

	int delete(String advehicle_id);

}
