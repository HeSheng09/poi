### poi

#### 一、授权

> 获取POI需要授权。
>
> 为了保证HTML5中&lt;img&gt;&lt;/img&gt;标签能够直接获取图片，获取图片不需要授权。

* **user** *test_user_0*
* **token** *BV1By4y1W7UP*

#### 二、API

##### 1.localhost:8080/poi/code/{code}

* *description* 根据code获取POI
* *param* code
* *return* 成功返回值如**2.POI返回值**所示

##### 2.localhost:8080/poi/name/{name}

* *description* 根据name获取POI
* *param* name
* *return* 成功返回值如**2.POI返回值**所示

##### 3.localhost:8080/poi/province/{province}

* *description* 根据province获取一组POI
* *param* province
* *return* 成功返回值如**3.POI列表返回值**所示

##### 4.localhost:8080/poi/image?imageName=饶河东北黑蜂

* *description* 根据url获取图片
* *param* imageName
* *return* image

#### 三、返回值格式

##### 1. 一般返回值

* **opr** *拓展操作*

* **data** *数据*

* **status** *状态信息*

    * 0：获取失败

    * 1：获取成功

```json
{
    "opr": null,
    "data": null,
    "status": 1
}
```

##### 2.POI返回值

* **opr** *拓展操作*，即imgUrl，可据此url获取图片
* **data** *数据*，符合geojson格式标准的"Point"类型POI
* **status** *状态信息*

```json
{
    "opr": null,
    "data": {
        "geometry": {
            "coordinates": [
                84.29060363769531,
                41.35825729370117
            ],
            "type": "Point"
        },
        "type": "Feature",
        "properties": {
            "area": 395420,
            "code": "新08",
            "level": "国家级",
            "name": "塔里木胡杨",
            "county": "尉犁县、轮台县",
            "time": "19831008",
            "check": "",
            "type": "荒漠生态",
            "Province": "新",
            "apartment": "林业",
            "object": "胡杨、灰杨林"
        }
    },
    "status": 1
}
```

##### 3.POI列表返回值

* **opr** *拓展操作*，对列表的拓展操作
* **data** *数据*
  * **geojson** 符合*geojson*格式标准的包含列表中所有点的"FeatureCollection"
  * **POIs** *POI列表*。单个POI结构如下：
    * **opr** *拓展操作*，如**2.POI返回值**
    * **feature** 符合*geojson*格式的POI信息，如**2.POI返回值 data**
* **status** *状态信息*

```json
{
  "opr": null,
  "data": {
    "geojson": {
      "features": [
        {
          "geometry": {"coordinates": [80.76238250732422,41.57127380371094],"type": "Point"},
          "type": "Feature",
          "properties": {"area": 380480,"code": "新12","level": "国家级","name": "托木尔峰","county": "温宿县","time": "19800609","check": "","type": "森林生态","Province": "新","apartment": "林业","object": "高山冰川生态系统、森林生态系统及雪豹、"}
        },
        {
          "geometry": {"coordinates": [82.74372863769531, 45.738250732421875], "type": "Point"},
          "type": "Feature",
          "properties": {"area": 115037.296875, "code": "新22", "level": "国家级", "name": "巴尔鲁克山", "county": "裕民县、托里县", "time": "19800401", "check": "2", "type": "森林生态", "Province": "新", "apartment": "林业", "object": "雪岭云杉林、新疆野苹果林、野巴旦杏林以"}
        }
      ],
      "type": "FeatureCollection"
    },
    "POIs": [
      {
        "opr": null,
        "feature": {
          "geometry": {"coordinates": [80.76238250732422, 41.57127380371094], "type": "Point"},
          "type": "Feature",
          "properties": {"area": 380480, "code": "新12", "level": "国家级", "name": "托木尔峰", "county": "温宿县", "time": "19800609", "check": "", "type": "森林生态", "Province": "新", "apartment": "林业", "object": "高山冰川生态系统、森林生态系统及雪豹、"}
        }
      },
      {
        "opr": null,
        "feature": {
          "geometry": {"coordinates": [82.74372863769531, 45.738250732421875], "type": "Point"},
          "type": "Feature",
          "properties": {"area": 115037.296875, "code": "新22", "level": "国家级", "name": "巴尔鲁克山", "county": "裕民县、托里县", "time": "19800401", "check": "2", "type": "森林生态", "Province": "新", "apartment": "林业", "object": "雪岭云杉林、新疆野苹果林、野巴旦杏林以"
          }
        }
      }
    ]
  },
  "status": 1
}
```

