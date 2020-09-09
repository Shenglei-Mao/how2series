def uppercase_decorator(function):
    def wrapper():
        func = function()
        make_uppercase = func.upper()
        return make_uppercase

    return wrapper


@uppercase_decorator
def hello_world():
    return "hello world"


# equivalent to: hello_world = uppercase_decorator(hello_world)
rst = hello_world()
print(rst)
