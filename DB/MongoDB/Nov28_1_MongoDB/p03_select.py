from pymongo.mongo_client import MongoClient

con = MongoClient("127.0.0.1")

db = con.nov28

s = db.nov28_lunch.find()

for l in s:
    print(l["_id"])
    print(l["price"])

con.close()
print("Success !")