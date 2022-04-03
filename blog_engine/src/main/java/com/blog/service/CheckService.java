package com.blog.service;

import com.blog.api.response.CheckResponse;
import org.springframework.stereotype.Service;

@Service
public class CheckService {
  public CheckResponse getResult() {
    CheckResponse checkResponse = new CheckResponse();
      checkResponse.setResult(false);
    return checkResponse;
  }
}
