#! /bin/bash
read -p "Enter a number: " num
if (( ${num}< 10 ))
then
printf "The number %d is too small!\n" $num
elif [[ -f ./numbers/${num} ]]
then










printf "The number %d already exists!\n"  $num
else
echo "$num" > /numbers/${num}
fi
