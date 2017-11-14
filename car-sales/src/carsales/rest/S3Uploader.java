package carsales.rest;

import java.io.ByteArrayInputStream;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.AccessControlList;
import com.amazonaws.services.s3.model.Grantee;
import com.amazonaws.services.s3.model.GroupGrantee;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.Permission;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;

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
            AccessControlList acl = new AccessControlList();
            acl.grantPermission(GroupGrantee.AllUsers, Permission.Read);
            String s3Path = "cars/uploads/" + filename;
            PutObjectResult result = s3.putObject(
                new PutObjectRequest(bucket, s3Path, inputStream, metadata)
                .withAccessControlList(acl));
            
            return s3.getUrl(bucket, s3Path).toString();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
