#!/bin/bash
read -p "hello, input your age: " age

if (( age > 17 )); then
        echo "You can drink alco"
else
        echo "You can't drink alco"
fi
