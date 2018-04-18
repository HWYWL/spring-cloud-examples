# Git webhooks

现在虽然可以不用重启服务就更新配置了，但还是需要我们手动操作，这样还是不可取的。所以，这里就要用到Git的webhooks来达到自动更新配置。

打开git上配置仓库的地址，添加webhooks，上面Payload URL我写的域名，当然我没有部署，上面的Payload URL就填写我们的配置中心触发刷新的地址，当然这里不能写localhost啦，要外网访问地址才行。

还有这里面有个Secret的秘钥验证，如果这里填写的话，在配置文件上要写上encrypt.key与之对应。

![](https://i.imgur.com/ocQOJy9.jpg)

# 局部刷新
某些场景下（例如灰度发布），我们可能只想刷新部分微服务的配置，此时可通过/bus/refresh端点的destination参数来定位要刷新的应用程序。

例如：/bus/refresh?destination=customers:8000，这样消息总线上的微服务实例就会根据destination参数的值来判断是否需要要刷新。其中，customers:8000指的是各个微服务的ApplicationContext ID。

destination参数也可以用来定位特定的微服务。例如：/bus/refresh?destination=customers:**，这样就可以触发customers微服务所有实例的配置刷新。

# 跟踪总线事件
一些场景下，我们可能希望知道Spring Cloud Bus事件传播的细节。此时，我们可以跟踪总线事件（RemoteApplicationEvent的子类都是总线事件）。

跟踪总线事件非常简单，只需设置spring.cloud.bus.trace.enabled=true，这样在/bus/refresh端点被请求后，访问/trace端点就可获得类似如下的结果：

发送 GET请求到：http://localhost:8888/trace
```
[
    {
        "timestamp": 1524046875268,
        "info": {
            "method": "POST",
            "path": "/trace",
            "headers": {
                "request": {
                    "host": "localhost:8888",
                    "connection": "keep-alive",
                    "content-length": "0",
                    "cache-control": "no-cache",
                    "origin": "chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop",
                    "user-agent": "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36",
                    "postman-token": "522585f8-3fc2-a792-66b5-c6140b5ad7bf",
                    "accept": "*/*",
                    "dnt": "1",
                    "accept-encoding": "gzip, deflate, br",
                    "accept-language": "zh,zh-CN;q=0.9"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Allow": "GET",
                    "status": "405"
                }
            },
            "timeTaken": "0"
        }
    },
    {
        "timestamp": 1524046452092,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/dev/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:14:12 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "9511"
        }
    },
    {
        "timestamp": 1524046449098,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/test/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:14:09 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "6420"
        }
    },
    {
        "timestamp": 1524046445665,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/pre/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:14:05 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "3205"
        }
    },
    {
        "timestamp": 1524046443336,
        "info": {
            "method": "POST",
            "path": "/bus/refresh",
            "headers": {
                "request": {
                    "host": "localhost:8888",
                    "connection": "keep-alive",
                    "content-length": "0",
                    "cache-control": "no-cache",
                    "origin": "chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop",
                    "user-agent": "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36",
                    "postman-token": "29cb475f-2151-4f3f-dd1c-55deaba1917f",
                    "accept": "*/*",
                    "dnt": "1",
                    "accept-encoding": "gzip, deflate, br",
                    "accept-language": "zh,zh-CN;q=0.9"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "status": "200"
                }
            },
            "timeTaken": "1547"
        }
    },
    {
        "timestamp": 1524046390120,
        "info": {
            "method": "GET",
            "path": "/springCloudConfig/dev/",
            "headers": {
                "request": {
                    "host": "localhost:8888",
                    "connection": "keep-alive",
                    "cache-control": "no-cache",
                    "user-agent": "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36",
                    "postman-token": "36b962a0-8e6a-ae50-342c-b5012b352109",
                    "accept": "*/*",
                    "dnt": "1",
                    "accept-encoding": "gzip, deflate, br",
                    "accept-language": "zh,zh-CN;q=0.9"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:13:10 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "3694"
        }
    },
    {
        "timestamp": 1524046372114,
        "info": {
            "method": "POST",
            "path": "/springCloudConfig/dev/",
            "headers": {
                "request": {
                    "host": "localhost:8888",
                    "connection": "keep-alive",
                    "content-length": "0",
                    "cache-control": "no-cache",
                    "origin": "chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop",
                    "user-agent": "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36",
                    "postman-token": "bd0ac989-372f-ed1d-a873-c56d1ead41b4",
                    "accept": "*/*",
                    "dnt": "1",
                    "accept-encoding": "gzip, deflate, br",
                    "accept-language": "zh,zh-CN;q=0.9"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Allow": "GET",
                    "status": "405"
                }
            },
            "timeTaken": "1"
        }
    },
    {
        "timestamp": 1524046363012,
        "info": {
            "method": "POST",
            "path": "/springCloudConfig/dev/master",
            "headers": {
                "request": {
                    "host": "localhost:8888",
                    "connection": "keep-alive",
                    "content-length": "0",
                    "cache-control": "no-cache",
                    "origin": "chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop",
                    "user-agent": "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36",
                    "postman-token": "41a3b71f-51ca-2a49-5215-59f71e30aa5c",
                    "accept": "*/*",
                    "dnt": "1",
                    "accept-encoding": "gzip, deflate, br",
                    "accept-language": "zh,zh-CN;q=0.9"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Allow": "GET",
                    "status": "405"
                }
            },
            "timeTaken": "3"
        }
    },
    {
        "timestamp": 1524046304839,
        "info": {
            "method": "POST",
            "path": "/springCloudConfig/dev/master",
            "headers": {
                "request": {
                    "host": "localhost:8888",
                    "connection": "keep-alive",
                    "content-length": "0",
                    "cache-control": "no-cache",
                    "origin": "chrome-extension://fhbjgbiflinjbdggehcddcbncdddomop",
                    "user-agent": "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36",
                    "postman-token": "6ed102d4-2bf3-a72e-17a4-520617ed8557",
                    "accept": "*/*",
                    "dnt": "1",
                    "accept-encoding": "gzip, deflate, br",
                    "accept-language": "zh,zh-CN;q=0.9"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Allow": "GET",
                    "status": "405"
                }
            },
            "timeTaken": "3"
        }
    },
    {
        "timestamp": 1524046034364,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/pre/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:07:14 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "1759"
        }
    },
    {
        "timestamp": 1524046031132,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/pre/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:07:11 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "2276"
        }
    },
    {
        "timestamp": 1524046022669,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/pre/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:07:02 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "2444"
        }
    },
    {
        "timestamp": 1524046006704,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/dev/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:06:46 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "2249"
        }
    },
    {
        "timestamp": 1524046002650,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/dev/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:06:42 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "2309"
        }
    },
    {
        "timestamp": 1524045993937,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/dev/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:06:33 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "2356"
        }
    },
    {
        "timestamp": 1524045970700,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/test/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:06:10 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "2292"
        }
    },
    {
        "timestamp": 1524045966948,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/test/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:06:06 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "2128"
        }
    },
    {
        "timestamp": 1524045958323,
        "info": {
            "method": "GET",
            "path": "/eureka-provider/test/master",
            "headers": {
                "request": {
                    "accept": "application/json, application/*+json",
                    "user-agent": "Java/1.8.0_111",
                    "host": "localhost:8888",
                    "connection": "keep-alive"
                },
                "response": {
                    "X-Application-Context": "config-server:8888",
                    "Content-Type": "application/json;charset=UTF-8",
                    "Transfer-Encoding": "chunked",
                    "Date": "Wed, 18 Apr 2018 10:05:58 GMT",
                    "status": "200"
                }
            },
            "timeTaken": "3241"
        }
    }
]
```
