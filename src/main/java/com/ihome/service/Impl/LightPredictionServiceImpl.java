package com.ihome.service.Impl;

import com.ihome.dao.LightPredictionDao;
import com.ihome.pojo.LightPrediction;
import com.ihome.pojo.LightState;
import com.ihome.service.LightPredictionService;
import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmKeyType;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;


@Service
public class LightPredictionServiceImpl implements LightPredictionService {
    @Autowired
    private LightPredictionDao lightPredictionDao;

    @Override
    public LightPrediction addRecord(LightPrediction lightPrediction) {
        return lightPredictionDao.save(lightPrediction);
    }

    @Override
    public String predict(LightState lightState) throws Exception {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "http://127.0.0.1:5000/predict";

        // 构造 JSON 请求
        JSONObject jsonRequest = new JSONObject();
        jsonRequest.put("device_id", lightState.getDevice_id());
        jsonRequest.put("user_id", lightState.getUser_id());
        jsonRequest.put("state", lightState.getState());
        jsonRequest.put("type", lightState.getType());
        jsonRequest.put("brightness", lightState.getBrightness());
        jsonRequest.put("hour", lightState.getHour());
        jsonRequest.put("weekday", lightState.getWeekday());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request = new HttpEntity<>(jsonRequest.toString(), headers);

        // 发送请求
        ResponseEntity<String> response = restTemplate.postForEntity(apiUrl, request, String.class);
        // 解析 JSON 并获取 prediction 值
        JSONObject jsonResponse = new JSONObject(response.getBody());
        return jsonResponse.getString("prediction");
    }
}
