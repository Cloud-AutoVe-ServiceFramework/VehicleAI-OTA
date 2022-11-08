package kr.re.etri.advcloud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.re.etri.advcloud.mapper.AdvehicleInfoMapper;
import kr.re.etri.advcloud.model.AdvehicleInfoVO;

@Service
public class AdvehicleInfoService {

	@Autowired
	AdvehicleInfoMapper advehicleInfoMapper;

	public List<AdvehicleInfoVO> selectList(AdvehicleInfoVO param) throws Exception {
		return advehicleInfoMapper.selectList(param);
	}

	public AdvehicleInfoVO select(String advehicle_id) throws Exception {
		return advehicleInfoMapper.select(advehicle_id);
	}

	public int insert(AdvehicleInfoVO param) throws Exception {
		return advehicleInfoMapper.insert(param);
	}

	public int update(String advehicle_id, AdvehicleInfoVO param) throws Exception {
		param.setAdvehicle_id(advehicle_id);
		return advehicleInfoMapper.update(param);
	}

	public int delete(String advehicle_id) throws Exception {
		return advehicleInfoMapper.delete(advehicle_id);
	}

}
