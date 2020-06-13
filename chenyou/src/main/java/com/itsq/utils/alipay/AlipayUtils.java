package com.itsq.utils.alipay;

public class AlipayUtils {

    //API
    public static String app_id = "2016092400583953";
    //私钥
    public static String private_key="MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDyKjVFDgytA+hz9OgmdcVUWLwMvJu/aYbHH6y6048hM94u4b5JHiLm0ycQrTq6CdEdSpgQ6BhDLSH9bViY0nIQHRnJ50uwt446MQG13E+J7WaMFweflMyEd/8UwEuiAn9dAiYdl9Kjp5QEpSej4W9WNVM8IS+DanbsOh0/ymQ5ud1UagW+npN+bHTOcfAX+jeBjUWTT/Rx4WVq1N7PW+3QLEwdq8dMw6UjsUo6ZcvB85EhfFURdOlXXRAvuUJ45p/HVLf1H1xDm8C47EZ8oL/eIzrBwKl3efL6PRIezSMytl5laVuSBEbK+dpvICknvPdjJOQ2hI/9Wq5yFOw4SBzvAgMBAAECggEAWmlPwhxgtyfCXaiOE+3cYoVOkCLKs0gevbEhuA7MXUUUKsS1Wm8Z8Lvc1ekXB+YqYJk89PLyPAJZslhkv4mydDmpKyxjofKl8yvgy5kZSRGNO7hNbFMNmFeEsKaqli4AhyUKPfo09kzWgnV2u0SrYLBABy8Moi/ZfpCj4vEZQkNcWfLhV4ldtfMAyjblRh3oFe+xlWlguwf1lTwR8qIY9UkL95l/5GuyDw6LReYulbL02muCNu96MzaR3G8++M19WIgrGkUcUFUZx9vTJIjiaTHRO918rNAVIkMlNJHv6FtDE6Y6ddlTU6Jc0jEAKYQd3k7caYyBQlbXrWntNOgZgQKBgQD/Bso+fU08H9GQ+B/fE8RNitohKUisgfzmZqKlbORdxh6gmoljdLp75xu7dcIexY1HGj0TEMOeXQXkF51wraF2iW4FgPHXL7oQyhuTsx3GzYZp54xlVINFkeHwiQgBmV7M1HV3AfoCFIsQ9QzJSgFubxDlvmdEpa+26fPEjeTIkQKBgQDzFtmKIMWBZQrlNJz7/zJ1iXjZcr6FtEpFNU+8xGWc74p/RPiLdM/3nWuOo0+ie5E+NkiKwVrcC7NQ5CkXpGLaP6SebHmed0MNKno0JL7fQ1/7RXBQ6zXvYagvBaVHKCUaTa9nOCf4U0VkXCzg8ufx46pAQQeLYsyNRTxJ3qVNfwKBgQD1cDJ6e5s2byUAkVwTFHILcsPFwHa514xurX6BGNCb002soa3x8uh60IxnGMkPVm9Ga+E1lR+/LKW7xGJ4jBJmA5PIZjXaNIutFuX9exgAOdLP39HFv9VqwiChny/+Yf3TwfGe7F8RW3YPhtecbcX845VulpXKgm8e6f/6PdlekQKBgF/uSYUoL6lDvcv8OmN8L2aRDN8LWEKdhp3PTxtYih0nrwlQp6EpRRUby6Frs3aUuxnJBFG1wmyKNYabs9e/qL8mVImsl0ZBHHXqqHVBdw3Wod8gZRWZ7Rv99wgvey0cm5/IvorGb4ehHQZhFdjkI0KjLMHUp+yK3dx2UTd5pNRzAoGBANaV+ju2iU08BUrmdKfAjTqBNJtCULiFtL153/r4Gghgp8+40fQYNugQREcm2hSqg3CL55+b0oCuuNOWhldBe1pDomSKYihnTDlI/lbCUobuvlqFAKSpdXf7RDv/SvnJCkDAmgmm1q7SfJvXC2kJN/Ur5b4ip2Vu6NWJPbKVsQ//";
    // 支付宝的公钥
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApTHYcMDgK/ql99RE61hFuEC0dU41wIgo23hgimAkIEAXmgrxxhxdIZqhSIZXQI2ruSCc/Rdk8nhicX25Q9AxrJHJLxfTU3MB96HO2Tx+zMfMnPPuJGlwCFjrV5JcHlhA1CMwoJJ9BmlHpT5lCtDmSpy1mj/TdUBCG5VewbtrASHB7iviLrIpxicK0IaU+eAHEg0pAXxb44+75v9nLgF2+lEFMymtG2+D5w5EwABT/55CuKJySP1qWemYUompn2kYzjNdgF8sTzMI5fND0HO4fPMy7xkZdNtMBiMPMU+y1iCTFS4Wv1r75TxMdxU9FzkvjIArVOwpWBRuSaZ/JiRdmwIDAQAB";
 //APP支付宝支付业务：app_id
/*
 public static String app_id = "2018042702600164";
    // 商户的私钥,使用支付宝自带的openssl工具生成。
    public static String private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCLLJ40dlITadRvwDsg2OhJ2leAI+gDKpLT9d0pEjFWRXQMP3idQfpBDAE9lpLejEQgQXw+3JLP76T9vmnlpB1Mj4Ds9Qwx3WDnz7/8dkB9kbAeJWmgFNp5uGFh0y29cvNPJrqFAMQV16nbrRo69pSDYBaW7b2JZ1SY+F53QmMiHYGq1sQXu1wjna5SpWjPunAE23+sJ1+on4CqQMd7vViF9ZvtveQS31FlS/lcB6qzPe+lftSzUNiyOwileHn8lDHGm8izD9cOixWX0byqSqZJd6v8khoFz8g5Do2PvCEyGPSGWpATWWrMQtFYlo86dliTYDx5d1F1MDqtko759SztAgMBAAECggEAefXcoc66OCb6sf98EVnjnayIF1Pf4r5xMuv3JiG6OIbenkkU0oJZ4py5jZYhGINExBt+3LuAsFWqeW5e8I2z2z66VWychiog3KOy83NRKnj8JD7W5CDCH/6S4B4mrClKzKb8tscoDpgSUt7L6LXjCYmv4g1uljWF7hNg/ROhOefcPrMcsIhtGloxdiLG8+SDi+Ym2leo+zFT5P7CMQGysdTZWco/rRzJSCVlQwvslYZhK+REv33SpY9XHuvw5CWoFxzqLert3gD/jT5pXBouY2+fllO6VoaZ8rR+RCxfqZnDSQolazNMz5CB5BjKQnp5CottjlP8BpZPNLIlDc0JhQKBgQDstRzegWRU+hIfjTT7r7drVAUnqWzLLdaC+JRIAAwGxI2WoBDKDeqbT9LNSfe0IORd1lVOZSXx5tEtTUPQmfRgcjlrJJZPIpiQCn+fqKEjJ/NCdHBJO4q6/6uyR7aT7jrXqxY7D4xNg+dYBrRuChdCviNnEkp5mNa762xM8Abx7wKBgQCWhHsvyMkEctotBVB822v7a/cm+uviGoTiVRMlHepwe7lSFx9RsljWvpRuuxhilHVdE1Vm0Yc6xu3mI7axYbQe4xilSIW4AVk4dUXH9q0pJy/pLpw5oULDSS6Aymfk+LCKHaDr9VnnuwaS6q4BmOfu8gkczgIAGKP7NTyWOUu64wKBgQCHRQj2buMzXKU2uq9olYYwI5e+jqfJhKxttDio3L4CsBhp15dAoKtNjlRdVMPlgFaA+ZdOcac5kjo/tUPn1dM9uojtnb74AkFFL3q3dtp/CLmPZJM2hnxFWQ55l1nTN/UQgoj1v3Dia1qth0ddCw836Qi6Qk2lJ56vTV5aqWCOqQKBgGY35FzIM9PEl+x5LncMoKGnabpcL7NmpRX8BrtvPJZVP77DGy7lOrXjyXQFtYLFJYsnJRlldDvzev6PBHQkUSmkukkNHlqe99OCuPgayvAmv7/ROqFcpbVvzpgCXVo/lczGYFG+VucruUQvAirth51bW9rnAK7GDR79wX6XvJlXAoGBAMXGjQygd+pzdRe41TyR63YIxhdFEkT2b0othwNYZxWLoK9hpFHEF0FWCiqNnswP6JQnwcdDts9YCJAPKnPBdC47y8sCYMfzcuZGWu+ptxU+SL5Tol4hELPoAe8qEFV9aEVb+tA2yqNMPdOJE16SrC/s1wSTinUeMFf7+6dIzG8L";
    // 应用的公钥，无需修改该值
    public static String public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAiyyeNHZSE2nUb8A7INjoSdpXgCPoAyqS0/XdKRIxVkV0DD94nUH6QQwBPZaS3oxEIEF8PtySz++k/b5p5aQdTI+A7PUMMd1g58+//HZAfZGwHiVpoBTaebhhYdMtvXLzTya6hQDEFdep260aOvaUg2AWlu29iWdUmPhed0JjIh2BqtbEF7tcI52uUqVoz7pwBNt/rCdfqJ+AqkDHe71YhfWb7b3kEt9RZUv5XAeqsz3vpX7Us1DYsjsIpXh5/JQxxpvIsw/XDosVl9G8qkqmSXer/JIaBc/IOQ6Nj7whMhj0hlqQE1lqzELRWJaPOnZYk2A8eXdRdTA6rZKO+fUs7QIDAQAB";
    // 支付宝的公钥，去open.alipay.com对应应用下查看。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqTY6gQLWfJjo1yoFK794FR+OWoITE+kJwzAlARH6u12QuICamLst7I6jP4FpBHm6aBjGHkqZbDUNjXArkH7E5h55Yru9Tcgj3c5UhvrqnXHaOyh7tMM5P01ve2j76vQK7f7fsNHESea7fFX1QEuVtHEqegwKQwTAIomQY+fJj9DYqy9pdp8vNe7X24kywYQvFv8XAhhAwbtXxakPQ53AccEJ/5mDazLyZcltIyKFpOncLIjQSzx06x8wYuhoH2GEwlumCqgBsdI09MSmI3nXdNb5DHFsxCDuwQJXpc7FpEorHL8LpaRuXzYfnfpHEt56H5ngnAEwB40tuDWIlGivCwIDAQAB\n";
*/

    //网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String input_charset = "UTF-8";
    }
