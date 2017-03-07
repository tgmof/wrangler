# Date Functions

Following are some date functions that might be useful in transforming your data. All of
these functions are used in conjunction with 'SET-COLUMN' or 'SET COLUMN' directives.

## Pre-requisite
All of these functions can be applied only after the directive 'PARSE-AS-DATE' or
'PARSE-AS-SIMPLE-DATE' are applied.

## Namespace

All date related functions are in the namespace
```
  date
```

## Example Data

Assume a input JSON as follows

```
{
    "name" : {
        "fname" : "Joltie",
        "lname" : "Root",
        "mname" : null
    },
    "coordinates" : [
        12.56,
        45.789
    ],
    "numbers" : [
        1,
        2.1,
        3,
        null,
        4,
        5,
        6,
        null
    ],
    "moves" : [
        { "a" : 1, "b" : "X", "c" : 2.8},
        { "a" : 2, "b" : "Y", "c" : 232342.8},
        { "a" : 3, "b" : "Z", "c" : null},
        { "a" : 4, "b" : "U"}
    ],
    "integer" : 1,
    "double" : 2.8,
    "float" : 45.6,
    "aliases" : [
        "root",
        "joltie",
        "bunny",
        null
    ]
}
```

Once such a JSON is loaded, you apply the following directives before the function specified in this document can be applied
```
  parse-as-json body
  columns-replace s/body_//g
```

## List of Date Functions

| Function | Description | Examples |
| :------- | :---------- | :------- |
|ARRAY_JOIN(JSON Array, Separator)| Joins all the elements in array with separator. Returns unmodified array if object. Handles nulls | ```set-column alias_list json:ARRAY_JOIN(aliases, ",")``` |
|ARRAY_SUM(JSON Array)|Computes sum over all the elements. Handles 'null' values by skipping. Returns '0' if any elements that are not addable if found | ```set-column sum ARRAY_SUM(numbers)``` |
|ARRAY_MAX(JSON Array)|Computes max over all the elements. Handles 'null' values by skipping. Returns ```0x0.0000000000001P-1022``` if any elements if any issues found | ```set-column max ARRAY_MAX(numbers)``` |
|ARRAY_MIN(JSON Array)|Computes min over all the elements. Handles 'null' values by skipping. Returns ```0x1.fffffffffffffP+1023``` if any elements if any issues found | ```set-column min ARRAY_MIN(numbers)``` |
|ARRAY_LENGTH(JSON Array)|Returns the length of JSON array object, if 'null' return zero | ```set-column length ARRAY_LENGTH(numbers)```|

