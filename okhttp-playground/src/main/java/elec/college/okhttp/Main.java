package elec.college.okhttp;

import okhttp3.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        OkHttpClient httpClient = new OkHttpClient();

        Request request = new Request.Builder()
                .get()
                .url("http://localhost:8080/car-sales/rs/car")
                .build();
        Call call = httpClient.newCall(request);

        Response response = call.execute();
        int status = response.code();
        ResponseBody body = response.body();
        String responseBody = body.string();
        System.out.println("status: " + status + "\n" + responseBody);

        System.out.println("========================");

        // build request with parameters using HttpUrl builder
        HttpUrl.Builder builder = new HttpUrl.Builder()
                .host("localhost")
                .port(8080)
                .scheme("http")
                .addPathSegment("car-sales")
                .addPathSegment("rs")
                .addPathSegment("car");

        HashMap<String, String> qParamsMap = new HashMap<>();
        qParamsMap.put("description", "old car 3");
        qParamsMap.put("phone", "0988888");
        builder = addQueryParams(qParamsMap, builder);
        HttpUrl url = builder.build();

        Request request1 = new Request.Builder()
                .post(RequestBody.create(MediaType.parse("image/jpeg"), new File("/Users/yaakov/Development/design/blank_purple.png")))
                .url(url)
                .build();

        // same request using manual url composition
        Request request2 = new Request.Builder()
                .post(RequestBody.create(MediaType.parse(""), ""))
                .url("http://localhost:8080/car-sales/rs/car?description=old car 3&phone=0988888")
                .build();
        String addResponse = httpClient.newCall(request1).execute().body().string();
        System.out.println(addResponse);
    }

    private static HttpUrl.Builder addQueryParams(Map<String, String> paramMap, HttpUrl.Builder builder){
        for(Map.Entry<String, String> e: paramMap.entrySet()){
            builder.addQueryParameter(e.getKey(), e.getValue());
        }
        return builder;
    }
}

