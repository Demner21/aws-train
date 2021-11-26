package com.example.myapp;

import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketConfiguration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.S3Exception;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		var region = Region.US_WEST_2;

		try (var s3Client = S3Client.builder().region(region).build();) {

			var bucketName = "bucket" + System.currentTimeMillis();
			var key = "key";

			tutorialSetup(s3Client, bucketName, region);
			System.out.println("uploading object...");

			s3Client.putObject(PutObjectRequest.builder().bucket(bucketName).key(key).build(),
					RequestBody.fromString("TEST-DMNR {sdk-java}"));

			System.out.println("upload complete");
		}
	}

	private static void tutorialSetup(S3Client s3Client, String bucketName, Region region) {

		try {
			s3Client.createBucket(
					CreateBucketRequest.builder().bucket(bucketName)
							.createBucketConfiguration(
									CreateBucketConfiguration.builder().locationConstraint(region.id()).build())
							.build());
			System.out.println("Creando bucket:" + bucketName);

			s3Client.waiter().waitUntilBucketExists(HeadBucketRequest.builder().bucket(bucketName).build());
			System.out.println(bucketName + " is ready.");
			System.out.printf("%n");
		} catch (S3Exception e) {
			System.err.println(e.awsErrorDetails().errorMessage());
			System.exit(0);
		}

	}
}
