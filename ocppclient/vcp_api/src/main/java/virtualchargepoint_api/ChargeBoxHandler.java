package virtualchargepoint_api;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import com.ocpp.ChargingData;
import com.ocpp.ReaderUtil;

import eu.chargetime.ocpp.model.core.Location;
import eu.chargetime.ocpp.model.core.SampledValue;
import eu.chargetime.ocpp.model.core.ValueFormat;

public class ChargeBoxHandler {

	static Logger log = Logger.getLogger(ChargeBoxHandler.class.getName());

	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, IOException, IntrospectionException {
		log.info("inside ChargeBoxHandler");
		String serverURL = "ec2-54-68-194-174.us-west-2.compute.amazonaws.com:80/steve/websocket/CentralSystemService/";
		String ChargeBoxID = "5555"; // Use ChargeBoxID.00 as example OCCPJ
		String CPVendor = "simens";
		String CPModel = "1.1";
		// String authorizationID = "B4A63CDI";
		Chargepoint client = new Chargepoint(ChargeBoxID, CPVendor, CPModel, false, false);

		try {

			List<ChargingData> listChargingData = ReaderUtil.getChargingData("");
			log.info("trying connect");
			client.connect(serverURL);

			log.info("connected sending notofication ");
			client.sendBootNotification();

			log.info("adding meter values");
			for (ChargingData chargingData : listChargingData) {

				String idRef = chargingData.getIdRef();

				int connectorID = Integer.parseInt(chargingData.getConnectorPK());
				int meterStartValue = Integer.parseInt(chargingData.getStartValue());
				int meterStopValue = Integer.parseInt(chargingData.getStopValue());
				String startTimeStamp = chargingData.getStartTimestamp();
				String eventTimeStamp = chargingData.getEventTimeStamp();
				client.sendAuthorizeRequest(idRef);
				client.sendStartTransactionRequest(connectorID, idRef, meterStartValue, getCalender(startTimeStamp));
				int transactionID = client.getTransactionId();

				ChargingData bean = chargingData;
				BeanInfo beanInfo = Introspector.getBeanInfo(ChargingData.class);
				for (PropertyDescriptor propertyDesc : beanInfo.getPropertyDescriptors()) {
					String propertyName = propertyDesc.getName();
					Object value = propertyDesc.getReadMethod().invoke(bean);
					if (propertyName.contains("meter")) {
						log.info("adding meter values" + propertyName);

						SampledValue sampledValue = new SampledValue();
						sampledValue.setContext("Sample.Periodic");
						sampledValue.setFormat(ValueFormat.Raw);
						sampledValue.setLocation(Location.EV);
						sampledValue.setMeasurand("Voltage");
						sampledValue.setPhase("L1");
						sampledValue.setUnit("W");
						sampledValue.setValue(value.toString());
						System.out.println(propertyName + "--" + value);
						client.sendMeterValue(connectorID, sampledValue, transactionID);
					}
				}
				log.info("Meter values added");

				// client.sendStopTransactionRequest(transactionID,
				// meterStopValue);
				Thread.sleep(2000);
			}
			log.info("Client disconnected.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			client.disconnect();
		}
	}

	public static Calendar getCalender(String timestamp) {
		Calendar cal = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm");
			Date date = sdf.parse(timestamp);
			cal = Calendar.getInstance();
			cal.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal;
	}
}