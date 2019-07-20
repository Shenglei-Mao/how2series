#! /bin/bash
echo "Hello"
number=10
echo "There are ${number}s of people in the room"
echo "There are $numbers of people in the room"
echo $#
echo $@
echo $0
echo $?
echo $3
echo      $$


if           ((5          == 4 + 1))
then
 echo "The expression res is true"
else
	       echo "you should not see this, you should not pass? ahh"
fi

# exit               0

# echo ece364{a..z}{1..3}

for I in 1 2 3 4 5
do
	echo -n ${I}
done

 echo 

for arg in $@
do
echo $arg
done

while (( (data=$RANDOM) % 10 != 0 ))
do
	echo $data
echo Still no luck
done
echo $data
