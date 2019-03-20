package com.ocpp;

import com.opencsv.bean.CsvBindByName;

public class ChargingData {

	@CsvBindByName private  String transactionPK;
	@CsvBindByName private  String startValue;
	@CsvBindByName private  String stopValue;
	@CsvBindByName private  String idRef;
	@CsvBindByName private  String startTimestamp;
	@CsvBindByName private  String stopTimestamp;
	@CsvBindByName private  String eventTimeStamp;
	@CsvBindByName private  String stopReason;
	@CsvBindByName private  String connectorPK;
	@CsvBindByName private  String meterCurrentRMS1;
	@CsvBindByName private  String voltageRMS1;
	@CsvBindByName private  String frequency1;
	@CsvBindByName private  String powerFactor1;
	@CsvBindByName private  String activePower1;
	@CsvBindByName private  String reactivePower1;
	@CsvBindByName private  String apparentPower1;
	@CsvBindByName private  String energy1;
	@CsvBindByName private  String currentRMS2;
	@CsvBindByName private  String voltageRMS2;
	@CsvBindByName private  String frequency2;
	@CsvBindByName private  String powerFactor2;
	@CsvBindByName private  String activePower2;
	@CsvBindByName private  String reactivePower2;
	@CsvBindByName private  String apparentPower2;
	@CsvBindByName private  String energy2;
	@CsvBindByName private  String lhCustomerId;
	@CsvBindByName private  String firstName;
	@CsvBindByName private  String lastName;
	@CsvBindByName private  String phone;
	@CsvBindByName private  String email;

	public String getTransactionPK() {
		return transactionPK;
	}

	public void setTransactionPK(String transactionPK) {
		this.transactionPK = transactionPK;
	}

	public String getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(String startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public String getStopTimestamp() {
		return stopTimestamp;
	}

	public void setStopTimestamp(String stopTimestamp) {
		this.stopTimestamp = stopTimestamp;
	}

	public String getEventTimeStamp() {
		return eventTimeStamp;
	}

	public void setEventTimeStamp(String eventTimeStamp) {
		this.eventTimeStamp = eventTimeStamp;
	}

	public String getStopReason() {
		return stopReason;
	}

	public void setStopReason(String stopReason) {
		this.stopReason = stopReason;
	}

	public String getConnectorPK() {
		return connectorPK;
	}

	public void setConnectorPK(String connectorPK) {
		this.connectorPK = connectorPK;
	}


	public String getMeterCurrentRMS1() {
		return meterCurrentRMS1;
	}

	public void setMeterCurrentRMS1(String meterCurrentRMS1) {
		this.meterCurrentRMS1 = meterCurrentRMS1;
	}

	public String getVoltageRMS1() {
		return voltageRMS1;
	}

	public void setVoltageRMS1(String voltageRMS1) {
		this.voltageRMS1 = voltageRMS1;
	}

	public String getFrequency1() {
		return frequency1;
	}

	public void setFrequency1(String frequency1) {
		this.frequency1 = frequency1;
	}

	public String getPowerFactor1() {
		return powerFactor1;
	}

	public void setPowerFactor1(String powerFactor1) {
		this.powerFactor1 = powerFactor1;
	}

	public String getActivePower1() {
		return activePower1;
	}

	public void setActivePower1(String activePower1) {
		this.activePower1 = activePower1;
	}

	public String getReactivePower1() {
		return reactivePower1;
	}

	public void setReactivePower1(String reactivePower1) {
		this.reactivePower1 = reactivePower1;
	}

	public String getApparentPower1() {
		return apparentPower1;
	}

	public void setApparentPower1(String apparentPower1) {
		this.apparentPower1 = apparentPower1;
	}

	public String getEnergy1() {
		return energy1;
	}

	public void setEnergy1(String energy1) {
		this.energy1 = energy1;
	}

	public String getCurrentRMS2() {
		return currentRMS2;
	}

	public void setCurrentRMS2(String currentRMS2) {
		this.currentRMS2 = currentRMS2;
	}

	public String getVoltageRMS2() {
		return voltageRMS2;
	}

	public void setVoltageRMS2(String voltageRMS2) {
		this.voltageRMS2 = voltageRMS2;
	}

	public String getFrequency2() {
		return frequency2;
	}

	public void setFrequency2(String frequency2) {
		this.frequency2 = frequency2;
	}

	public String getPowerFactor2() {
		return powerFactor2;
	}

	public void setPowerFactor2(String powerFactor2) {
		this.powerFactor2 = powerFactor2;
	}

	public String getActivePower2() {
		return activePower2;
	}

	public void setActivePower2(String activePower2) {
		this.activePower2 = activePower2;
	}

	public String getReactivePower2() {
		return reactivePower2;
	}

	public void setReactivePower2(String reactivePower2) {
		this.reactivePower2 = reactivePower2;
	}

	public String getApparentPower2() {
		return apparentPower2;
	}

	public void setApparentPower2(String apparentPower2) {
		this.apparentPower2 = apparentPower2;
	}

	public String getEnergy2() {
		return energy2;
	}

	public void setEnergy2(String energy2) {
		this.energy2 = energy2;
	}

	public String getLhCustomerId() {
		return lhCustomerId;
	}

	public void setLhCustomerId(String lhCustomerId) {
		this.lhCustomerId = lhCustomerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getStartValue() {
		return startValue;
	}

	public void setStartValue(String startValue) {
		this.startValue = startValue;
	}

	public String getStopValue() {
		return stopValue;
	}

	public void setStopValue(String stopValue) {
		this.stopValue = stopValue;
	}

	public String getIdRef() {
		return idRef;
	}

	public void setIdRef(String idRef) {
		this.idRef = idRef;
	}

	@Override
	public String toString() {
		return "ChargingData [transactionPK=" + transactionPK + ", startValue=" + startValue + ", stopValue="
				+ stopValue + ", idRef=" + idRef + ", startTimestamp=" + startTimestamp + ", stopTimestamp="
				+ stopTimestamp + ", eventTimeStamp=" + eventTimeStamp + ", stopReason=" + stopReason + ", connectorPK="
				+ connectorPK + ", meterCurrentRMS1=" + meterCurrentRMS1 + ", voltageRMS1=" + voltageRMS1
				+ ", frequency1=" + frequency1 + ", powerFactor1=" + powerFactor1 + ", activePower1=" + activePower1
				+ ", reactivePower1=" + reactivePower1 + ", apparentPower1=" + apparentPower1 + ", energy1=" + energy1
				+ ", currentRMS2=" + currentRMS2 + ", voltageRMS2=" + voltageRMS2 + ", frequency2=" + frequency2
				+ ", powerFactor2=" + powerFactor2 + ", activePower2=" + activePower2 + ", reactivePower2="
				+ reactivePower2 + ", apparentPower2=" + apparentPower2 + ", energy2=" + energy2 + ", lhCustomerId="
				+ lhCustomerId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone=" + phone + ", email="
				+ email + "]";
	}
}
