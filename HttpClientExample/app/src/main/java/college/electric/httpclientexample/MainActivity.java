package college.electric.httpclientexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.ByteString;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    OkHttpClient httpClient = new OkHttpClient();
    private static final int PICK_IMAGE_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ((Button)findViewById(R.id.uploadBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        });


        ((Button)findViewById(R.id.addCarBtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* ============ POST request with query parameters =============== */
                Request request1 = new Request.Builder().
                        post(RequestBody.create(null, ""))
                        .url(
                                // the order of HttpUrl building is unimportant
                                new HttpUrl.Builder()
                                        .scheme("http")
                                        .host("yaakov.gesher.net")
                                        .port(8080)
                                        .addPathSegments("car-sales/rs/car")
                                        .addQueryParameter("description", "Old junky car")
                                        .addQueryParameter("phone", "09999999")
                                        .build()
                        )
                        .build();

                httpClient.newCall(request1).enqueue(new NetworkResultCallback(
                        new NetworkResponseRunnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "Status code: " + response.code(), Toast.LENGTH_SHORT).show();
                                displayCarsJson();
                            }
                        })
                );
            }
        });
    }

    private void uploadFile(){
        Intent getPicIntent = new Intent(Intent.ACTION_GET_CONTENT,
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(getPicIntent, PICK_IMAGE_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, final int resultCode, Intent data) {
        if(requestCode == PICK_IMAGE_REQUEST_CODE){
            final Uri selectedImage = data.getData();
            RequestBody requestBody = null;
            try {
                InputStream in = MainActivity.this.getContentResolver().openInputStream(data.getData());



                File outputDir = this.getCacheDir();
                File outputFile = File.createTempFile("temp", "png", outputDir);
                FileOutputStream fos = new FileOutputStream(outputFile);
                final byte[] b = new byte[8192];
                for (int r; (r = in.read(b)) != -1;) {
                    fos.write(b, 0, r);
                }
                requestBody =
                        RequestBody.create(MediaType.parse("image/png"), outputFile);
            } catch (Exception e ) {
                e.printStackTrace();
                return;
            }

            Request request1 = new Request.Builder().
                    post(requestBody)
                    .url(
                            // the order of HttpUrl building is unimportant
                            new HttpUrl.Builder()
                                    .scheme("http")
                                    .host("yaakov.gesher.net")
                                    .port(8080)
                                    .addPathSegments("car-sales/rs/car/pic")
                                    .build()
                    )
                    .build();
            httpClient.newCall(request1).enqueue(new NetworkResultCallback(
                    new NetworkResponseRunnable() {
                @Override
                public void run() {
                    try {
                        Picasso.with(MainActivity.this).load(response.body().string()).into((ImageView) findViewById(R.id.uploadedImage));
                        File outputDir = MainActivity.this.getCacheDir();
                        File tempFile = new File(outputDir.getAbsolutePath()+ "/temp.png");
                        boolean deleted = tempFile.delete();
                        Log.i("OkHttpExample", "Deleted temporary image file? " + deleted);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }));

        }
    }

    private void displayCarsJson(){
        /* ======== GET request ========= */
        Request request = new Request.Builder()
                .url("http://yaakov.gesher.net:8080/car-sales/rs/car")
                .build();

        // make network call using default interfaces
        httpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                final String cars = response.body().string();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView)findViewById(R.id.getResult)).setText(cars);
                    }
                });

            }
        });

//        // make network call using custom classes
//        httpClient.newCall(request).enqueue(new NetworkResultCallback(new NetworkResponseRunnable() {
//            @Override
//            public void run() {
//                try {
//                    ((TextView)findViewById(R.id.getResult)).setText(response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }));
    }

    abstract class NetworkResponseRunnable implements Runnable{
        protected Response response;
        // protected JSONObject respone; // if I know I will always get JSON

        public void setResponse(Response response){
            this.response = response;
//            response = new JSONObject(response.body().string());
        }


    }

    class NetworkResultCallback implements Callback{
        NetworkResponseRunnable runOnResponse;

        public NetworkResultCallback(NetworkResponseRunnable runOnResponse){
            this.runOnResponse = runOnResponse;
        }

        @Override
        public void onFailure(Call call, IOException e) {
            e.printStackTrace();
            final String msg = e.getMessage();
            MainActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(MainActivity.this, msg, LENGTH_SHORT).show();
                }
            });
        }

        @Override
        public void onResponse(Call call, Response response) throws IOException {
            runOnResponse.setResponse(response);
            runOnUiThread(runOnResponse);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
