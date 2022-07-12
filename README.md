# TDD, Yes!
[![CI](https://github.com/VWWL/tdd-yes/actions/workflows/main.yml/badge.svg)](https://github.com/VWWL/tdd-yes/actions/workflows/main.yml)

### Restful Demo:
1. User
   - [Test](./src/test/java/yes/tdd/usecases)
   - [Codes](./modules/users.gateways/src/main/java/yes/tdd/users/gateways/ohs)

### Dojos
1. Args
   - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/args)
   - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/args)
2. Dictionary
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/dictionary)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/dictionary)
3. Employee report
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/employeereport)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/employeereport)
4. Fizzbuzz
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/fizzbuzz)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/fizzbuzz)
5. Foo bar qix
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/foobarqix)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/foobarqix)
6. Gilded rose
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/gildedrose)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/gildedrose)
7. Hello world
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/helloworld)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/helloworld)
8. Lags
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/lags)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/lags)
9. Life game
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/lifegame)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/lifegame)
10. Mars rover
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/marsrover)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/marsrover)
11. Roman calculator
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/romancalculator)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/romancalculator)
12. Unit
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/unit)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/unit)
13. Year
    - [Test](./modules/dojo.domain/src/test/java/yes/tdd/dojo/domain/year)
    - [Codes](./modules/dojo.domain/src/main/java/yes/tdd/dojo/domain/year)
14. Stock trading
在股票买卖场景中，有两个List， A 和 B。 A代表的是股权买入列表（买入份数、单价，时间），B代表的是股权卖出列表（卖出份数，单价，时间 计算：剩余的总份数以及剩余部分的买入总金额

买入list :
~~~
第一次： <1000, 1.5, 2021-01-01>

第二次： <1000, 2.1, 2021-01-05>

第三次： <1000, 1.7, 2021-01-07>

第四次： <1000, 1.1, 2021-01-09>
~~~
~~~
卖出list :

第一次： <2500, 2.2, 2021-01-08>
~~~
~~~
则结果为： <1500, 1950>
~~~
要求：先买的会被先卖，先进先出原则; 每一次买或卖，所有份数的单价都是相同的。

