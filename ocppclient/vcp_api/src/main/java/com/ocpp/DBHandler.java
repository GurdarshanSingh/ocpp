package com.ocpp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBHandler {

	private Connection connection;

	public DBHandler() {
		this.connection = DBConnection.getConnection();
	}

	public void addConnector(Connector connector) {

		PreparedStatement preparedStatement;
		try {
			preparedStatement = connection.prepareStatement("insert into connector set charge_box_id=?,connector_id=?");
			preparedStatement.setString(1, connector.getChargeBoxID());
			preparedStatement.setInt(2, Integer.parseInt(connector.getConnectorID()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
