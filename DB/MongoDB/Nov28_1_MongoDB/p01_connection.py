# -*- coding:utf-8 -*-
from pymongo.mongo_client import MongoClient

# Python + MongoDB

#cmd -> pip install pymongo

con = MongoClient("203.252.32.74")

db = con.nov28

con.close()
print("Success !")