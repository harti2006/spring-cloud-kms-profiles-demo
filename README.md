# Demo: Spring Cloud Config AWS KMS vs. Spring Profiles 

Demo project to clarify and reproduce an issue that was described [here](https://github.com/zalando/spring-cloud-config-aws-kms/issues/48#issuecomment-436526071). 

Goal is to show usage of Spring profiles together with the Spring Cloud Config AWS KMS library. Please have a look into
the different JUnit tests.  

## Simple Usage

```bash
# Run the "simple" tests, that only show Spring profile usage, without KMS decryption
./mvn clean verify
```

## Decryption Usage

Prepare some KMS secrets to run DecryptionTest1 / DecryptionTest2.

Prerequisite: Two different KMS keys, that are accessible with different credentials ( e.g. in different AWS accounts,
or using different IAM users. One IAM user must only be able to access one key and the other user has permissions for
the other key)

```bash
# Login to first account / user and then
aws kms encrypt --key-id "KEY1-XXXX-XXXX" --plaintext "Encrypted in Account 1" --query CiphertextBlob --output text
# copy the value over to src/main/resources/application-aws1.yaml to key "demo.profile-precedence".
# Also make sure to set the correct key region in bootstrap-aws1.yaml. 

# Login to second account / user and then
aws kms encrypt --key-id "KEY2-XXXX-XXXX" --plaintext "Encrypted in Account 2" --query CiphertextBlob --output text
# copy the value over to src/main/resources/application-aws2.yaml to key "demo.profile-precedence".
# Also make sure to set the correct key region in bootstrap-aws2.yaml. 
```

Now login to either of the accounts/users and, remove the `@Ignore` annotation from `DecryptionTest1|2` and run them.
You will see the test succeed if you are logged in with the proper permissions.
