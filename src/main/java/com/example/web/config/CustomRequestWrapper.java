package com.example.web.config;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomRequestWrapper extends HttpServletRequestWrapper {

    private byte[] requestBody;

    // 생성자: 요청 본문을 읽어서 byte 배열로 저장
    public CustomRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        InputStream is = request.getInputStream();
        this.requestBody = is.readAllBytes();  // 본문을 읽어서 저장
    }

    // 다시 요청 본문을 읽을 수 있도록 getInputStream을 오버라이드
    @Override
    public ServletInputStream getInputStream() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody);
        return new ServletInputStream() {
            @Override
            public boolean isFinished() {
                return byteArrayInputStream.available() == 0;
            }

            @Override
            public boolean isReady() {
                return true;
            }

            @Override
            public void setReadListener(ReadListener readListener) {}

            @Override
            public int read() throws IOException {
                return byteArrayInputStream.read();
            }
        };
    }

    // 본문을 다시 설정할 수 있도록 하는 메서드
    public void setRequestBody(byte[] requestBody) {
        this.requestBody = requestBody;
    }
}
