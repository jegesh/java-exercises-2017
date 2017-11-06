package jersey.explore;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;

import javax.ws.rs.ext.ExceptionMapper;
import java.io.ByteArrayInputStream;

public class S3Uploader {
    private String bucket = "jersey-files";
    private String region = "us-east-1";

    public String uploadFile(byte[] data, String filename, String contentType){
        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider().getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                            "Please make sure that your credentials file is at the correct " +
                            "location (~/.aws/credentials), and is in valid format.",
                    e);
        }

        try {

            AmazonS3 s3 = AmazonS3ClientBuilder.standard()
                    .withCredentials(new AWSStaticCredentialsProvider(credentials))
                    .withRegion(region)
                    .build();

            ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentType(contentType);
            String s3Path = "cars/uploads/" + filename;
            PutObjectResult result = s3.putObject(
                bucket,
                s3Path,
                inputStream,
                metadata
            );

            return s3.getUrl(bucket, s3Path).toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
