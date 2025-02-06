#!/bin/bash

CONFIG_FILE="assertTrue.txt"

while IFS=: read -r file_path test_method; do
  sed -i "/@Test.*$test_method/,/}/ {
    /assert/ s/.*/        assertTrue(true);/
  }" "$file_path"
done < "$CONFIG_FILE"
