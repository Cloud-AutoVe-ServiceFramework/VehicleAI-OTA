package kr.re.etri.advcloud.mapper;

import java.util.List;

import kr.re.etri.advcloud.common.annotation.Mapper;
import kr.re.etri.advcloud.model.AdvehicleSWVO;

@Mapper("advehicleSWMapper")
public interface AdvehicleSWMapper {

	List<AdvehicleSWVO> selectList(AdvehicleSWVO parameter);

	List<AdvehicleSWVO> selectDownloadList(AdvehicleSWVO parameter);

	AdvehicleSWVO selectDuplicateRow(AdvehicleSWVO parameter);

	AdvehicleSWVO selectById(int sw_serial);

	int insert(AdvehicleSWVO parameter);

	int update(AdvehicleSWVO parameter);

	int delete(AdvehicleSWVO parameter);

}
