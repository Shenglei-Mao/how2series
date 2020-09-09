def decorator_with_arguments(arg1, arg2):
    def wapper(func):
        def wrapper_accepting_arguments(city_one, city_two):
            print("{0} {1} says: ".format(arg1, arg2), end=" ")
            func(city_one, city_two)

        return wrapper_accepting_arguments

    return wapper


@decorator_with_arguments("Shenglei", "Mao")
def cities(city_one, city_two):
    print("Cities I love are {0} and {1}".format(city_one, city_two))


# equivalent to: cities = (decorator_with_arguments("Shenglei", "Mao"))(cities)
cities("Ningo", "Beijing")
