import os

from tencentcloud.common import credential
from tencentcloud.common.profile.client_profile import ClientProfile
from tencentcloud.common.profile.http_profile import HttpProfile
from tencentcloud.common.exception.tencent_cloud_sdk_exception import TencentCloudSDKException
from tencentcloud.ecc.v20181213 import models, ecc_client
try:
    cred = credential.Credential("AKID0ohjctt1s5kJBnfA0czB4HH35sUrGuZ0", "rDLF8wVt2GTZRcaJBraHtQlOqS1wEQPE")
    httpProfile = HttpProfile()
    httpProfile.endpoint = "ecc.tencentcloudapi.com"

except TencentCloudSDKException as err:
    print(err)