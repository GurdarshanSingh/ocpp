package eu.chargetime.ocpp.feature.profile;

/*
 ChargeTime.eu - Java-OCA-OCPP
 Copyright (C) 2015-2018 Thomas Volden <tv@chargetime.eu>

 MIT License

 Copyright (C) 2016-2018 Thomas Volden

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in all
 copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 SOFTWARE.
 */

import java.util.ArrayList;
import java.util.UUID;

import eu.chargetime.ocpp.feature.Feature;
import eu.chargetime.ocpp.feature.GetLocalListVersionFeature;
import eu.chargetime.ocpp.feature.ProfileFeature;
import eu.chargetime.ocpp.feature.SendLocalListFeature;
import eu.chargetime.ocpp.model.Confirmation;
import eu.chargetime.ocpp.model.Request;
import eu.chargetime.ocpp.model.localauthlist.GetLocalListVersionRequest;
import eu.chargetime.ocpp.model.localauthlist.SendLocalListRequest;

public class ClientLocalAuthListProfile implements Profile {
	
	private ClientLocalAuthListEventHandler eventHandler;
	private ArrayList<Feature> featureList;

	public ClientLocalAuthListProfile(ClientLocalAuthListEventHandler handler) {
		eventHandler = handler;

		featureList = new ArrayList<>();
		featureList.add(new GetLocalListVersionFeature(this));
		featureList.add(new SendLocalListFeature(this));
	}
	
	@Override
	public ProfileFeature[] getFeatureList() {
		return featureList.toArray(new ProfileFeature[0]);
	}

	@Override
	public Confirmation handleRequest(UUID sessionIndex, Request request) {
		Confirmation result = null;

		if (request instanceof GetLocalListVersionRequest) {
			result = eventHandler.handleGetLocalListVersionRequest((GetLocalListVersionRequest)request);
		} else if (request instanceof SendLocalListRequest) {
			result = eventHandler.handleSendLocalListRequest((SendLocalListRequest) request);
		}
		
		return result;
	}
}
