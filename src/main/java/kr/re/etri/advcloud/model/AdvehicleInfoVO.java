package kr.re.etri.advcloud.model;

import kr.re.etri.advcloud.common.annotation.Model;
import kr.re.etri.advcloud.common.base.BaseObject;

@SuppressWarnings("serial")
@Model
public class AdvehicleInfoVO extends BaseObject {

	private String advehicle_id;
	private String user_info_id;
	private String register_date;
	private int vehicle_type = -1;
	private String vehicle_type_name;
	private String vehicle_model;
	private String adsw_package_id;

	/**
	 * @return the advehicle_id
	 */
	public String getAdvehicle_id() {
		return advehicle_id;
	}

	/**
	 * @param advehicle_id the advehicle_id to set
	 */
	public void setAdvehicle_id(String advehicle_id) {
		this.advehicle_id = advehicle_id;
	}

	/**
	 * @return the user_info_id
	 */
	public String getUser_info_id() {
		return user_info_id;
	}

	/**
	 * @param user_info_id the user_info_id to set
	 */
	public void setUser_info_id(String user_info_id) {
		this.user_info_id = user_info_id;
	}

	/**
	 * @return the register_date
	 */
	public String getRegister_date() {
		return register_date;
	}

	/**
	 * @param register_date the register_date to set
	 */
	public void setRegister_date(String register_date) {
		this.register_date = register_date;
	}

	/**
	 * @return the vehicle_type
	 */
	public int getVehicle_type() {
		return vehicle_type;
	}

	/**
	 * @param vehicle_type the vehicle_type to set
	 */
	public void setVehicle_type(int vehicle_type) {
		this.vehicle_type = vehicle_type;
	}

	/**
	 * @return the vehicle_type_name
	 */
	public String getVehicle_type_name() {
		return vehicle_type_name;
	}

	/**
	 * @param vehicle_type_name the vehicle_type_name to set
	 */
	public void setVehicle_type_name(String vehicle_type_name) {
		this.vehicle_type_name = vehicle_type_name;
	}

	/**
	 * @return the vehicle_model
	 */
	public String getVehicle_model() {
		return vehicle_model;
	}

	/**
	 * @param vehicle_model the vehicle_model to set
	 */
	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}

	/**
	 * @return the adsw_package_id
	 */
	public String getAdsw_package_id() {
		return adsw_package_id;
	}

	/**
	 * @param adsw_package_id the adsw_package_id to set
	 */
	public void setAdsw_package_id(String adsw_package_id) {
		this.adsw_package_id = adsw_package_id;
	}

}
