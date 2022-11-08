package kr.re.etri.advcloud.controller.advehicle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.re.etri.advcloud.controller.ApiResponseMessage;
import kr.re.etri.advcloud.controller.CommonController;
import kr.re.etri.advcloud.model.AdvehicleInfoVO;
import kr.re.etri.advcloud.model.UserInfoVO;
import kr.re.etri.advcloud.service.AdvehicleInfoService;
import kr.re.etri.advcloud.service.UserService;

@RestController
@RequestMapping("/api/datamanager/advehicle-info")
public class AdvehicleInfoController extends CommonController {
	
	@Autowired
	AdvehicleInfoService advehicleInfoService;

	@Autowired
	UserService userService;
	
	@GetMapping("/search")
	public ResponseEntity<?> search(@ModelAttribute AdvehicleInfoVO param) {
		logger.info(">>> AdvehicleInfoSearchController search invoked...");
    	logger.info(">>> param: {}", param);
		super.param = param;

		ApiResponseMessage response = null;
		try {
			
			List<AdvehicleInfoVO> advehicleInfoList = advehicleInfoService.selectList(param);
			logger.info(">>> advehicleInfoList: {}", advehicleInfoList);
			
			response = responseSuccess(advehicleInfoService.selectList(param));
			
			logger.info(">>> response: {}", response);
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@PostMapping(value = "/add", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> add(@RequestBody AdvehicleInfoVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			// 필수 항목 체크
			if (param.getAdvehicle_id() == null || param.getUser_info_id() == null || param.getVehicle_type() == -1
					|| param.getVehicle_model() == null || param.getAdsw_package_id() == null) {
				return ResponseEntity.badRequest().build();
			}

			// 아이디 중복 체크
			AdvehicleInfoVO oldData = advehicleInfoService.select(param.getAdvehicle_id());
			if (oldData != null) {
				throw new Exception("동일한 차량 정보 아이디가 존재합니다.");
			}

			int result = advehicleInfoService.insert(param);
			if (result > 0) {
				UserInfoVO userInfoVO = userService.select(param.getUser_info_id());
				userInfoVO.setManage_vehicle_count(userInfoVO.getManage_vehicle_count() + 1);

				userService.updateManagedCount(userInfoVO);
				response = responseSuccess();
			} else {
				throw new Exception("차량 정보가 등록되지 않았습니다. 다시 한번 진행해주세요.");
			}
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@PutMapping(value = "/update/{advehicle_id}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<?> update(@PathVariable String advehicle_id, @RequestBody AdvehicleInfoVO param) {
		super.param = param;

		ApiResponseMessage response = null;
		try {
			// 필수 항목 체크 (차량 정보 ID)
			if (advehicle_id == null) {
				return ResponseEntity.badRequest().build();
			}

			advehicleInfoService.update(advehicle_id, param);

			response = responseSuccess();
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
	@DeleteMapping(value = "/delete/{advehicle_id}")
	public ResponseEntity<?> delete(@PathVariable String advehicle_id) {
		super.param = advehicle_id;

		ApiResponseMessage response = null;
		try {
			if (advehicle_id == null) {
				return ResponseEntity.badRequest().build();
			}

			AdvehicleInfoVO oldData = advehicleInfoService.select(advehicle_id);
			int result = advehicleInfoService.delete(advehicle_id);
			if (result > 0) {
				UserInfoVO userInfoVO = userService.select(oldData.getUser_info_id());
				userInfoVO.setManage_vehicle_count(userInfoVO.getManage_vehicle_count() - 1);

				userService.updateManagedCount(userInfoVO);
			}

			response = responseSuccess();
		} catch (Exception e) {
			response = responseError(e.getMessage());
		}

		return ResponseEntity.ok(response);
	}
	
}
