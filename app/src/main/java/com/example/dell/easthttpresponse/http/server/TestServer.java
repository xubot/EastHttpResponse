package com.example.dell.easthttpresponse.http.server;

/**
 *    author : Android 轮子哥
 *    github : https://github.com/getActivity/EasyHttp
 *    time   : 2019/05/19
 *    desc   : 测试环境
 */
public class TestServer extends ReleaseServer {

    @Override
    public String getHost() {
        //return "https://www.wanandroid.com/";
        return "http://192.168.0.134:8080/";
    }
}