# AK42- Day 2
List, Array, Object
use: `Stream.class`

## ex1: int[] numbers = {1,4,5,7,9}
- viết chương trình tính tổng của mảng: `Arrays.stream(numbers).sum()`
- [search] tìm phần tử lớn nhất `Arrays.stream(numbers).max()`
- [search] tìm phần từ bé nhất `Arrays.stream(numbers).min()`
- [filter] lọc tất cả các phần tử >5 `Arrays.stream(array).filter(n -> n>5).toArray()`
- tìm vị trí của 2 phần tử trong mảng, sao cho tổng 2 phần tử đó numbers[i] + numbers [j] = 5 ==> {i,j}

## ex2: Class Object
- Tạo 1 đối tượng Person 
- Có thuộc tính: 
- name (string),
- hair color (string) random in ["red","black","yellow","brown","blue"], 
- skin color (string) radom in ["yellow","white","black"], 
- height (int) radom 50 - 190cm, 
- weight (int) radom 1 - 200kg, 
- year of birth(int) radom 1970 - 2023
- Create 5 person
- tìm người lớn tuổi nhất
- tìm người cao nhất
- tìm người nặng nhất
- tìm người có màu tóc "black"
- tìm người có màu da "yellow"

## ex3: caro: tick tax toe
| |
--+--+--
| |
--+--+--
| |


1 2 3
4 5 6
6 7 9
player choose 1-9
computer: choose random not the same chosen

player_chosen:
computer_chosen :
winner who have chosen index in
{[1,2,3], [4,5,6], [7,8,9], [1,4,6], [2,5,7], [3,6,9], [1,5,9] ,[3,5,6]}
defeated
draw

## ex4: Quiz Game
- include 10 questions
- 1 answer for each (A,B,C, D)
- sum total point of user exam Point/10
```
Q1. Thu do Viet Nam la gi?
A) Ha Noi
B) Ho Chi Minh
C) Da Nang
D) Hue
```