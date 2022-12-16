# -*- coding:utf-8 -*-
from http.client import HTTPConnection
from json import loads
from pymongo.mongo_client import MongoClient

#http://openAPI.seoul.go.kr:8088/(인증키)/xml/SearchParkInfoService/1/5/
#4f626857416f6c6c3632586a416843
hc = HTTPConnection("openAPI.seoul.go.kr:8088")
hc.request("GET", "/4f626857416f6c6c3632586a416843/json/SearchParkInfoService/1/132/")
res = hc.getresponse().read()
park = loads(res)

#전체 공원 데이터 중에
#    공원이름(PK), 공원 소개, 개원일, 주소
#    -> MongoDB에 넣고
con = MongoClient("127.0.0.1")
db = con.nov28


# for r in park["SearchParkInfoService"]["row"]:
    # # print(f"{r['P_PARK']}")
    # # print(f"{r['P_LIST_CONTENT']}")
    # # print(f"{r['OPEN_DT']}")
    # # print(f"{r['P_ADDR']}")
    # # print("=========================")
    # db.nov28_park.insert_one(
        # {"_id" : r["P_PARK"],"introduce" : r["P_LIST_CONTENT"],"OPEN_DT":r["OPEN_DT"],"P_ADDR":r["P_ADDR"]})
# print("success!")

# 다 넣었으면 -> 출력
parks = db.nov28_park.find()
for p in parks:
    print(f"{p['_id']}, {p['introduce']},{p['OPEN_DT']},{p['P_ADDR']}\n")
print("success!")
con.close()
    
    
    
    
    