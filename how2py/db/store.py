import string
import mysql.connector
import random


def get_random_string(length):
    letters = string.ascii_lowercase
    result_str = ''.join(random.choice(letters) for i in range(length))
    return result_str


def insert_db():
    mydb = mysql.connector.connect(
        host="localhost",
        user="root",
        password="nopassword",
        database="db"
    )

    mycursor = mydb.cursor()

    sql = "INSERT INTO user (name, age) VALUES (%s, %s)"

    val = []

    for i in range(1000):
        name = get_random_string(6)
        age = random.randint(0, 100)
        val.append((name, age))

    mycursor.executemany(sql, val)

    mydb.commit()


insert_db()
