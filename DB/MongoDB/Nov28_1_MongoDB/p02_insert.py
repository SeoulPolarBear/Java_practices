from pymongo.mongo_client import MongoClient


# con = MongoClient("203.252.32.74")
con = MongoClient("127.0.0.1")

db= con.nov28

#음식 메뉴와 가격을 입력 받아서 mongodb에 저장
m = input("메뉴 이름 : ")
p = int(input("가격 : " ))

db.nov28_lunch.insert_one({"_id" : m, "price" : p} )

con.close()
print("Success !")