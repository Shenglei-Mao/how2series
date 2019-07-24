# for I in "Hello World" "Ah Ha"
# do
# 	echo $I
# done

A=(foo bar baz)
A[5]="cosby ada"
A[10]=jello

# for item in ${A[*]}
# do
# 	echo $item
# done

# for item in ${!A[*]}
# do
# 	echo ${A[$item]}
# done

for ((I = 0; I < ${#A[*]}; I++))
do
	echo ${A[$I]}
done

while read -a Data # Splits on whitespace
do
	echo Read ${#Data[*]} items.
	echo The third item is ${Data[2]}.
done < MyScript.sh